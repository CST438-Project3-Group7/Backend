package com.csumb.project3Backend.controllers;

import org.springframework.web.bind.annotation.*;
import com.csumb.project3Backend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * This class is used to define the API endpoints for posts and comments(create, edit, delete)
 */


@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/add")
    public String addPost(@RequestBody int post){
        return postService.addPost(post);
    }

    @PostMapping("/addComment")
    public String addComment(@RequestBody int comment){
        return postService.addComment(comment);
    }

    @PutMapping("/edit")
    public String editPost(@RequestBody int post){
        return postService.editPost(post);
    }

    @PutMapping("/editComment")
    public String editComment(@RequestBody int comment){
        return postService.editComment(comment);
    }

    @DeleteMapping("/delete")
    public String deletePost(@RequestBody int post){
        return postService.deletePost(post);
    }

    @DeleteMapping("/deleteComment")
    public String deleteComment(@RequestBody int comment){
        return postService.deleteComment(comment);
    }
}