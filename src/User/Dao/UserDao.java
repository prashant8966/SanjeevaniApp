/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Dao;

import User.dbutil.DBConnection;
import User.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Arun
 */
public class UserDao {
    public static String validateUser(UserPojo e) throws SQLException {
    Connection conn=DBConnection.getConnection();
    String qry="select username from users where userid=? and password=? and usertype=?";
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,e.getUserId());
    ps.setString(2,e.getPassword());
    ps.setString(3,e.getUserType());
  ResultSet rs=ps.executeQuery();
  String username=null;
  if(rs.next()){
      username=rs.getString(1);
      
  }
    return username;
    }
    public static boolean changePassword(String userid,String pwd) throws SQLException{
         Connection conn=DBConnection.getConnection();
    String qry="update users set password=? where userid=?";
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,pwd);
    ps.setString(2,userid);
    return(ps.executeUpdate()!=0);
    }
public static HashMap<String,String>getReceptionistList() throws SQLException{
   Connection conn=DBConnection.getConnection();
        String qry="select userid,username from users where usertype='receptionist' ";
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

}
