 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Dao;


import User.dbutil.DBConnection;
import User.pojo.EmpPojo;
import User.pojo.UserDetailsPojo;
import User.pojo.UserPojo;
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
public class ReceptionistDao {
    public static boolean addReceptionist(UserDetailsPojo user) throws SQLException
    {
          Connection conn=DBConnection.getConnection();
    String qry="Insert into users values(?,?,?,?,?)";
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,user.getUserid());
    ps.setString(2,user.getUsername());
    ps.setString(3,user.getEmpid());
    ps.setString(4,user.getPassword());
    ps.setString(5,user.getUserType());
    
    int x=ps.executeUpdate();
    return x>0;
        
    }
      public static ArrayList<UserDetailsPojo>getALLEmp() throws SQLException
    {
         Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs =st.executeQuery("select * from users where userType='receptionist'");
    ArrayList<UserDetailsPojo>empList=new ArrayList();
    while(rs.next()){
        UserDetailsPojo e=new UserDetailsPojo();
          
        e.setUserid(rs.getString(1));
        e.setUsername(rs.getString(2));
        e.setEmpid(rs.getString(3));
        e.setUserType(rs.getString(4));
        empList.add(e);
          
    }
    return empList;
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
       public static boolean deleteReceptionist(String user) throws SQLException
    {
          Connection conn=DBConnection.getConnection();
    String qry="delete from users where empid=?";
    PreparedStatement ps=conn.prepareStatement(qry);
    
    ps.setString(1,user);
   
    
    int x=ps.executeUpdate();
    return x>0;
        
    }

}