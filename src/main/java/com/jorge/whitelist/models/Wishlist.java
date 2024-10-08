package com.jorge.whitelist.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userKey;
    private String name;
    private String description;

    public Wishlist() {
    }

    public Wishlist(int userKey, String name, String description) {
        this.userKey = userKey;
        this.name = name;
        this.description = description;
    }

    public int getWishlistNum() {
        return id;
    }

    public void setWishlistNum(int wishlistNum) {
        this.id = wishlistNum;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
