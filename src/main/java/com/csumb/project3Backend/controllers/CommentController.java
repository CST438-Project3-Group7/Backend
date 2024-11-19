package com.csumb.project3Backend.controllers;

import com.csumb.project3Backend.entities.Comment;
import com.csumb.project3Backend.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

  @Autowired
  private CommentService commentService;

  // Get all comments
  @GetMapping
  public List<Comment> getAllComments() {
    return commentService.getAllComments();
  }

  // Get a comment by ID
  @GetMapping("/{id}")
  public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
    return commentService.getCommentById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // Get all comments by a user
  @GetMapping("/user/{userId}")
  public List<Comment> getCommentsByUserId(@PathVariable Integer userId) {
    return commentService.getCommentsByUserId(userId);
  }

  // Add a new comment
  @PostMapping
  public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
    return ResponseEntity.ok(commentService.addComment(comment));
  }

  // Update an existing comment
  @PutMapping("/{id}")
  public ResponseEntity<Comment> updateComment(@PathVariable Integer id, @RequestBody Comment updatedComment) {
    try {
      Comment comment = commentService.updateComment(id, updatedComment);
      return ResponseEntity.ok(comment);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  // Delete a comment
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
    try {
      commentService.deleteComment(id);
      return ResponseEntity.noContent().build();
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }
}

