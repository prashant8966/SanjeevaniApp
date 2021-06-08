/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Dao;

import User.dbutil.DBConnection;
import User.pojo.PatientPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Arun
 */
public class PatientDao {
     public static String getNewId()throws SQLException
    {
     
    ResultSet rs =DBConnection.getConnection().createStatement().executeQuery("select max(p_id) from patient");
    int id=1;
   if(rs.next()){
   String ptid=rs.getString(1);
        System.out.println(ptid.substring(2));
   int eno =Integer.parseInt(ptid.substring(2));
       
        id=id+eno;
    
    String sr ="PT"+id;
    System.out.println(sr);
    return sr;  }
   else 
       
      return "PT101";
    }
    
               public static ArrayList getAllDoctorId() throws SQLException{
        String qry="select doctorid from doctors"; 
    ResultSet rs =DBConnection.getConnection().createStatement().executeQuery(qry);
   ArrayList<String> doc=new ArrayList();
    while(rs.next()){
        String docid=rs.getString(1);
        doc.add(docid);
    }
   return doc;
               }
             
   
                   public static ArrayList getAllPatientId() throws SQLException{
        String qry="select p_id from patient"; 
    ResultSet rs =DBConnection.getConnection().createStatement().executeQuery(qry);
   ArrayList<String> pt=new ArrayList();
    while(rs.next()){
        String docid=rs.getString(1);
        pt.add(docid);
    }
   return pt;
               }
                public static boolean addPatient(PatientPojo p) throws SQLException
    {
          Connection conn=DBConnection.getConnection();
    String qry="Insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,p.getPatientid());
    ps.setString(2,p.getFirstname());
    ps.setString(3,p.getSecondname());
    ps.setInt(4,p.getAge());
    ps.setString(5,p.getOPD());
    
    ps.setString(6,p.getGender());
    ps.setString(7,p.getStatus());
    ps.setDate(8,p.getDate());
    ps.setString(9,p.getAddress());
    ps.setString(10,p.getCity());
    ps.setString(11,p.getPhoneno());
    ps.setString(12,p.getDoctorid());
    int x=ps.executeUpdate();
    return x>0;
        
    }
                    public static boolean deletePatient(String id) throws SQLException
    {
          Connection conn=DBConnection.getConnection();
    String qry="delete from patient where p_id=?";
    PreparedStatement ps=conn.prepareStatement(qry);
    
    ps.setString(1,id);
   
    
    int x=ps.executeUpdate();
    return x>0;
        
    }
                       public static boolean UpdatePatient(PatientPojo p) throws SQLException
    {
          Connection conn=DBConnection.getConnection();
    String qry="update patient set f_name=?,s_name=?,age=?,opd=?,gender=?,M_status=?,p_date=?,address=?,city=?,phone_no=?,doctor_id=? where p_id=?";
    PreparedStatement ps=conn.prepareStatement(qry);
   
    ps.setString(1,p.getFirstname());
    ps.setString(2,p.getSecondname());
    ps.setInt(3,p.getAge());
    ps.setString(4,p.getOPD());
    
    ps.setString(5,p.getGender());
    ps.setString(6,p.getStatus());
    ps.setDate(7,p.getDate());
    ps.setString(8,p.getAddress());
    ps.setString(9,p.getCity());
    ps.setString(10,p.getPhoneno());
    ps.setString(11,p.getDoctorid());
     ps.setString(12,p.getPatientid());
    int x=ps.executeUpdate();
    return x>0;
        
    }
                     public static ArrayList<PatientPojo>getALLPatient() throws SQLException
    {
         Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs =st.executeQuery("select * from patient ");
    ArrayList<PatientPojo>empList=new ArrayList();
    while(rs.next()){
     PatientPojo e=new PatientPojo();
e.setPatientid(rs.getString(1));
e.setFirstname(rs.getString(2));
e.setSecondname(rs.getString(3));
e.setAge(rs.getInt(4));
e.setOPD(rs.getString(5));
 e.setGender(rs.getString(6));
e.setStatus(rs.getString(7));
e.setDate(rs.getDate(8));
   e.setAddress(rs.getString(9));
    e.setCity(rs.getString(10));
    e.setPhoneno(rs.getString(11));
 e.setDoctorid(rs.getString(12));
       
        empList.add(e);
          
    }
    return empList;
    }
                               public static ArrayList<PatientPojo>getSinglePatient(String pid) throws SQLException
    {
         Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("select * from patient where p_id=? ");
     ps.setString(1,pid);
    ResultSet rs =ps.executeQuery();
   
    ArrayList<PatientPojo>empList=new ArrayList();
    while(rs.next()){
     PatientPojo e=new PatientPojo();

e.setFirstname(rs.getString(1));
e.setSecondname(rs.getString(2));
e.setAge(rs.getInt(3));
e.setOPD(rs.getString(4));
 e.setGender(rs.getString(5));
e.setStatus(rs.getString(6));
e.setDate(rs.getDate(7));
   e.setAddress(rs.getString(8));
    e.setCity(rs.getString(9));
    e.setPhoneno(rs.getString(10));
 e.setDoctorid(rs.getString(11));
       
        empList.add(e);
          
    }
    return empList;
    }
         
    
    
}
