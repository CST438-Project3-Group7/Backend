package com.csumb.project3Backend.controllers;

import com.csumb.project3Backend.entities.Post;
import com.csumb.project3Backend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

  @Autowired
  private PostService postService;

  // Get all posts
  @GetMapping
  public List<Post> getAllPosts() {
    return postService.getAllPosts();
  }

  // Get a post by ID
  @GetMapping("/{id}")
  public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
    return postService.getPostById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // Get all posts by a user
  @GetMapping("/user/{userId}")
  public List<Post> getPostsByUserId(@PathVariable Integer userId) {
    return postService.getPostsByUserId(userId);
  }

  // Get all posts related to a subject
  @GetMapping("/subject/{subjectId}")
  public List<Post> getPostsBySubjectId(@PathVariable Integer subjectId) {
    return postService.getPostsBySubjectId(subjectId);
  }

  // Add a new post
  @PostMapping
  public ResponseEntity<Post> addPost(@RequestBody Post post) {
    return ResponseEntity.ok(postService.addPost(post));
  }

  // Update an existing post
  @PutMapping("/{id}")
  public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post updatedPost) {
    try {
      Post post = postService.updatePost(id, updatedPost);
      return ResponseEntity.ok(post);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  // Delete a post
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
    try {
      postService.deletePost(id);
      return ResponseEntity.noContent().build();
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }
}

