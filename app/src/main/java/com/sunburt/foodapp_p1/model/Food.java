package com.sunburt.foodapp_p1.model;

import java.io.Serializable;

public class Food implements Serializable {
    private int food_id;
    private String name;
    private int imgsrc;
    private String region;
    private String description;
    private float price;

    public Food() {
    }

    public Food(int food_id, String name, int imgsrc, String region, String description, float price) {
        this.food_id = food_id;
        this.name = name;
        this.imgsrc = imgsrc;
        this.region = region;
        this.description = description;
        this.price = price;
    }

    public Food(String name, int imgsrc, String region, String description, float price) {
        this.name = name;
        this.imgsrc = imgsrc;
        this.region = region;
        this.description = description;
        this.price = price;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(int imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
