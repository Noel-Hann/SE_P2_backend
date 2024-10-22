package com.jorge.whitelist.controller;

import com.jorge.whitelist.models.Friends;
import com.jorge.whitelist.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/friend")
public class FriendController {

    @Autowired
    FriendRepository friendRepository;

    @CrossOrigin
    @GetMapping("/get-all")
    public List<Friends> getAllFriends() {
        return friendRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/get/{id}")
    public List<Friends> getFriendsOf(@PathVariable int id) {
        return friendRepository.findByFriendOneId(id);
    }

    @CrossOrigin
    @PostMapping("/add")
    public Friends addFriend(@RequestBody Map<String,Integer> body) {
        int Id1 = body.get("Id1");
        int Id2 = body.get("Id2");

        Friends friend = new Friends(Id1,Id2);

        friendRepository.save(friend);

        Friends requited = new Friends(Id2,Id1);

        friendRepository.save(requited);

        return friend;
    }

    @CrossOrigin
    @GetMapping ("/get")
    public Friends getFriend(@RequestBody Map<String,Integer> body) {
        int Id1 = body.get("Id1");
        int Id2 = body.get("Id2");
        Friends friend = friendRepository.findByFriendOneIdAndFriendTwoId(Id1,Id2).get(0);
        return friend;
    }

    @CrossOrigin
    @DeleteMapping("/remove")
    public void removeFriend(@RequestBody Map<String,Integer> body) {
        int Id1 = body.get("Id1");
        int Id2 = body.get("Id2");

        //delete first version
        Friends friend = friendRepository.findByFriendOneIdAndFriendTwoId(Id1,Id2).get(0);
        friendRepository.deleteById(friend.getFriendsId());

        //delete second version
        friend = friendRepository.findByFriendOneIdAndFriendTwoId(Id2,Id1).get(0);
        friendRepository.deleteById(friend.getFriendsId());

    }


}
