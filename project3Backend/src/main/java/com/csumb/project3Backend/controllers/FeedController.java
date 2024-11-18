package com.csumb.project3Backend.controllers;
import org.springframework.web.bind.annotation.*;
import com.csumb.project3Backend.services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * This class is used to define the API endpoints for feed display & filtering (date, ratings, subject)
 */


@RestController
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private FeedService feedService;

    // returns all post sorted from last added to first added
    @GetMapping("/all")
    public String getAll(){
        return feedService.getAll();
    }

    // return feed sorted by rating (highest -> lowest)
    @GetMapping("/highestRating")
    public String getHighestRating(@RequestBody int filterSetting){
        return feedService.getHighestRating(filterSetting);
    }

    // return feed sorted by rating (lowest -> highest)
    @GetMapping("/lowestRating")
    public String getLowestRating(@RequestBody int filterSetting){
        return feedService.getLowestRating(filterSetting);
    }

    // return feed sorted by subject (takes in the name of the subject they want to see)
    @GetMapping("/subject")
    public String getSubject(@RequestBody String subject){
        return feedService.getSubject(subject);
    }



}