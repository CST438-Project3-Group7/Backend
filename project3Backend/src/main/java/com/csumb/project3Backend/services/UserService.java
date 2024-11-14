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

    public int getAllUsers(){
        return 0;
    }
    public int loginUser(int user){
        return 1;
    }

    public int addUser(int user){
        return 2;
    }

    public int deleteUser(int user){
        return 3;
    }

    public int editUser(int user){
        return 4;
    }

    public int getUserInfo(int user){
        return 5;
    }
}