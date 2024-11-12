package com.csumb.project3Backend.entities;

import com.google.cloud.firestore.DocumentReference;
import java.util.ArrayList;
import java.util.List;

public class User {

  private String userId;
  private String username;
  private List<DocumentReference> posts = new ArrayList<>();
  private String role;
  private String password;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<DocumentReference> getPosts() {
    return posts;
  }

  public void setPosts(List<DocumentReference> posts) {
    this.posts = posts;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
