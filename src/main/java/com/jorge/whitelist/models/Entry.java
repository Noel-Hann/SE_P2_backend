package com.jorge.whitelist.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int entryNum;

    private int wishlistNum;
    private int itemId;

    public Entry() {

    }

    public Entry(int itemId, int whishlistNum){
        this.itemId = itemId;
        this.wishlistNum = whishlistNum;
    }

    public int getEntryNum() {
        return entryNum;
    }

    public int getWishlistNum() {
        return wishlistNum;
    }

    public void setWishlistNum(int wishlistNum) {
        this.wishlistNum = wishlistNum;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}

