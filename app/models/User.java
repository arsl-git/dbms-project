package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private String username;
    private String gender;
    private String email;
    private String phoneNo;
    private String userId;
    private String usertype;
    private String userAddress;

    private String password;

    public User(){

    }

    public User(String username, String gender, String email, String phoneNo, String userId, String usertype,
                String userAddress, String password) {
        this.userId = userId;
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.phoneNo = phoneNo;
        this.usertype = usertype;
        this.userAddress = userAddress;
        this.password = password;
    }

    public User(String username, String gender, String email, String phoneNo, String usertype,
                String userAddress, String password) {
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.phoneNo = phoneNo;
        this.usertype = usertype;
        this.userAddress = userAddress;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String generateUserId() {
        return "user_" + UUID.randomUUID();
    }
}
