/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author obiero
 */
@Entity
@Table(name = "patients_visits")
@NamedQueries({
    @NamedQuery(name = "PatientVisit.findAll", query = "SELECT p FROM PatientVisit p")})
public class PatientVisit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "visit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitDate;
    @JoinColumn(name = "visit_stage_id", referencedColumnName = "id")
    @ManyToOne
    private PatientVisitStage visitStageId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientVisit")
    private Collection<PatientVitals> patientVitalsCollection;

    public PatientVisit() {
    }

    public PatientVisit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public PatientVisitStage getVisitStageId() {
        return visitStageId;
    }

    public void setVisitStageId(PatientVisitStage visitStageId) {
        this.visitStageId = visitStageId;
    }

    public Collection<PatientVitals> getPatientVitalsCollection() {
        return patientVitalsCollection;
    }

    public void setPatientVitalsCollection(Collection<PatientVitals> patientVitalsCollection) {
        this.patientVitalsCollection = patientVitalsCollection;
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
        if (!(object instanceof PatientVisit)) {
            return false;
        }
        PatientVisit other = (PatientVisit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "iclinic.models.PatientVisit[ id=" + id + " ]";
    }
    
}
