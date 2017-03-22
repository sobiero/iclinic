/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author obiero
 */
@Embeddable
public class PatientVitalsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "patient_id")
    private int patientId;
    @Basic(optional = false)
    @Column(name = "patients_visits_id")
    private int patientsVisitsId;

    public PatientVitalsPK() {
    }

    public PatientVitalsPK(int patientId, int patientsVisitsId) {
        this.patientId = patientId;
        this.patientsVisitsId = patientsVisitsId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientsVisitsId() {
        return patientsVisitsId;
    }

    public void setPatientsVisitsId(int patientsVisitsId) {
        this.patientsVisitsId = patientsVisitsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) patientId;
        hash += (int) patientsVisitsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientVitalsPK)) {
            return false;
        }
        PatientVitalsPK other = (PatientVitalsPK) object;
        if (this.patientId != other.patientId) {
            return false;
        }
        if (this.patientsVisitsId != other.patientsVisitsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iclinic.models.PatientVitalsPK[ patientId=" + patientId + ", patientsVisitsId=" + patientsVisitsId + " ]";
    }
    
}
