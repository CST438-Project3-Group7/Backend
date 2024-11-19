package com.csumb.project3Backend.repos;

import com.csumb.project3Backend.entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

  // Find all Comments by a specific user
  List<Comment> findByComment_UserId(Integer userId);

  // Find all posts related to a specific subject
  List<Comment> findBySubject_SubjectId(Integer subjectId);

  // Find all posts ordered by the number of likes in descending order
  List<Comment> findAllByOrderByLikesDesc();
}

