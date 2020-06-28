/**
 * 
 */
package jPanel;

import java.sql.SQLException;
import java.sql.*;


/**
 * @author HP
 *
 */
public class Connexion {

	public static Connection GetCon() 
    
    { 
        try {
             
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con = DriverManager.getConnection("jdbc:mysql://3.15.163.25:3306/GestionEvents","oumaima","oumaima1300");
        return con;
            
        } catch (Exception e) {
             System.err.println(e.getMessage());
             return null ;
        }
       
    
    }
}


