package com.nhannt.snef.model;

public class Store {
    private int storeId;
    private String storeName;
    private String address;
    private float ratingPoint;
    private String avatar;
    private String openHour;
    private String closeHour;
    private double longitude;
    private double latitude;
    private boolean status;
    private String phone;
    private int accountId;
    private String storeManager;

    public Store() {
    }

    public Store(int storeId, String storeName, String address, float ratingPoint, String avatar, String openHour, String closeHour, boolean status, String phone, String storeManager) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.address = address;
        this.ratingPoint = ratingPoint;
        this.avatar = avatar;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.status = status;
        this.phone = phone;
        this.storeManager = storeManager;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(float ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getStoreManager() {
        return storeManager;
    }

    public void setStoreManager(String storeManager) {
        this.storeManager = storeManager;
    }
}
