package com.example.diebarista.model;

public class Category {
    String category;
    Integer imgUrl;

    public Category(String category, Integer imgUrl) {
        this.category = category;
        this.imgUrl = imgUrl;
    }

    public String getCategory() {
        return category;
    }

    public Integer getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Integer imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Category(String category) {
        this.category = category;
    }
}
