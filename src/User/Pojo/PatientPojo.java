/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.pojo;

import java.sql.Date;

/**
 *
 * @author Arun
 */
public class PatientPojo {

    public PatientPojo() {
    }

    public PatientPojo(String patientid, String doctorid, String firstname, String secondname, String OPD, String gender, String address, String city, String status, String phoneno, int age, Date date) {
        this.patientid = patientid;
        this.doctorid = doctorid;
        this.firstname = firstname;
        this.secondname = secondname;
        this.OPD = OPD;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.status = status;
        this.phoneno = phoneno;
        this.age = age;
        this.date = date;
    }

   private String patientid;
    private String doctorid;
    private String firstname;
    private String secondname;
    private String OPD;
    private String gender;
    private String address;
    private String city;
    private String status;
    private String phoneno;
    private int age;
    private Date date;
    @Override
    public String toString() {
        return "PatientPojo{" + "patientid=" + patientid + ", doctorid=" + doctorid + ", firstname=" + firstname + ", secondname=" + secondname + ", OPD=" + OPD + ", gender=" + gender + ", address=" + address + ", city=" + city + ", status=" + status + ", phoneno=" + phoneno + ", age=" + age + ", date=" + date + '}';
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getOPD() {
        return OPD;
    }

    public void setOPD(String OPD) {
        this.OPD = OPD;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
