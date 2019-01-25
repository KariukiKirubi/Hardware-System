package sellstock;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Shazka
 *
 
 */

public class Printsupport {
      Connection conn = null;
        Statement stm=null;
       PreparedStatement pst =  null;
       ResultSet rs = null;
 
         static JTable itemsTable;
         public static  int total_item_count=30;
         public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss a";
         public  static String title[] = new String[] {"Item Name"," Price"," Qty"," Amount"};
	
public static void setItems(Object[][] printitem){
        Object data[][]=printitem;
        DefaultTableModel model = new DefaultTableModel();
       //assume jtable has 4 columns.
        model.addColumn(title[0]);
        model.addColumn(title[1]);
        model.addColumn(title[2]);
        model.addColumn(title[3]);
    
        

        int rowcount=printitem.length;
        
        addtomodel(model, data, rowcount);
       

        itemsTable = new JTable(model);
}

public static void addtomodel(DefaultTableModel model,Object [][]data,int rowcount){
        int count=0;
        while(count < rowcount){
         model.addRow(data[count]);
         count++;
        }
        if(model.getRowCount()!=rowcount)
          addtomodel(model, data, rowcount);
        
       // System.out.println("Check Passed.");
}
          
public Object[][] getTableData (JTable table) {
    int itemcount=table.getRowCount();
   // System.out.println("Item Count:"+itemcount);
    
    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
    int nRow = dtm.getRowCount(), nCol =dtm.getColumnCount();
    Object[][] tableData = new Object[nRow][nCol];
    if(itemcount==nRow)                                        //check is there any data loss.
    {
    for (int i = 0 ; i < nRow ; i++){
        for (int j = 0 ; j < nCol ; j++){
            tableData[i][j] = dtm.getValueAt(i,j);           //pass data into object array.
            }}
     if(tableData.length!=itemcount){                      //check for data losses in object array
     getTableData(table);                                  //recursively call method back to collect data
     }   
   // System.out.println("Data check passed");
    }
    else{
                                                           //collecting data again because of data loss.
   getTableData(table);
   }
   return tableData;                                       //return object array with data.
    }     

public static PageFormat getPageFormat(PrinterJob pj){
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();    
             
                double middleHeight =total_item_count*1.0;  //dynamic----->change with the row count of jtable
                double headerHeight = 5.0;                  //fixed----->but can be mod
        	double footerHeight = 5.0;                  //fixed----->but can be mod
                
                double width = convert_CM_To_PPI(7);      //printer know only point per inch.default value is 72ppi
        	double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
            paper.setSize(width, height);
            paper.setImageableArea(
                            convert_CM_To_PPI(0.25), 
                            convert_CM_To_PPI(0.5), 
                            width - convert_CM_To_PPI(0.35), 
                            height - convert_CM_To_PPI(1));   //define boarder size    after that print area width is about 180 points
            
            pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
            pf.setPaper(paper);    
            
            return pf;
            
}
        
        
protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}

protected static double toPPI(double inch) {            
	        return inch * 72d;            
}

public static String now() {
//get current date and time as a String output   
Calendar cal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
return sdf.format(cal.getTime());

}

public static String grandtotal() {
SellStock1 gg=new SellStock1();
String t=gg.total();
 return t;
}

public static String c_user() {
SellStock1 gg=new SellStock1();
String t=gg.user();
 return t;
}

public static String rcpt_no() {
SellStock1 gg=new SellStock1();
String t=gg.recept_number();
 return t;
}
         

