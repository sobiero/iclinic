/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.controller;

import iclinic.views.MainWindow;

/**
 *
 * @author obieros
 */
public class PatientController extends BaseController {
    
    public static void Add()
    {
         
        MainWindow.patientForm.setjT("opuk nyawawa");
        MainWindow.patientForm.setVisible(true);
        
   
   
    }
    
    public static void Search()
    {
         
        MainWindow.patientSearchForm.setVisible(true);
   
    }
    
}
