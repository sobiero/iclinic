/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.controller;

import iclinic.models.Patient;
import iclinic.views.MainWindow;
import java.awt.Color;

/**
 *
 * @author obieros
 */
public class PatientController extends BaseController {
    
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
           int id = patient.save();
           MainWindow.patientForm.setSaveNotificationText(
                   "Patient saved with ID :" + id, new Color(0, 150, 0));
           MainWindow.patientForm.clearForm();
       
       }catch ( Exception e )
       {
           MainWindow.patientForm.setSaveNotificationText(e.getMessage(),
                  new Color(200, 0, 0) );
       }
       
       
    }
    
    public static void Search()
    {
         
        MainWindow.patientSearchForm.setVisible(true);
   
    }
    
}
