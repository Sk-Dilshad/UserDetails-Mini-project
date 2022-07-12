package in.skbuzz.bindings;

public class UnlockForm {

    private String email;
    private String tempPwd;
    private String newPwd;
    private String confirmNewPwd;

    public UnlockForm() {
    }

    public UnlockForm(String email, String tempPwd, String newPwd, String confirmNewPwd) {
        this.email = email;
        this.tempPwd = tempPwd;
        this.newPwd = newPwd;
        this.confirmNewPwd = confirmNewPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTempPwd() {
        return tempPwd;
    }

    public void setTempPwd(String tempPwd) {
        this.tempPwd = tempPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getConfirmNewPwd() {
        return confirmNewPwd;
    }

    public void setConfirmNewPwd(String confirmNewPwd) {
        this.confirmNewPwd = confirmNewPwd;
    }
}
