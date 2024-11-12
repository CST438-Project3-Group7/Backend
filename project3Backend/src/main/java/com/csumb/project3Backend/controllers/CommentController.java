package com.csumb.project3Backend.controllers;

import com.csumb.project3Backend.entities.Comment;
import com.csumb.project3Backend.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/comments")
public class CommentController {

  private final CommentService commentService;

  @Autowired
  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  // Endpoint to create a new comment
  @PostMapping("/create")
  public ResponseEntity<String> createComment(@RequestBody Comment comment) throws ExecutionException, InterruptedException {
    String commentId = commentService.createComment(comment);
    return ResponseEntity.ok(commentId); // Return generated comment ID
  }

  // Endpoint to get a comment by ID
  @GetMapping("/{commentId}")
  public ResponseEntity<Comment> getCommentById(@PathVariable String commentId) throws ExecutionException, InterruptedException {
    Comment comment = commentService.getCommentById(commentId);
    if (comment != null) {
      return ResponseEntity.ok(comment);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Endpoint to get all comments for a specific post
  @GetMapping("/post/{postId}")
  public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable String postId) throws ExecutionException, InterruptedException {
    List<Comment> comments = commentService.getCommentsByPostId(postId);
    return ResponseEntity.ok(comments);
  }

  // Endpoint to update a comment
  @PutMapping("/{commentId}")
  public ResponseEntity<String> updateComment(@PathVariable String commentId, @RequestBody Map<String, Object> updates) throws ExecutionException, InterruptedException {
    boolean updated = commentService.updateComment(commentId, updates);
    if (updated) {
      return ResponseEntity.ok("Comment updated successfully.");
    } else {
      return ResponseEntity.badRequest().body("Failed to update comment.");
    }
  }

  // Endpoint to delete a comment
  @DeleteMapping("/{commentId}")
  public ResponseEntity<String> deleteComment(@PathVariable String commentId) throws ExecutionException, InterruptedException {
    boolean deleted = commentService.deleteComment(commentId);
    if (deleted) {
      return ResponseEntity.ok("Comment deleted successfully.");
    } else {
      return ResponseEntity.badRequest().body("Failed to delete comment.");
    }
  }
}

