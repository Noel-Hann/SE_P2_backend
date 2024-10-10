package com.jorge.whitelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorge.whitelist.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
    
}
