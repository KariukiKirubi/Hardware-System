/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Shazka Systems
 */
public class Progress2 extends javax.swing.JFrame {
        
    Connection conn = null;
       PreparedStatement pst =  null;
       ResultSet rs = null;
     int timeRun = 0;
 private Timer t;
 private ActionListener al;

    /**
     * Creates new form Progress2
     */
    public Progress2() {
        initComponents();
        jLmonth.setVisible(true);
        progress();
         t.start();
        try{
        Thread.sleep(2500);
        }catch(Exception ex){}
        
         new Thread() {
            public void run() {
               
                /*
                 try {
                 Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\wamp\\wampmanager.exe");
                 } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Error");
                 }
                 */
                while (timeRun == 0) {
                    Calendar cal = new GregorianCalendar();

                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    
                     int day=cal.get(Calendar.DAY_OF_MONTH);
                    int month=cal.get(Calendar.MONTH)+1;
                    int year=cal.get(Calendar.YEAR);
                    
                   
                   
                    jLmonth.setText(String.valueOf(month));
                   
                }

            }

        }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        load2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        load1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLmonth = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/details/globe.gif"))); // NOI18N

        load2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/details/Loading-Animated-GIF.gif"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/details/globe.gif"))); // NOI18N

        load1.setFont(new java.awt.Font("Texas LED", 0, 24)); // NOI18N
        load1.setText("Loading . . . ");

        jProgressBar1.setStringPainted(true);

        jLmonth.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(load1)
                .addGap(18, 18, 18)
                .addComponent(jLmonth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jLabel5))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(load2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(load1)
                    .addComponent(jLmonth))
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(load2)
                    .addGap(45, 45, 45)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Progress2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Progress2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Progress2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Progress2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Progress2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLmonth;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel load1;
    private javax.swing.JLabel load2;
    // End of variables declaration//GEN-END:variables
         public void progress(){
   al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
          
                if (jProgressBar1.getValue() < 100) {
                    jProgressBar1.setValue(jProgressBar1.getValue() + 1);
                        //getToolkit().beep();  
                    
                     if(((jProgressBar1.getValue()%5)==0)&&(jProgressBar1.getValue()<90)){
                    //  getToolkit().beep(); 
                    }
                     
                     if(jProgressBar1.getValue()>90){
                     // getToolkit().beep(); 
                    }
                     
                    if(jProgressBar1.getValue()==100){
                        
                    }
                } 
                
                
                
                else {
                    t.stop();
                     dispose(); 
                    checkAct();
                     
                   //  trial kk=new trial();
                    
//                   admin_log log=new admin_log();
//                        log.setVisible(true);
                
                      
                    
                   

       
                }
            }
        };
        t = new Timer(60, al);
        t.start();
        try{
        Thread.sleep(20);
        }catch(Exception ex){}
   }
         
          private void checkAct()
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
                    dispose();
                    m.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "THE TRIAL VERSION HAS EXPIRED.");
                    int p = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO ACTIVATE?", "LEAVE", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (p == 0) {
                       
                    sw_act sw = new sw_act();                   
                    sw.setVisible(true);
                    this.dispose();
                    } else if (p == 1) {
                        System.exit(0);
                    }
                }
       }catch(Exception e)
       {
       
       e.printStackTrace();
       }
    }
           public String month(){
              return jLmonth.getText();
              }
}