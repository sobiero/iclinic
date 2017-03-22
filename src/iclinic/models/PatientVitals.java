/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author obiero
 */
@Entity
@Table(name = "patients_vitals")
@NamedQueries({
    @NamedQuery(name = "PatientVitals.findAll", query = "SELECT p FROM PatientVitals p")})
public class PatientVitals implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PatientVitalsPK patientVitalsPK;
    @Column(name = "vital_value")
    private String vitalValue;
    @JoinColumn(name = "patients_visits_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PatientVisit patientVisit;

    public PatientVitals() {
    }

    public PatientVitals(PatientVitalsPK patientVitalsPK) {
        this.patientVitalsPK = patientVitalsPK;
    }

    public PatientVitals(int patientId, int patientsVisitsId) {
        this.patientVitalsPK = new PatientVitalsPK(patientId, patientsVisitsId);
    }

    public PatientVitalsPK getPatientVitalsPK() {
        return patientVitalsPK;
    }

    public void setPatientVitalsPK(PatientVitalsPK patientVitalsPK) {
        this.patientVitalsPK = patientVitalsPK;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientVitalsPK != null ? patientVitalsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientVitals)) {
            return false;
        }
        PatientVitals other = (PatientVitals) object;
        if ((this.patientVitalsPK == null && other.patientVitalsPK != null) || (this.patientVitalsPK != null && !this.patientVitalsPK.equals(other.patientVitalsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iclinic.models.PatientVitals[ patientVitalsPK=" + patientVitalsPK + " ]";
    }
    
}
