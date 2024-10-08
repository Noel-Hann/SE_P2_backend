package com.jorge.whitelist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jorge.whitelist.models.*;

public interface UserRepository extends JpaRepository <User, Integer>{
}
