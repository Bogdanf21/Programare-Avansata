package com.company.repository;

import com.company.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

interface FriendshipRepository extends JpaRepository<Friendship, Long> {
}
