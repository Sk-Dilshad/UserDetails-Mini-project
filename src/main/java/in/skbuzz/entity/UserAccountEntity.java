package in.skbuzz.entity;




import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="USER_ACCOUNTS")
public class UserAccountEntity {

    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Integer userId;

    @Column(name="FIRST_NAME")
    private String fname;

    @Column(name="LAST_NAME")
    private String lname;

    @Column(name="EMAIL" , unique = true)
    private String email;

    @Column(name="PASSWORD")
    private String pwd;

    @Column(name="PHONE_NUMBER")
    private String phno;

    @Column(name="DOB")
    private LocalDate Dob;

    @Column(name="GENDER")
    private String gender;

    @Column(name="COUNTRY_ID")
    private String countryId;

    @Column(name="STATE_ID")
    private String stateId;

    @Column(name="CITY_ID")
    private String cityId;

    @Column(name ="ACC_STATUS")
    private String accStatus;

    @Column(name="CREATED_DATE",updatable = false)
//    @CreationTimestamp
    private String createdDate;

    @Column(name="UPDATED_DATE",insertable = false )
//    @UpdateTimestamp
    private String updatedDate;

    public UserAccountEntity(Integer userId, String fname, String lname, String email, String pwd, String phno, LocalDate dob, String gender, String countryId, String stateId, String cityId, String accStatus, String createdDate, String updatedDate) {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.pwd = pwd;
        this.phno = phno;
        this.Dob = dob;
        this.gender = gender;
        this.countryId = countryId;
        this.stateId = stateId;
        this.cityId = cityId;
        this.accStatus = accStatus;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public UserAccountEntity() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        Dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
