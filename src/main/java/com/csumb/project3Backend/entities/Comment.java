package com.csumb.project3Backend.entities;

import com.google.cloud.Timestamp;

public class Comment {
  private String ID;
  private User user;
  private String postId;
  private Timestamp date;
  private String text;
  private int likes;
  private int dislikes;

  public Comment(){}

  public Comment(User user, String postId, String commentText) {
    this.user = user;
    this.postId = postId;
    this.text = commentText;
    this.date = Timestamp.now();
  }

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public User getUserId() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getLikes() {
    return likes;
  }

  public void setLikes(int likes) {
    this.likes = likes;
  }

  public int getDislikes() {
    return dislikes;
  }

  public void setDislikes(int dislikes) {
    this.dislikes = dislikes;
  }
}
