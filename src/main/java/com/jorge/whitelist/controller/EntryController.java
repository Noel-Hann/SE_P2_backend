package com.jorge.whitelist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jorge.whitelist.models.Entry;
import com.jorge.whitelist.repository.EntryRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("api/entry")
public class EntryController {

    @Autowired
    EntryRepository entryRepository;

    @CrossOrigin
    @RequestMapping("/get-all")
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping("/get-all/{wishlistNum}") 
    public List<Entry> findByWishList(@PathVariable("wishlistNum") int wishlistNum) {
        return entryRepository.findByWishlistNum(wishlistNum);
    }

    @CrossOrigin
    @RequestMapping("/get/{id}")
    public Optional<Entry> getEntryById(@PathVariable("id") Integer id){
        return entryRepository.findById(id);
    }

    @CrossOrigin
    @DeleteMapping("/remove/{id}")
    public boolean deleteEntry(@PathVariable("id") Integer id){
        if(entryRepository.existsById(id)){
            entryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // No Put method since it does not make sense

    @CrossOrigin
    @PostMapping("/add")
    public Entry creaEntry(@RequestBody Map<String, String> body) {
        int itemId = Integer.parseInt(body.get("itemId"));
        int whishlistNum = Integer.parseInt(body.get("wishlistNum"));

        Entry newEntry = new Entry(itemId, whishlistNum);

        return entryRepository.save(newEntry);
    }
    
}
