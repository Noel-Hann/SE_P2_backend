package com.jorge.whitelist.repository;

import com.jorge.whitelist.models.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friends, Integer> {
    List<Friends> findByFriendOneId (int friendOneId) ;
    List<Friends> findByFriendOneIdAndFriendTwoId (int friendOneId, int friendTwoId);
}
