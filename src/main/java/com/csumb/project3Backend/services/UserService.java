package com.csumb.project3Backend.services;

import com.csumb.project3Backend.entities.User;
import com.csumb.project3Backend.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  // Fetch all users
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  // Fetch a user by ID
  public Optional<User> getUserById(Integer userId) {
    return userRepository.findById(userId);
  }

  // Fetch a user by username
  public Optional<User> getUserByUsername(String username) {
    return Optional.ofNullable(userRepository.findByUsername(username));
  }

  // Add a new user
  public User addUser(User user) {
    // Add logic for hashing passwords and validating inputs if necessary
    return userRepository.save(user);
  }

  // Update an existing user
  public User updateUser(Integer userId, User updatedUser) {
    return userRepository.findById(userId).map(user -> {
      user.setUsername(updatedUser.getUsername());
      user.setPassword(updatedUser.getPassword());
      user.setRoles(updatedUser.getRoles());
      return userRepository.save(user);
    }).orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
  }

  // Delete a user by ID
  public void deleteUser(Integer userId) {
    if (userRepository.existsById(userId)) {
      userRepository.deleteById(userId);
    } else {
      throw new RuntimeException("User not found with ID: " + userId);
    }
  }

  // Check if a username exists
  public boolean usernameExists(String username) {
    return userRepository.existsByUsername(username);
  }
}

