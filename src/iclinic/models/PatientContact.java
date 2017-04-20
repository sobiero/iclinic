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

public class PatientContact extends BaseModel {


    public static Connection conn   = DB_CONN.getConn();
    public static String tableName  = "patients_contacts";
    
    private Integer id;
    
    private String nextOfKinName;
    
    private Integer patientId;
   
    private String emergencyPhone;
  
    private String address;
  
    private String city;
   
    private String mobile;
 
    private Integer addedByUserId;
   
 
    private Date dateAdded;

    public PatientContact() {
    }

    public PatientContact(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNextOfKinName() {
        return nextOfKinName;
    }

    public void setNextOfKinName(String nextOfKinName) {
        this.nextOfKinName = nextOfKinName;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAddedByUserId() {
        return addedByUserId;
    }

    public void setAddedByUserId(Integer addedByUserId) {
        this.addedByUserId = addedByUserId;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
    
    public int save () throws Exception
    {
        int id = 0;
        
        String qry = "INSERT INTO patients_contacts "
                + "( patient_id, next_of_kin_name, "
                + "emergency_phone, address, "
                + "city, mobile, added_by_user_id,"
                + " date_added) VALUES (?,?,?,?,?,?,?,?)";

        try 
        {    
            PreparedStatement stmt = conn.prepareStatement(qry, 
                                        PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, this.getPatientId());
            stmt.setString(2, this.getNextOfKinName());
            stmt.setString(3, this.getEmergencyPhone());
            stmt.setString(4, this.getAddress());
            stmt.setString(5, this.getCity());
            stmt.setString(6, this.getMobile());
            stmt.setInt(7, 1);
            stmt.setString(8, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                                .format(new Date()));
            
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
