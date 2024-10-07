package com.jorge.whitelist.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.jorge.whitelist.models.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{
    
}
