package com.csumb.project3Backend.entities;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class Post {

  @DocumentId
  private String postId;
  private Timestamp date;
  private double rating;
  private int likes;
  private int dislikes;
  private DocumentReference user;
  private List<DocumentReference> comments = new ArrayList<>();
  private String title;
  private String postContent;

  public Post() {}

  public Post(DocumentReference user, String title, String postText) {
    this.user = user;
    this.title = title;
    this.postContent = postText;
    this.date = Timestamp.now();
  }

  // Getters and Setters
  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public String getUserPath() {
    return user != null ? user.getPath() : null;
  }

  // Custom getter to return comment paths as a list of strings
  public List<String> getCommentPaths() {
    List<String> commentPaths = new ArrayList<>();
    if (comments != null) {
      for (DocumentReference commentRef : comments) {
        commentPaths.add(commentRef.getPath());
      }
    }
    return commentPaths;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
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

  public DocumentReference getUser() {
    return user;
  }

  public void setUser(DocumentReference user) {
    this.user = user;
  }

  public List<DocumentReference> getComments() {
    return comments;
  }

  public void setComments(List<DocumentReference> comments) {
    this.comments = comments;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPostContent() {
    return postContent;
  }

  public void setPostContent(String postText) {
    this.postContent = postText;
  }
}
