package com.csumb.project3Backend.controllers;

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
 * ALL REQUEST BODY DATA TYPES SHOULD BE REPLACED BY USER OBJECTS FOR CORRECT FORMATTING & TO REDUCE ERRORS
 */


@RestController
@RequestMapping("/users")
public class UserController {


    // GET method to get all users in the database
    @GetMapping("/all")
    public int getAll() {

        return 1;
    }


    @PostMapping("/login")
    public void login(@RequestBody int user){

    }

    //register/create an account
    @PostMapping("/register")
    public void register(@RequestBody int user){

    }

    //delete a user from settings
    @DeleteMapping("/delete")
    public void delete(@RequestBody int user){

    }

    //edit user information
    @PutMapping("/edit")
    public void edit(@RequestBody int user){

    }

    //get user info to display on profile(username, etc.)
    @GetMapping("/info")
    public void userInfo(@RequestBody int user){

    }
}