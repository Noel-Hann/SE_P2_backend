package com.jorge.whitelist.controller;

import com.jorge.whitelist.models.User;
import com.jorge.whitelist.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        boolean isAdmin = Boolean.parseBoolean(body.getOrDefault("isAdmin", "false"));

        User newUser = new User(username, password);
        newUser.setAdmin(isAdmin);

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

    @CrossOrigin
    @DeleteMapping("/remove/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id){
        if(!userRepository.findById(id).equals(Optional.empty())) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public User updatUser(@PathVariable("id") Integer id, @RequestBody Map<String, String> body){
        User currentUser = userRepository.findById(id).get();

        currentUser.setUsername(body.get("username"));
        currentUser.setPassword(body.get("password"));
        if (body.containsKey("isAdmin")) { 
            boolean isAdmin = Boolean.parseBoolean(body.get("isAdmin"));
            currentUser.setAdmin(isAdmin); 
        }

        userRepository.save(currentUser);
        return currentUser;
    }
}
