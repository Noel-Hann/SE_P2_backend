package com.jorge.whitelist.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api/wishlist")
public class WishlistController {

    @Autowired
    WishlistRepository wishlistRepository;

    @GetMapping("/get-all")
    public List<Wishlist> getAllWishlist() {
        return wishlistRepository.findAll();
    }

    @GetMapping("get/{id}")
    public Wishlist getSingleWishlist(@PathVariable("id") Integer id){
        return wishlistRepository.findById(id).get();
    }

    @GetMapping("/remove/{id}")
    public boolean deleteRow(@PathVariable("id") Integer id){
        if(!wishlistRepository.findById(id).equals(Optional.empty())) {
            wishlistRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public Wishlist updateWishlist(@PathVariable("id") Integer id, @RequestBody Map<String, String> body) {
        Wishlist currenWishlist = wishlistRepository.findById(id).get();

        currenWishlist.setName(body.get("name"));
        currenWishlist.setDescription(body.get("description"));

        wishlistRepository.save(currenWishlist);
        return currenWishlist;
    }

    @PostMapping("/add")
    public Wishlist createWishlist(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String desc = body.get("description");
        int userKey = Integer.parseInt(body.get("userKey"));
        
        Wishlist newWishlist = new Wishlist(userKey, name, desc);

        return wishlistRepository.save(newWishlist);
    }

}
