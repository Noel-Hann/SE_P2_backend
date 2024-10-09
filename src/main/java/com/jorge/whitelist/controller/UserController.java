package com.jorge.whitelist.controller;

import com.jorge.whitelist.models.User;
import com.jorge.whitelist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.whitelist.models.Wishlist;
import com.jorge.whitelist.repository.WishlistRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping("/add")
    public User addUser(@RequestBody Map<String,String> body){

        String username = body.get("username");
        String password = body.get("password");

        //if the username already exists, we don't want to make a new user with the same username
        if (getByUsername(username) != null) {
            return null;
        }
        User newUser = new User(username, password);

        userRepository.save(newUser);
        return newUser;


    }

//    @GetMapping("/test")
//    public String test(){
//        return "test";
//    }

    @CrossOrigin
    @GetMapping("/get-all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    /*the plan:
        add a method to get a user by username
        in the add function, call that function to see if that username already exists
        if it does, don't add the user
   */

    @CrossOrigin
    @GetMapping("/get/{username}")
    public User getByUsername(@PathVariable String username){
        List<User> response = userRepository.findByUsername(username);
        if (response.isEmpty()) {
            return null;
        }
        return response.get(0);
    }
}