public static class MyPrintable implements Printable {
 @Override
  public int print(Graphics graphics, PageFormat pageFormat, 
	                int pageIndex) throws PrinterException {    
	                int result = NO_SUCH_PAGE;    
	                if (pageIndex == 0) {                    
	                Graphics2D g2d = (Graphics2D) graphics;                    
	                             
	                double width = pageFormat.getImageableWidth();
	                double height = pageFormat.getImageableHeight();    
	                g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 
	                Font font = new Font("Monospaced",Font.PLAIN,8);       
	                g2d.setFont(font);
                       
	                
	                try {
	        	/*
                         * Draw Image*
                           assume that printing reciept has logo on top 
                         * that logo image is in .gif format .png also support
                         * image resolution is width 100px and height 50px
                         * image located in root--->image folder 
                         */
                                    int x=20 ;                                        //print start at 100 on x axies
                                    int y=0;                                          //print start at 10 on y axies
                                    int imagewidth=150;
                                    int imageheight=70;
                          BufferedImage read = ImageIO.read(getClass().getResource("/icons/log4.png"));
                          g2d.drawImage(read,x,y,imagewidth,imageheight,null);         //draw image
                        
                          g2d.drawString("Githunguri ", 0,37);
                           g2d.drawString("  Utawala", 0,47);
                            g2d.drawString("***RCPT"+rcpt_no()+"***", 0,62);
                           
                             g2d.drawString("Cell Number :-", 128,37);
                               g2d.drawString("0722 833 093", 128,52);
                          g2d.drawString("0721 942 884", 128,62);
                         //  g2d.drawString("-----------------------------------------------------------------------", 0,y+72);
                          g2d.drawLine(0, y+72, 200, y+72);                          //draw line
                                 } catch (IOException e) {
	        			e.printStackTrace();
	        		}
      		try{
	        /*Draw Header*/
                    int y=80;
	              g2d.drawString("Dealers in general hardware,timber,", 0,y);
                      g2d.drawString("stones,gum poles,timber work services", 0,y+10);
	                            //shift a line by adding 10 to y value
	             g2d.drawString("block boards,MDF ceiling boards,etc ", 0,y+20);
//                      g2d.drawString("TIME  "+now(), 30, y+30);                                //print date
//	              g2d.drawString("Served By : "+c_user(), 30, y+40);  
	        		
	              /*Draw Colums*/
                      g2d.drawLine(0, y+27, 200, y+27);
                     //  g2d.drawString("-----------------------------------------------------------------------", 0,y+47);
                      g2d.drawString(title[0], 10 ,y+35);
                      g2d.drawString(title[1], 95 ,y+35);
                      g2d.drawString(title[2], 128 ,y+35);
                      g2d.drawString(title[3], 155 ,y+35);
                      
                    //   g2d.drawString("-----------------------------------------------------------------------", 0,y+60);
                      g2d.drawLine(00, y+40, 200, y+40);
                       
                   
	              int cH = 0;
	              TableModel mod = itemsTable.getModel();
                        
	              for(int i = 0;i < mod.getRowCount() ; i++){
	                	/*Assume that all parameters are in string data type for this situation
                                 * All other premetive data types are accepted.
                                */
	                	String itemid = mod.getValueAt(i, 0).toString();
	                	String itemname = mod.getValueAt(i, 1).toString();
                                String price = mod.getValueAt(i, 2).toString();
                                String quantity = mod.getValueAt(i, 3).toString();
                                
	                	
	                	cH = (y+50) + (10*i);                             //shifting drawing line
	                	
	                	g2d.drawString(itemid, 0, cH);
	                	g2d.drawString(itemname,105, cH);
	                	g2d.drawString(price , 132, cH);
                                g2d.drawString(quantity , 160, cH);
                                
//                              System.out.println( mod.getRowCount());
//                               System.out.println( mod.getRowCount());
                               
                               
                              
                                  
	                }
                    
                                 /*Footer*/
	                 font = new Font("Arial",Font.PLAIN,11) ;                  //changed font size
	                g2d.setFont(font);
                      
                        
                        g2d.drawString("----------------------------------------------------------------------- ",0, cH+10);
                        g2d.drawString("Grand Total             "+grandtotal(),50, cH+20);
                       g2d.drawString("----------------------------------------------------------------------- ",0, cH+30);
                       
                       font = new Font("Monospaced",Font.PLAIN,8) ;                  //changed font size
	                g2d.setFont(font);
                       g2d.drawString("TIME  "+now(), 30, cH+45);                                //print date
	              g2d.drawString("Served By : "+c_user(), 30, cH+55);
                       
                       font = new Font("Gabriola",Font.PLAIN,10) ;                  //changed font size
	                g2d.setFont(font);
                         g2d.drawString("  Goods Once Sold Cannot Be Re-accepted.Thank You. ",10, cH+75);
                                                                                 //end of the reciept
            }
            catch(Exception r){
              r.printStackTrace();
            }
               
  
	                result = PAGE_EXISTS;    
	            }    
	            return result;    
      }
   }
         
}


