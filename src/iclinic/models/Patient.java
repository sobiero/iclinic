/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.models;

import static iclinic.models.BaseModel.DB_CONN;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author obiero
 */

public class Patient extends BaseModel  {

    public static Connection conn   = DB_CONN.getConn();
    public static String tableName  = "patients";

    public static List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    private Integer id = null;
    
    private String title;
    
    private String surname;
   
    private String fname;
   
    private String dob;
   
    private String gender;
 
    private String studentId;
   
    private String nhif;
  
    private Integer addedByUserId;
  
    private Date dateAdded;

    public Patient() {
    }

    public Patient(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        
        String g ="";
        switch(gender)
        {
            case "Male":
                g = "M";
                break;
            case "Female":
                g = "F";
                break;
            default:
                g = "O";
        }
        
        this.gender = g;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getNhif() {
        return nhif;
    }

    public void setNhif(String nhif) {
        this.nhif = "".equals(nhif.trim()) ? null : nhif ;
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
    
    
    public static <list>Patient find(String params)
    {
       // String qry = "SELECT * FROM " + tableName ;
    
        return new Patient();
    }
    
    public static Patient findFirst(String params)
    {
        // String qry = "SELECT * FROM " + tableName ;
    
        return new Patient();
    }
    
    public int save () throws Exception
    {
        int id = 0;
        
        String qry = "INSERT INTO patients ( title, surname," +
                     "fname, dob, gender," +
                     "student_id, nhif, " +
                     "added_by_user_id, date_added ) "+
                     "VALUES (?,?,?,?,?,?,?,?,?) " ;

        try 
        {    
            PreparedStatement stmt = conn.prepareStatement(qry, 
                                        PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, this.getTitle());
            stmt.setString(2, this.getSurname());
            stmt.setString(3, this.getFname());
            stmt.setString(4, this.getDob());
            stmt.setString(5, this.getGender());
            stmt.setString(6, this.getStudentId());
            stmt.setString(7, this.getNhif());
            stmt.setInt(8, this.getAddedByUserId());
            stmt.setString(9, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
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

    public ArrayList<Patient> getAllPatients()
    {
        ArrayList<Patient> customers = new ArrayList<Patient>();
    Patient customer = null;
    Connection c;
    try {
        c = openConnection();
        Statement statement = c.createStatement();
        String s = "SELECT * FROM customer";

        ResultSet rs = statement.executeQuery(s);
        int g =0;

        while (rs.next()) {

            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));

            customer.setAddress(rs.getString("address"));
            customer.setPhone(rs.getString("phone"));
            customer.setEmail(rs.getString("email"));
            customer.setStudentId(rs.getString("studentid"));
            customer.setTotalsale(rs.getInt("totalsale"));

            customers.add(customer);
        }

        rs.close();
    } catch (Exception e) {
        System.out.println(e);
    }

        return patients;
    }
    
}
