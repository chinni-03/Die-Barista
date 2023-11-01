package com.example.diebarista.model;

public class Products {
    Integer productId;
    String productName;
    String productDesc;
    String productPrice;
    Integer imgUrl;


    public Products(Integer productId, String productName, String productDesc, String productPrice, Integer imgUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.imgUrl = imgUrl;
    }

    public Products(Integer productId, String productName, String productDesc, Integer imgUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.imgUrl = imgUrl;
    }

    public Products(Integer productId, String productName, Integer imgUrl) {
        this.productId = productId;
        this.productName = productName;
        this.imgUrl = imgUrl;
    }

    public Products(Integer productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Integer imgUrl) {
        this.imgUrl = imgUrl;
    }

}
