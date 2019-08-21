package com.nhannt.snef.model;


public class StoreAccountOrder {
    private int storeId;
    private String storeName;
    private String phone;
    private String address;
    private String comment;
    private String username;
    private String userPhone;

    public StoreAccountOrder() {
    }

    public StoreAccountOrder(int storeId, String storeName, String phone, String address, String comment, String username, String userPhone) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.phone = phone;
        this.address = address;
        this.comment = comment;
        this.username = username;
        this.userPhone = userPhone;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
