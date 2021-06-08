/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Dao;

import User.dbutil.DBConnection;
import User.pojo.EmpPojo;
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
public class EmpDao {
    public static String getNewId()throws SQLException
    {
     Connection conn=DBConnection.getConnection();
     Statement st=conn.createStatement();
    ResultSet rs =st.executeQuery("select max(Empid) from employees");
    int id=1;
   rs.next();
   String empid=rs.getString(1);
   int eno =Integer.parseInt(empid.substring(1));
       
        id=id+eno;
    
    String sr ="E"+id;
    System.out.println(sr);
    return sr;  
    }
    public static boolean addEmployee(EmpPojo e)throws SQLException{
       Connection conn=DBConnection.getConnection();
    String qry="Insert into employees values(?,?,?,?)";
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,e.getEmpid());
    ps.setString(2,e.getEmpname());
    ps.setString(3,e.getJob());
    ps.setDouble(4,e.getSal());
    
    int x=ps.executeUpdate();
    return x==1;
        
    } 
    public static ArrayList<EmpPojo>getALLEmp() throws SQLException
    {
         Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs =st.executeQuery("select * from employees");
    ArrayList<EmpPojo>empList=new ArrayList();
    while(rs.next()){
        EmpPojo e=new EmpPojo();
        e.setEmpid(rs.getString(1));
        e.setEmpname(rs.getString(2));
        e.setJob(rs.getString(3));
        e.setSal(rs.getDouble(4));
        empList.add(e);
    }
    return empList;
        
    }
    public static HashMap<String,String> getNonRegisteredReceptionistList() throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select empid,empname from employees where role='receptionist' and empid not in (select empid from users where usertype='receptionist')";
    Statement st=conn.createStatement();  
    ResultSet rs =st.executeQuery(qry);
    HashMap<String,String> receptionist=new HashMap();
    while(rs.next()){
        String id=rs.getString(1);
        String name=rs.getString(2);
        receptionist.put(id,name);
        
    }
    return receptionist;
    }
      public static HashMap<String,String> getRegisteredReceptionistList() throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select empid,username from users where usertype='receptionist' ";
    Statement st=conn.createStatement();  
    ResultSet rs =st.executeQuery(qry);
    HashMap<String,String> receptionist=new HashMap();
    while(rs.next()){
        String id=rs.getString(1);
        String name=rs.getString(2);
        receptionist.put(id,name);
        
    }
    return receptionist;
    }
        public static HashMap<String,String> getEmployeeList() throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select empid,empname from employees  ";
    Statement st=conn.createStatement();  
    ResultSet rs =st.executeQuery(qry);
    HashMap<String,String> employee=new HashMap();
    while(rs.next()){
        String id=rs.getString(1);
        String name=rs.getString(2);
        employee.put(id,name);
        
    }
    return employee;
    }
         public static boolean deleteEmployee(String emp) throws SQLException
    {
          Connection conn=DBConnection.getConnection();
    String qry="delete from employees where empid=?";
    PreparedStatement ps=conn.prepareStatement(qry);
    
    ps.setString(1,emp);

   
    
    int x=ps.executeUpdate();
    return x>0;
        
    }
               public static boolean UpdateDoctor(EmpPojo e) throws SQLException
    {
          Connection conn=DBConnection.getConnection();
    String qry="Update employee set empname=?,job=?,salary=? where empid=?";
    PreparedStatement ps=conn.prepareStatement(qry);
    
 
    ps.setString(1,e.getEmpname());
    ps.setString(1,e.getJob());
    ps.setDouble(1,e.getSal());
    ps.setString(1,e.getEmpid());
   
    
    int x=ps.executeUpdate();
    return x>0;
        
    }
    
}
