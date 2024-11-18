package com.csumb.project3Backend.repos;

import com.csumb.project3Backend.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

  // Find all posts by a specific user
  List<Post> findByUser_UserId(Integer userId);

  // Find all posts related to a specific subject
  List<Post> findBySubject_SubjectId(Integer subjectId);

  // Find all posts ordered by the number of likes in descending order
  List<Post> findAllByOrderByLikesDesc();
}

