package hardware_system;


import hardware_system.Activationz;
import hardware_system.Connect;
import hardware_system.admin_log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Shazka Systems
 */
public class Active extends javax.swing.JFrame {
         int timeRun = 0;
    int tymerun;
        Connection conn = null;
       PreparedStatement pst =  null;
       ResultSet rs = null;
    /**
     * Creates new form Active
     */
    public Active() {
        initComponents();
        
        new Thread() {
            public void run() {
                
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
        
        k();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLmonth = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLmonth.setText("6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLmonth)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLmonth)
        );

        pack();
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
            java.util.logging.Logger.getLogger(Active.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Active.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Active.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Active.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Active().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLmonth;
    // End of variables declaration//GEN-END:variables

        public void k(){
       // int hh=Integer.parseInt(jLmonth.getText());
        Progress2 hh=new Progress2();
        String month=hh.month();
        
        if("3".equals(month)||"4".equals(month)||"5".equals(month)||"6".equals(month)){
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
                    this.dispose();
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
        }
}
