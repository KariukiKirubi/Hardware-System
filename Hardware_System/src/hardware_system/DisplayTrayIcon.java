/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hardware_system;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Shazka
 */
public class DisplayTrayIcon {
   
    static TrayIcon trayIcon;
            
    public DisplayTrayIcon(){
    ShowTrayIcon();
        }

    private void ShowTrayIcon() {
    if(!SystemTray.isSupported()){
        System.out.println("Error.....");
        System.exit(0);
        return;
      }
    
      final PopupMenu pop = new PopupMenu();
      
      trayIcon = new TrayIcon(CreateIcon("/icons/Tray.png", "Tray Icon"));
      trayIcon.setToolTip("The Hardware Point Of Sale Management Software\nVersion 1.1.0");
      final SystemTray tray = SystemTray.getSystemTray();
    
      
      //Add Components
      MenuItem DBItem = new MenuItem("Database[on/off]");
      MenuItem AboutItem = new MenuItem("About");
      MenuItem Exit = new MenuItem("Exit");
      
      MenuItem Error = new MenuItem("Normal Trigger");
      MenuItem Warning = new MenuItem("Warning Trigger");
      MenuItem Normal = new MenuItem("Normal Trigger");
      MenuItem Info = new MenuItem("Information Trigger");
      
      //Populate The pop up menu
      pop.add(DBItem);
      pop.addSeparator();
      pop.add(AboutItem);
      pop.addSeparator();
      pop.add(Exit);
      
      //Add to Tray Icon
      trayIcon.setPopupMenu(pop);
      
      
      //The Action Events Here
      Exit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
      AboutItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           JOptionPane.showMessageDialog(null,"The  Hardware Point Of Sale Management Software\n Version 1.1.0\n Powered by Shazka Systems ");
        }
    });
       DBItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\wamp\\wampmanager.exe");
                } catch (IOException s) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
         }
    });
      try{
    tray.add(trayIcon);
      }catch(AWTException e){

      }
    }
    
    protected static Image CreateIcon(String path, String desc){
        
        URL ImageURL = DisplayTrayIcon.class.getResource(path);
        return (new ImageIcon(ImageURL,desc)).getImage();
    }
    
}
