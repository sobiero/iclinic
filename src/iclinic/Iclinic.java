/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic;

import iclinic.models.DbConn;
import iclinic.models.Student;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author obiero
 */
public class Iclinic {
    /**
     * @param args the command line arguments
     */

    public static Properties config = new Properties();
    private static DbConn dbConn = new DbConn(config);
        
    public static void main(String[] args) {
        
       InputStream input = null; 
       try {

		input = new FileInputStream("src/iclinic/config/config.properties");
		config.load(input);


	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        
        Student std = new Student(dbConn);
        
        //System.out.println(std.getFname());
         
    }
    
}
