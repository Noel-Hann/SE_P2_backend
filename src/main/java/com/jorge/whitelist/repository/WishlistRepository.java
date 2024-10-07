package com.jorge.whitelist.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jorge.whitelist.models.Wishlist;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{

    List<Wishlist> findByUserKey(int userKey);
    
}
