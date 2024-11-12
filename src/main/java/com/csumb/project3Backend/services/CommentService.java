package com.csumb.project3Backend.services;

import com.csumb.project3Backend.entities.Comment;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import com.google.cloud.Timestamp;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommentService {

  private final Firestore db;

  public CommentService() {
    this.db = FirestoreClient.getFirestore();
  }

  // Create a new comment
  public String createComment(Comment comment) throws ExecutionException, InterruptedException {
    Map<String, Object> commentData = new HashMap<>();
    commentData.put("user", db.collection("users").document(comment.getUserId().getUserId())); // Reference to user
    commentData.put("postId", comment.getPostId());
    commentData.put("dateTime", Timestamp.now()); // Use Firestore-compatible Timestamp
    commentData.put("commentText", comment.getText());
    commentData.put("likes", comment.getLikes());
    commentData.put("dislikes", comment.getDislikes());

    ApiFuture<DocumentReference> future = db.collection("comments").add(commentData);
    DocumentReference commentRef = future.get();
    return commentRef.getId(); // Return the generated comment ID
  }

  // Retrieve a comment by its ID
  public Comment getCommentById(String commentId) throws ExecutionException, InterruptedException {
    DocumentSnapshot snapshot = db.collection("comments").document(commentId).get().get();
    if (snapshot.exists()) {
      return snapshot.toObject(Comment.class);
    }
    return null;
  }

  // Retrieve all comments for a specific post
  public List<Comment> getCommentsByPostId(String postId) throws ExecutionException, InterruptedException {
    List<Comment> comments = new ArrayList<>();
    ApiFuture<QuerySnapshot> future = db.collection("comments").whereEqualTo("postId", postId).get();
    for (DocumentSnapshot document : future.get().getDocuments()) {
      comments.add(document.toObject(Comment.class));
    }
    return comments;
  }

  // Update an existing comment
  public boolean updateComment(String commentId, Map<String, Object> updates) throws ExecutionException, InterruptedException {
    ApiFuture<WriteResult> future = db.collection("comments").document(commentId).update(updates);
    return future.get() != null;
  }

  // Delete a comment by ID
  public boolean deleteComment(String commentId) throws ExecutionException, InterruptedException {
    ApiFuture<WriteResult> future = db.collection("comments").document(commentId).delete();
    return future.get() != null;
  }
}

