package in.skbuzz.bindings;


import java.time.LocalDate;

public class UserForm {

    private String fname;
    private String lname;
    private String email;
    private String phno;
    private LocalDate Dob;
    private String gender;
    private String countryId;
    private String stateId;
    private String cityId;

    public UserForm(String fname, String lname, String email, String phno, LocalDate dob, String gender, String countryId, String stateId, String cityId) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phno = phno;
        Dob = dob;
        this.gender = gender;
        this.countryId = countryId;
        this.stateId = stateId;
        this.cityId = cityId;
    }

    public UserForm() {
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
}
