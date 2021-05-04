package com.sunburt.foodapp_p1.model;

import java.io.Serializable;

public class Food implements Serializable {
    private int id;
    private String name;
    private String region;
    private String description;
    private float price;

    public Food() {
    }

    public Food(int id, String name, String region, String description, float price) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
