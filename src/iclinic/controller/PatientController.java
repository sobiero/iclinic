/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.controller;

import static iclinic.models.BaseModel.DB_CONN;
import iclinic.models.Patient;
import iclinic.models.PatientContact;
import iclinic.views.MainWindow;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author obieros
 */
public class PatientController extends BaseController {
    
    
    public static Connection conn   = DB_CONN.getConn();
    
    public static void Add()
    {      
        //MainWindow.patientForm.setjT("opuk nyawawa");
       MainWindow.patientForm.setVisible(true);
   
    }
    
    public static void Save()
    {
      
        
        
        Patient patient = new Patient();
       //jComboTitle
       patient.setTitle((String)MainWindow.patientForm.jComboTitle
                        .getSelectedItem());
       patient.setSurname(MainWindow.patientForm.jTextSurname.getText());
       patient.setFname(MainWindow.patientForm.jTextFirstName.getText());
       patient.setDob(MainWindow.patientForm.jTextDoB.getText());
       patient.setGender((String)MainWindow.patientForm.jComboGender
               .getSelectedItem());
       patient.setStudentId(MainWindow.patientForm.jTextStdID.getText());
       patient.setNhif(MainWindow.patientForm.jTextNhif.getText());
       patient.setAddedByUserId(1);
       
       try
       {
           conn.setAutoCommit(false);
            
           int id = patient.save();
           
           PatientContact patientContact = new PatientContact();
           
           patientContact.setAddedByUserId(1);
           patientContact.setPatientId(id);
           patientContact.setNextOfKinName(MainWindow.patientForm
                   .jTextNextOfKin.getText());
           
           patientContact.setEmergencyPhone(MainWindow.patientForm
                   .jTextEmergencyNbr.getText());
           
           patientContact.setAddress(MainWindow.patientForm
                   .jTextAddress.getText());
           
           patientContact.setCity(MainWindow.patientForm.jTextCity.getText());
           patientContact.setMobile(MainWindow.patientForm.jTextMobile
                   .getText());
           
           patientContact.save();
           
           MainWindow.patientForm.setSaveNotificationText(
                   "Patient saved with ID :" + id, new Color(0, 150, 0));
           MainWindow.patientForm.clearForm();
           
           conn.commit();
       
       }catch ( Exception e )
       {
           MainWindow.patientForm.setSaveNotificationText(e.getMessage(),
                  new Color(200, 0, 0) );
           try
           { 
            conn.rollback();
           }
           catch (SQLException e2)
           {
           
           }
       }
       
       
    }
    
    public static void Search()
    {
         
        MainWindow.patientSearchForm.setVisible(true);
   
    }
    
}
