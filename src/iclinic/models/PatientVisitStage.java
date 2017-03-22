/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author obiero
 */
@Entity
@Table(name = "patients_visits_stages")
@NamedQueries({
    @NamedQuery(name = "PatientVisitStage.findAll", query = "SELECT p FROM PatientVisitStage p")})
public class PatientVisitStage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "stage_name")
    private String stageName;
    @Column(name = "stage_desc")
    private String stageDesc;
    @OneToMany(mappedBy = "visitStageId")
    private Collection<PatientVisit> patientVisitCollection;

    public PatientVisitStage() {
    }

    public PatientVisitStage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageDesc() {
        return stageDesc;
    }

    public void setStageDesc(String stageDesc) {
        this.stageDesc = stageDesc;
    }

    public Collection<PatientVisit> getPatientVisitCollection() {
        return patientVisitCollection;
    }

    public void setPatientVisitCollection(Collection<PatientVisit> patientVisitCollection) {
        this.patientVisitCollection = patientVisitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientVisitStage)) {
            return false;
        }
        PatientVisitStage other = (PatientVisitStage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iclinic.models.PatientVisitStage[ id=" + id + " ]";
    }
    
}
