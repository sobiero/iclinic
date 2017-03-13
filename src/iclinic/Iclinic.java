/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic;

import iclinic.models.DbConn;
import iclinic.views.MainWindow;
import iclinic.utils.Password;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author obiero
 */
public class Iclinic {
    
    //public static final Properties CONFIG = new Properties();
    public static final ResourceBundle CONFIG =
            ResourceBundle.getBundle("iclinic/config/config");
    
    public static final DbConn    DB_CONN = new DbConn(CONFIG);
    
    public Iclinic()
    {
        
    }
        
    public static void main(String[] args) 
    {     
        Iclinic app = new Iclinic();
        app.start();
    }
    
    public void start()
    {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); 
        mainWindow.setVisible(true);
    }
    
}
