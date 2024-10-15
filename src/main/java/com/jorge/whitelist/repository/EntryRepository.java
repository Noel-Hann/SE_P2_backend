package com.jorge.whitelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorge.whitelist.models.Entry;

public interface EntryRepository extends JpaRepository<Entry, Integer>{
    
}
