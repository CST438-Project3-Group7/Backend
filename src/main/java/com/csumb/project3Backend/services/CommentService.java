package com.csumb.project3Backend.services;

import com.csumb.project3Backend.entities.Comment;
import com.csumb.project3Backend.repos.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

  @Autowired
  private CommentRepository commentRepository;

  // Get all posts
  public List<Comment> getAllComments() {
    return commentRepository.findAll();
  }

  // Get a comment by ID
  public Optional<Comment> getCommentById(Integer commentId) {
    return commentRepository.findById(commentId);
  }

  // Get all comments by a user
  public List<Comment> getCommentsByUserId(Integer userId) {
    return commentRepository.findByUser_UserId(userId);
  }

  // Get all comments on a post
  public List<Comment> getCommentsByPostId(Integer postId) {
    return commentRepository.findByPost_PostId(postId);
  }

  // Add a new comment
  public Comment addComment(Comment comment) {
    return commentRepository.save(comment);
  }

  // Update an existing post
  public Comment updateComment(Integer commentId, Comment updatedComment) {
    return commentRepository.findById(commentId).map(comment -> {
      comment.setContent(updatedComment.getContent());
      comment.setLikes(updatedComment.getLikes());
      comment.setDislikes(updatedComment.getDislikes());
      comment.setDatetime(updatedComment.getDatetime());
      return commentRepository.save(comment);
    }).orElseThrow(() -> new RuntimeException("Comment not found with ID: " + commentId));
  }

  // Delete a post
  public void deleteComment(Integer commentId) {
    if (commentRepository.existsById(commentId)) {
      commentRepository.deleteById(commentId);
    } else {
      throw new RuntimeException("Comment not found with ID: " + commentId);
    }
  }
}

