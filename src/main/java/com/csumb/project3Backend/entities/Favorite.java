package com.csumb.project3Backend.entities;

import jakarta.persistence.*;

@Entity
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer favoriteId;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "subject_id", nullable = false)
  private Subject subject;

  // Getters and Setters
  public Integer getFavoriteId() {
    return favoriteId;
  }

  public void setFavoriteId(Integer favoriteId) {
    this.favoriteId = favoriteId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }
}

