/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.models;

import java.io.Serializable;


/**
 *
 * @author obiero
 */

public class PatientVitals implements Serializable {


    private String vitalValue;

    private PatientVisit patientVisit;

    public PatientVitals() {
    }
    /*
    public PatientVitals(PatientVitalsPK patientVitalsPK) {
        this.patientVitalsPK = patientVitalsPK;
    }
*/

    public String getVitalValue() {
        return vitalValue;
    }

    public void setVitalValue(String vitalValue) {
        this.vitalValue = vitalValue;
    }

    public PatientVisit getPatientVisit() {
        return patientVisit;
    }

    public void setPatientVisit(PatientVisit patientVisit) {
        this.patientVisit = patientVisit;
    }
 
}
