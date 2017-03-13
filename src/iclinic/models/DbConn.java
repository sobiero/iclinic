/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.models;

/**
 *
 * @author obiero
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class DbConn {
   
    private static Connection conn = null;
    //private static Properties config = null;
    private static ResourceBundle config = null;
    
    public DbConn(ResourceBundle conf )
    {
      config = conf;  
    }
    
    public Connection getConn(){
                
        String url = config.getString("dbUrl");
        String username = config.getString("dbUser");
        String password = config.getString("dbPassword");
        //System.out.println("Connecting database..." );
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, username, password);
            //System.out.println("Database connected!");           
        } catch (ClassNotFoundException | SQLException  e) {
            
            System.out.println("SQL-Exception: " + e.getMessage());
              
        }        
        catch (Exception e) {
            //throw new IllegalStateException("Cannot connect the database!", e);
            System.out.println("Exception: " + e.getMessage());
        }
    
        return conn;
    
    }
    
    public void close()
    {
        try {
            if (conn != null) { conn.close(); }

        } catch (SQLException e)
        {
           System.out.println("Exception while closing Connection: " + e.getMessage()); 
        }
            
    }    
}
