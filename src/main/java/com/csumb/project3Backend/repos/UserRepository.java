package com.csumb.project3Backend.repos;

import com.csumb.project3Backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  // Custom method to find a user by username
  User findByUsername(String username);

  // Custom method to check if a username exists
  boolean existsByUsername(String username);
}

