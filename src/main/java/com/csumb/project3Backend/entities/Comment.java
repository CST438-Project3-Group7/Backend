package com.csumb.project3Backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer commentId;

  @Lob
  private String content;

  @Column(nullable = false)
  private Integer likes = 0;

  @Column(nullable = false)
  private Integer dislikes = 0;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;


  @ManyToOne
  @JoinColumn(name = "post_id", nullable = false)
  @JsonBackReference
  private Post post;

  @Column(nullable = false)
  private LocalDateTime datetime;

  // Getters and Setters
  public Integer getCommentId() {
    return commentId;
  }

  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getLikes() {
    return likes;
  }

  public void setLikes(Integer likes) {
    this.likes = likes;
  }

  public Integer getDislikes() {
    return dislikes;
  }

  public void setDislikes(Integer dislikes) {
    this.dislikes = dislikes;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }


  public LocalDateTime getDatetime() {
    return datetime;
  }

  public void setDatetime(LocalDateTime datetime) {
    this.datetime = datetime;
  }
}
