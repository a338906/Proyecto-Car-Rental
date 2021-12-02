package model.login;

import javax.swing.Icon;

public class ModelUser {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Icon getProfile() {
        return profile;
    }

    public void setProfile(Icon profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModelUser(int userID, String userName, Icon profile, String email, String password, String verifyCode, String status) {
        this.userID = userID;
        this.userName = userName;
        this.profile = profile;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;        
        this.status = status;
    }
    
    public ModelUser() {
    }

    private int userID;
    private String userName;
    private Icon profile;
    private String email;
    private String password;
    private String verifyCode;    
    private String status;
}
