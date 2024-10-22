package com.jorge.whitelist.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "friends_with")
public class Friends {

    public Friends(int friendOneId, int friendTwoId) {
        this.friendOneId = friendOneId;
        this.friendTwoId = friendTwoId;
    }


    public Friends(){};

    @Id @GeneratedValue
    private int friendsId;

    private int friendOneId;

    private int friendTwoId;

    public int getFriendTwoId() {
        return friendTwoId;
    }

    public int getFriendOneId() {
        return friendOneId;
    }

    public int getFriendsId() {return friendsId;}


}
