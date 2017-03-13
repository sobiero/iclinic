/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author obiero
 */
public class Student {
    
    public Student(DbConn dbConn)
    {
 
        try {
            
            Connection conn = dbConn.getConn();
            conn.setAutoCommit(false);
            String qry = "SELECT LName FROM student WHERE FName = ?";
            
            PreparedStatement findStd = conn.prepareStatement(qry);
            
            findStd.setString(1, "Mumbi");
            
            ResultSet rs = findStd.executeQuery();
            
            while (rs.next()) {
                String lastName = rs.getString("LName");
                System.out.println(lastName);
            }

            
        } catch (SQLException e) {
            //throw new IllegalStateException("Cannot connect the database!", e);
            System.out.println("SQL-Exception: " + e.getMessage());
           
        } catch (Exception e) {
            //throw new IllegalStateException("Cannot connect the database!", e);
            System.out.println("Exception: " + e.getMessage());
        } finally {
                
            
        }
       dbConn.close();
    }
    
    public String getFname()
    {
       
        return "";
    }
    
}
