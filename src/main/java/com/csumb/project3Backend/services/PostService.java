package com.csumb.project3Backend.services;

import com.csumb.project3Backend.entities.Post;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;

@Service
public class PostService {

  private final Firestore db;

  public PostService() {
    this.db = FirestoreClient.getFirestore();
  }

  // Create a new post
  public String createPost(Post post) throws ExecutionException, InterruptedException {
    ApiFuture<DocumentReference> future = db.collection("posts").add(post);
    DocumentReference postRef = future.get();
    return postRef.getId(); // Return generated post ID
  }

  // Get a post by ID
  public Post getPostById(String postId) throws ExecutionException, InterruptedException {
    DocumentSnapshot snapshot = db.collection("posts").document(postId).get().get();
    if (snapshot.exists()) {
      return snapshot.toObject(Post.class);
    }
    return null;
  }

  // Get all posts
  public List<Post> getAllPosts() throws ExecutionException, InterruptedException {
    List<Post> posts = new ArrayList<>();
    ApiFuture<QuerySnapshot> future = db.collection("posts").get();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    for (DocumentSnapshot document : documents) {
      posts.add(document.toObject(Post.class));
    }
    return posts;
  }

  // Update an existing post
  public boolean updatePost(String postId, Post updatedPost) throws ExecutionException, InterruptedException {
    DocumentReference postRef = db.collection("posts").document(postId);
    ApiFuture<WriteResult> future = postRef.set(updatedPost);
    return future.get() != null; // Return true if update was successful
  }

  // Delete a post by ID
  public boolean deletePost(String postId) throws ExecutionException, InterruptedException {
    DocumentReference postRef = db.collection("posts").document(postId);
    ApiFuture<WriteResult> future = postRef.delete();
    return future.get() != null; // Return true if delete was successful
  }
}
