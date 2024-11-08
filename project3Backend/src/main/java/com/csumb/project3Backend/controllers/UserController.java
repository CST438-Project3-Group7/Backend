package com.csumb.project3Backend.controllers;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * This class is used to define the API endpoints and their names
 */
//test

@RestController
@RequestMapping("/users")
public class UserController {

    private final Firestore db;

    public UserController(Firestore db){
        this.db = db;
    }

    // GET method to get all users
    @GetMapping("/all")
    public List<Map<String, Object>> getAll() throws InterruptedException, ExecutionException {
        //placeholder for User Object Model

        ApiFuture<QuerySnapshot> query = db.collection("users").get();

        // Retrieve query results
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        List<Map<String, Object>> users = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            users.add(document.getData());
        }

        return users;
    }
}