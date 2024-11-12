package com.csumb.project3Backend.controllers;

import com.csumb.project3Backend.entities.Post;
import com.csumb.project3Backend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/posts")
public class PostController {

  private final PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  // Endpoint to create a new post
  @PostMapping("/create")
  public ResponseEntity<String> createPost(@RequestBody Post post) throws ExecutionException, InterruptedException {
    String postId = postService.createPost(post);
    return ResponseEntity.ok(postId); // Return generated post ID
  }

  // Endpoint to get a post by ID
  @GetMapping("/{postId}")
  public ResponseEntity<Post> getPostById(@PathVariable String postId) throws ExecutionException, InterruptedException {
    Post post = postService.getPostById(postId);
    if (post != null) {
      return ResponseEntity.ok(post);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Endpoint to get all posts
  @GetMapping("/all")
  public ResponseEntity<List<Post>> getAllPosts() throws ExecutionException, InterruptedException {
    List<Post> posts = postService.getAllPosts();
    return ResponseEntity.ok(posts);
  }

  // Endpoint to update an existing post
  @PutMapping("/{postId}")
  public ResponseEntity<String> updatePost(@PathVariable String postId, @RequestBody Post updatedPost) throws ExecutionException, InterruptedException {
    boolean success = postService.updatePost(postId, updatedPost);
    if (success) {
      return ResponseEntity.ok("Post updated successfully.");
    } else {
      return ResponseEntity.badRequest().body("Failed to update post.");
    }
  }

  // Endpoint to delete a post
  @DeleteMapping("/{postId}")
  public ResponseEntity<String> deletePost(@PathVariable String postId) throws ExecutionException, InterruptedException {
    boolean success = postService.deletePost(postId);
    if (success) {
      return ResponseEntity.ok("Post deleted successfully.");
    } else {
      return ResponseEntity.badRequest().body("Failed to delete post.");
    }
  }
}
