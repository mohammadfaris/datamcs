package com.example.user.hobia;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by User on 24/10/2016.
 */
public class User implements Serializable{
    Vector<User> userShop = new Vector<User>();
public String emailRegis ;
    public String Password;
    public String Phone;
    public String firstName;
    public String lastName;

    public Vector<User> getUserShop() {
        return userShop;
    }

    public void setUserShop(Vector<User> userShop) {
        this.userShop = userShop;
    }

    public String getEmailRegis() {
        return emailRegis;
    }

    public void setEmailRegis(String emailRegis) {
        this.emailRegis = emailRegis;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public User(){

    }

    public User (String emailRegis,String password,String phone,String firstName,String lastName){
        this.emailRegis = emailRegis;
        this.Password =password;
        this.Phone= phone;
        this.firstName =firstName;
        this.lastName=lastName;
    }
}
