package com.csumb.project3Backend.repos;

import com.csumb.project3Backend.entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

  // Find all Comments by a specific user
  List<Comment> findByComment_UserId(Integer userId);

  // Find all Comments on a specific post
  List<Comment> findByPostId(Integer postId);
}

