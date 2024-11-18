package com.csumb.project3Backend.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class is used to define make queries for feed settings (ratings, subject, date)
 * It should use the repository folder to call the database
 */


@Service
public class FeedService {

//USED FOR WHEN WE ADD DB & REPO FOLDER
//    @Autowired
//    private FeedRepo feedRepo

    public String getAll(){
        return "All Posts";
    }

    public String getHighestRating(int filterSetting){
        return "feed sorted highest -> lowest";
    }
    public String getLowestRating(int filterSetting){
        return "feed sorted lowest -> highest";
    }

    public String getSubject(String subject){
        if(subject.equals("games")){
            return "games";
        }else if (subject.equals("music")){
            return "music";
        } else if (subject.equals("books")){
            return "books";
        }else{
            return "movies";
        }
    }


}