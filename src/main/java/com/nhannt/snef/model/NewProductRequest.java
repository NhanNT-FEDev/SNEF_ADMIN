package com.nhannt.snef.model;

public class NewProductRequest {
    private int nPRId;
    private int storeId;
    private int adminId;
    private boolean status;
    private String message;
    private int productId;
    private String storeName;
    private String productName;


    public NewProductRequest() {
    }

    public NewProductRequest(int nPRId, int storeId, int adminId, boolean status, String message, int productId) {
        this.nPRId = nPRId;
        this.storeId = storeId;
        this.adminId = adminId;
        this.status = status;
        this.message = message;
        this.productId = productId;
    }

    public NewProductRequest(int nPRId, boolean status, String storeName, String productName) {
        this.nPRId = nPRId;
        this.status = status;
        this.storeName = storeName;
        this.productName = productName;
    }

    public int getnPRId() {
        return nPRId;
    }

    public void setnPRId(int nPRId) {
        this.nPRId = nPRId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public NewProductRequest(String storeName, String productName) {
        this.storeName = storeName;
        this.productName = productName;
    }
}

