package com.csumb.project3Backend.services;

import com.csumb.project3Backend.entities.Post;
import com.csumb.project3Backend.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  // Get all posts
  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  // Get a post by ID
  public Optional<Post> getPostById(Integer postId) {
    return postRepository.findById(postId);
  }

  // Get all posts by a user
  public List<Post> getPostsByUserId(Integer userId) {
    return postRepository.findByUser_UserId(userId);
  }

  // Get all posts related to a subject
  public List<Post> getPostsBySubjectId(Integer subjectId) {
    return postRepository.findBySubject_SubjectId(subjectId);
  }

  // Add a new post
  public Post addPost(Post post) {
    return postRepository.save(post);
  }

  // Update an existing post
  public Post updatePost(Integer postId, Post updatedPost) {
    return postRepository.findById(postId).map(post -> {
      post.setTitle(updatedPost.getTitle());
      post.setContent(updatedPost.getContent());
      post.setLikes(updatedPost.getLikes());
      post.setDislikes(updatedPost.getDislikes());
      post.setDatetime(updatedPost.getDatetime());
      return postRepository.save(post);
    }).orElseThrow(() -> new RuntimeException("Post not found with ID: " + postId));
  }

  // Delete a post
  public void deletePost(Integer postId) {
    if (postRepository.existsById(postId)) {
      postRepository.deleteById(postId);
    } else {
      throw new RuntimeException("Post not found with ID: " + postId);
    }
  }
}

