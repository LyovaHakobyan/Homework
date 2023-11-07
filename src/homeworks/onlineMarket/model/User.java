package homeworks.onlineMarket.model;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private UserType userType;

    public User(String userId, String userName, String userEmail, String userPassword, UserType userType) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User:" + userType + " Id:" + userId + " Name:" + userName + " Email:" + userEmail;
    }
}
