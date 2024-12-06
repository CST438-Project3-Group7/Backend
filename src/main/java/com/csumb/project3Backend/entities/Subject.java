package com.csumb.project3Backend.entities;

import com.csumb.project3Backend.enums.SubjectType;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer subjectId;

  @Column(nullable = false, length = 45)
  private String title;

  @Column(nullable = false)
  private Integer year;

  @Enumerated(EnumType.STRING)
  private SubjectType type; // Enum for the type of media (e.g., MOVIE, BOOK, VIDEO_GAME)

  /*
  @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Post> posts; */

  /*@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Favorite> favorites; */

  // Getters and Setters
  public Integer getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(Integer subjectId) {
    this.subjectId = subjectId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public SubjectType getType() {
    return type;
  }

  public void setType(SubjectType type) {
    this.type = type;
  }

  /*
  public Set<Post> getPosts() {
    return posts;
  }

  public void setPosts(Set<Post> posts) {
    this.posts = posts;
  } */

  /*
  public Set<Favorite> getFavorites() {
    return favorites;
  }

  public void setFavorites(Set<Favorite> favorites) {
    this.favorites = favorites;
  } */
}

