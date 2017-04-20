/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.models;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author obiero
 */
public class PatientComboBoxModel extends DefaultComboBoxModel<Patient> {
 
    public PatientComboBoxModel(ArrayList<Patient> patients) 
    {
        super();
        for (Patient patient: patients)
        {
           addElement(patient);
        } 
    }

    @Override
    public Patient getSelectedItem() {
        Patient selectedPatient = (Patient) super.getSelectedItem();
        // do something with this job before returning...
        return selectedPatient;
    }
}