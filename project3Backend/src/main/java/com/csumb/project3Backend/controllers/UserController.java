package com.csumb.project3Backend.controllers;

import org.springframework.web.bind.annotation.*;
import com.csumb.project3Backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * This class is used to define the API endpoints for user settings (login, register, delete, edit, and get data)
 * ALL REQUEST BODY DATA TYPES SHOULD BE REPLACED BY USER OBJECTS FOR CORRECT FORMATTING & TO REDUCE ERRORS
 */


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    // GET method to get all users in the database
    @GetMapping("/all")
    public int getAll() {
        return userService.getAllUsers();
    }


    @PostMapping("/login")
    public int login(@RequestBody int user){
        return userService.loginUser(user);
    }

    //register - create an account
    @PostMapping("/register")
    public int register(@RequestBody int user){
        return userService.addUser(user);
    }

    //delete a user from settings
    @DeleteMapping("/delete")
    public int delete(@RequestBody int user){
        return userService.deleteUser(user);
    }

    //edit user information
    @PutMapping("/edit")
    public int edit(@RequestBody int user){
        return userService.editUser(user);
    }

    //get user info to display on profile(username, etc.)
    @GetMapping("/info")
    public int userInfo(@RequestBody int user){
        return userService.getUserInfo(user);
    }
}