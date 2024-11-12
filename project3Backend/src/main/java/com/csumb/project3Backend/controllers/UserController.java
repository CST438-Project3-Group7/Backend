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
 * ALL MAP<> DATA TYPES SHOULD BE REPLACED BY USER OBJECTS FOR CORRECT FORMATTING & TO REDUCE ERRORS
 */


@RestController
@RequestMapping("/users")
public class UserController {


    // GET method to get all users in the database
    @GetMapping("/all")
    public int getAll() {

        return 1;
    }
}