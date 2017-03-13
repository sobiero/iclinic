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

import iclinic.Iclinic;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class User extends BaseModel {
    
    public static Connection conn   = DB_CONN.getConn();
    public static String tableName  = "user";
    
    //Table fields
    private String username          = null;
    private String password          = null;
    private int id                   = 0;
    
    
    public int getId()
    {
        return id;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String p)
    {
        password = p;
    }   
   
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String u)
    {
        username = u;
    } 
    
    
    
    
    public User()
    {
        
    }
    
    public static User find(String params)
    {
       // String qry = "SELECT * FROM " + tableName ;
    
        return new User();
    }
    
    public static User findByUsername(String username)
    {        
        User user = new User();
        
        try {

            String qry = "SELECT * FROM " + tableName + " WHERE username = ? LIMIT 1" ;
            
            PreparedStatement findUser = conn.prepareStatement(qry);
            findUser.setString(1, username);
            ResultSet rs = findUser.executeQuery();
            
            while (rs.next()) 
            {
               user.id       = rs.getInt("id");
               user.username = rs.getString("username");   
               user.password = rs.getString("password");                
            }
        
        } catch (SQLException e) {
            //throw new IllegalStateException("Cannot connect the database!", e);
            System.out.println("SQL-Exception: " + e.getMessage());
           
        } catch (Exception e) {
            //throw new IllegalStateException("Cannot connect the database!", e);
            System.out.println("Exception: " + e.getMessage());
        } finally {
                
            
        }
        
        return user;

    }
    
    public int save()
    {
        
      //  String insert
        
        
        return 0;
    }
}
