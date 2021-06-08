/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.pojo;

/**
 *
 * @author Arun
 */
public class UserDetailsPojo {

    @Override
    public String toString() {
        return "UserDetailsPojo{" + "userid=" + userid + ", username=" + username + ", empid=" + empid + ", userType=" + userType + ", password=" + password + '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String userid;
    private String username;
    private String empid;
    private String userType;
    private String password;
    
}
