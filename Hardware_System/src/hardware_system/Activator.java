/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Shazka Systems
 */
public class Activator {
    int tymrun=0;
     Connection conn = null;
       PreparedStatement pst =  null;
       ResultSet rs = null;
    
    public void kk(){
        
        new Thread() {
            public void run() {
               
                /*
                 try {
                 Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\wamp\\wampmanager.exe");
                 } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Error");
                 }
                 */
                while (tymrun == 0) {
                    Calendar cal = new GregorianCalendar();

                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    
                     int day=cal.get(Calendar.DAY_OF_MONTH);
                    int month=cal.get(Calendar.MONTH)+1;
                    int year=cal.get(Calendar.YEAR);
                    
                   if(month==3||month==4||month==5||month==6){
                        admin_log m = new admin_log();
                    
                    m.setVisible(true);
                   }else
                   {
                     Connect connectobj = new Connect();
        conn = connectobj.connectdb();
        
       try{
           String confirm ="SELECT * FROM `activation`";
                pst = conn.prepareStatement(confirm);
               // pst.setString(1, Adm_No.getText());
                rs = pst.executeQuery();
                
                if(rs.next())
                {
                    admin_log m = new admin_log();
                    
                    m.setVisible(true);
                }else{
                    Activationz sw = new Activationz();
                   
                    sw.setVisible(true);
                }
       }catch(Exception e)
       {
       
       e.printStackTrace();
       }
                   
                   }
                   
                }

            }

        }.stop();
    
      
    }
    
}
