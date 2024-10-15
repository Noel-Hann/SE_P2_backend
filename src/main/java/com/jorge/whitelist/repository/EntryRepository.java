package com.jorge.whitelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorge.whitelist.models.Entry;

import java.util.List;


public interface EntryRepository extends JpaRepository<Entry, Integer>{
    List<Entry> findByWishlistNum(int whishlistNum);
}
