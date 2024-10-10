package com.jorge.whitelist.controller;

import com.jorge.whitelist.models.User;
import com.jorge.whitelist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



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


        User newUser = new User(username, password);

        userRepository.save(newUser);
        return newUser;


    }


    @CrossOrigin
    @GetMapping("/get-all")
    public List<User> getAll(){
        return userRepository.findAll();
    }



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
