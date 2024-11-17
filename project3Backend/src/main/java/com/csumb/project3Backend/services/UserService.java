package com.csumb.project3Backend.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class is used to define make queries for user settings (login, register, delete, edit, and get data)
 * It should user the repository folder to call the database
 */


@Service
public class UserService {

//USED FOR WHEN WE ADD DB & REPO FOLDER
//    @Autowired
//    private UserRepo userRepo

    public String getAllUsers(){
        return "All Users";
    }
    public String loginUser(int user){
        return "User Logged In";
    }

    public String addUser(int user){
        return "User Registered";
    }

    public String deleteUser(int user){
        return "User Deleted";
    }

    public String editUser(int user){
        return "User Edited";
    }

    public String getUserInfo(int user){
        return "User Info for User with ID: " + user;
    }
}