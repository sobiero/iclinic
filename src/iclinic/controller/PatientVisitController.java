/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.controller;

import static iclinic.models.BaseModel.DB_CONN;
import iclinic.models.PatientVisit;
import iclinic.models.Patient;
import iclinic.models.PatientContact;
import iclinic.views.MainWindow;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author obieros
 */
public class PatientVisitController extends BaseController {
    
    
    public static Connection conn   = DB_CONN.getConn();
    
    public static void Add()
    {      
        //MainWindow.patientForm.setjT("opuk nyawawa");
       MainWindow.patientForm.setVisible(true);
   
    }
    
    public static void Save(Patient patient)
    { 
       Integer patient_id = patient.getId();
       
       try
       {
           conn.setAutoCommit(false);
           
           PatientVisit patientVisit = new PatientVisit();
           
           patientVisit.setPatientId(patient_id);
           patientVisit.setVisitStageId(2);
           patientVisit.setVisitDate( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                                .format(new Date()));
           
           Integer id = patientVisit.save();
           
           MainWindow.patientSearchForm.setSaveNotificationText(
                   "Patient Visit :" + id, new Color(0, 150, 0));
           //MainWindow.patientSearchForm.clearForm();
           
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
