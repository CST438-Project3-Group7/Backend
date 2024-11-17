package com.csumb.project3Backend.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class is used to define make queries for posting & commenting (add, edit, delete)
 * It should use the repository folder to call the database
 */


@Service
public class PostService {

//USED FOR WHEN WE ADD DB & REPO FOLDER
//    @Autowired
//    private PostRepo postRepo

    public String addPost(int post){
        return "Post Added";
    }

    public String addComment(int comment){
        return "Comment Added";
    }

    public String editPost(int post){
        return "Post Edited";
    }

    public String editComment(int comment){
        return "Comment Edited";
    }

    public String deletePost(int post){
        return "Post Deleted";
    }

    public String deleteComment(int comment){
        return "Comment Deleted";
    }





}