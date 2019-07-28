package com.nhannt.snef.model;

import java.io.Serializable;

public class Customer implements Serializable {

    private int customerId;
    private int accountId;
    private String username;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private boolean isactive;
    private String avatar;
    private boolean gender;

    public Customer() {
    }

    public Customer(int customerId, int accountId, String username, String firstname, String lastname, String phone, String email, boolean isactive, String avatar, boolean gender) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.isactive = isactive;
        this.avatar = avatar;
        this.gender = gender;
    }

    public Customer(String username, String firstname, String lastname, String phone, String email, boolean isactive, String avatar, boolean gender) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.isactive = isactive;
        this.avatar = avatar;
        this.gender = gender;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
