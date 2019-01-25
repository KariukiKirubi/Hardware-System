package sellstock;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KARIS
 */

public class Connect {
    Connection conn = null;
    PreparedStatement pst = null;
    Statement stmtn = null;
    public Connection connectdb(){
    
       String dbnam = "hardware";
       String usernam = "root";
       String password = "";
       String Driver = "com.mysql.jdbc.Driver";
       String url = "jdbc:mysql://localhost:3306/";
       
       try{
       Class.forName(Driver);
       conn = DriverManager.getConnection(url+dbnam,usernam,password);              
//       JOptionPane.showMessageDialog(null,"Connection Successfull");
       
       
       return conn;
       
       }
       catch(Exception ex){
//       JOptionPane.showMessageDialog(null, "vghbnj");
       return conn;
       }            
            
        
        }
    
    
    }

