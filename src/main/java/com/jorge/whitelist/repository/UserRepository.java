package com.jorge.whitelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jorge.whitelist.models.*;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Integer>{
    List<User> findByUsername(String username);
}
