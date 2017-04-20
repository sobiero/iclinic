/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.models;

import static iclinic.models.BaseModel.DB_CONN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author obiero
 */

public class PatientVisit extends BaseModel {

    public static Connection conn   = DB_CONN.getConn();
    public static String tableName  = "patients_contacts";
   
    private Integer id;
    
    private Integer patientId;
     
    private String visitDate;
    
    private Integer visitStageId;

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
    
     public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getVisitStageId() {
        return visitStageId;
    }

    public void setVisitStageId(Integer visitStageId) {
        this.visitStageId = visitStageId;
    }

    public int save () throws Exception
    {
        int id = 0;
        
        String qry = "INSERT INTO patients_visits "
                + "( patient_id, visit_date, "
                + "visit_stage_id)"
                + " VALUES (?,?,?)";

        try 
        {    
            PreparedStatement stmt = conn.prepareStatement(qry, 
                                      PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, this.getPatientId());
            stmt.setString(2, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                                .format(new Date()));
            stmt.setInt(3, this.getVisitStageId());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                id =rs.getInt(1);
            }
            
            System.out.println(id);
            
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
            throw new Exception( e.getMessage() );            
	} 
        finally 
        {
            /*
	    if (stmt != null) {
		stmt.close();
	    }
            */
	}
        
       return id; 
    }

    
    
}
