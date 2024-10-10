package com.jorge.whitelist.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Double price;

    @Column(name = "short_description")
    private String shortDescription;

    private String type;

    public Item() {
    }

    public Item(String name, double price, String shortDescription, String type){
        this.name = name;
        this.price = price;
        this.shortDescription = shortDescription;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

}

