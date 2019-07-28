package com.nhannt.snef.model;

public class Store {
    private int storeId;
    private String storeName;
    private int storeManagerId;
    private int locationId;
    private float ratingPoint;
    private String avatar;
    private String openHour;
    private String closeHour;
    private float longitude;
    private float latitude;
    private boolean status;
    private String address;
    public Store() {
    }

    public Store(int storeId, String storeName, int storeManagerId, int locationId, float ratingPoint, String avatar, String openHour, String closeHour, float longitude, float latitude, boolean status) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeManagerId = storeManagerId;
        this.locationId = locationId;
        this.ratingPoint = ratingPoint;
        this.avatar = avatar;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.longitude = longitude;
        this.latitude = latitude;
        this.status = status;
    }

    public Store(int storeId, String storeName, int storeManagerId, float ratingPoint, String avatar, String openHour, String closeHour, boolean status, String address) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeManagerId = storeManagerId;
        this.ratingPoint = ratingPoint;
        this.avatar = avatar;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.status = status;
        this.address = address;
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

    public int getStoreManagerId() {
        return storeManagerId;
    }

    public void setStoreManagerId(int storeManagerId) {
        this.storeManagerId = storeManagerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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

    public boolean isStatus() {
        return status;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
