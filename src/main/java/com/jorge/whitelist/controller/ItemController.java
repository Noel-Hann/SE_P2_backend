package com.jorge.whitelist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jorge.whitelist.models.Item;
import com.jorge.whitelist.repository.ItemRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @CrossOrigin
    @GetMapping("/get-all")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/get/{id}")
    public Optional<Item> getItemById(@PathVariable("id") Integer id) {
        return itemRepository.findById(id);
    }

    @CrossOrigin
    @DeleteMapping("/remove/{id}")
    public boolean deleteItem(@PathVariable("id") Integer id) {
        if(itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @CrossOrigin
    @PutMapping("/update/{id}")
    public Item updateItem(@PathVariable("id") Integer id, @RequestBody Map<String, String> body) {
        Item currentItem = itemRepository.findById(id).orElseThrow();

        currentItem.setName(body.get("name"));
        currentItem.setPrice(Double.parseDouble(body.get("price")));
        currentItem.setShortDescription(body.get("shortDescription"));
        currentItem.setType(body.get("type"));

        itemRepository.save(currentItem);
        return currentItem;
    }

    @CrossOrigin
    @PostMapping("/add")
    public Item createItem(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        double price = Double.parseDouble(body.get("price"));
        String shortDescription = body.get("shortDescription");
        String type = body.get("type");

        Item newItem = new Item(name, price, shortDescription, type);

        return itemRepository.save(newItem);
    }
}
