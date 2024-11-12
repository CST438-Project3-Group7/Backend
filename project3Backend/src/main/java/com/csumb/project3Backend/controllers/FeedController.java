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
 * This class is used to define the API endpoints for feed settings (pull all, pull by name, pull by topic)
 */


@RestController
@RequestMapping("/posts")
public class FeedController {

    private final Firestore db;

    public UserController(Firestore db){
        this.db = db;
    }

    // Put controller methods here


}