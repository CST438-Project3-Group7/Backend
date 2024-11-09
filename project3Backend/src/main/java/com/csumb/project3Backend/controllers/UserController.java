package com.csumb.project3Backend.controllers;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * This class is used to define the API endpoints for user settings (login, register, delete, edit, and get data)
 * ALL MAP<> DATA TYPES SHOULD BE REPLACED BY USER OBJECTS FOR CORRECT FORMATTING & TO REDUCE ERRORS
 */


@RestController
@RequestMapping("/users")
public class UserController {

    private final Firestore db;

    public UserController(Firestore db){
        this.db = db;
    }

    // GET method to get all users in the database
    @GetMapping("/all")
    public List<Map<String, Object>> getAll() throws InterruptedException, ExecutionException {

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

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> user) throws InterruptedException, ExecutionException{
        //return the user if a succesful login; Else returns an empty object

        String username = (String) user.get("username");
        String password = (String) user.get("password");


        // Reference to the "users" collection in Firestore
        CollectionReference usersRef = db.collection("users");

        // Query to find a user with the given username and password
        Query query = usersRef.whereEqualTo("username", username).whereEqualTo("password", password);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        if (documents.isEmpty()){
            System.out.println("Error! User Not Found");
            return new HashMap<>();
        }else{
            System.out.println("User Found!");
            return user;
        }

    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, Object> user) throws InterruptedException, ExecutionException{
        //return user if a succesfull registration; Else returns an empty object

        String username = (String) user.get("username");
        String password = (String) user.get("password");
        String role = "user";

        //THIS SHOULD BE CHANGED TO A USER MODEL NOT A HASHMAP
        Map<String, Object> newUser = new HashMap<>();
        newUser.put("username", username);
        newUser.put("password", password);
        newUser.put("role", role);



        CollectionReference usersRef = db.collection("users");

        // Find the highest existing userID
        ApiFuture<QuerySnapshot> query = usersRef.orderBy("userID", Query.Direction.DESCENDING).limit(1).get();
        List<QueryDocumentSnapshot> documents = query.get().getDocuments();

        int newUserId = 1; // Default to 1 if no users exist
        if (!documents.isEmpty()) {
            int maxUserId = documents.get(0).getLong("userID").intValue();
            newUserId = maxUserId + 1; // Increment highest userID by 1
        }

        // Set the new userID
        newUser.put("userID", newUserId);


        // Add new user to DB
        ApiFuture<DocumentReference> addedUserRef = usersRef.add(newUser);

        try {
            // Check if the user was added
            DocumentReference documentRef = addedUserRef.get();
            if (documentRef != null) {
                return newUser;
            }
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
        }

        return new HashMap<>();
    }
}