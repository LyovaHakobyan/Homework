package homeworks.onlineMarket.model;

import java.io.Serializable;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(userId, user.userId)) return false;
        if (!Objects.equals(userName, user.userName)) return false;
        if (!Objects.equals(userEmail, user.userEmail)) return false;
        if (!Objects.equals(userPassword, user.userPassword)) return false;
        return userType == user.userType;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User:" + userType + " Id:" + userId + " Name:" + userName + " Email:" + userEmail;
    }
}
