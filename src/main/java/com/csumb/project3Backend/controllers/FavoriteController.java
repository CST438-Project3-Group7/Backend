package com.csumb.project3Backend.controllers;

import com.csumb.project3Backend.entities.Favorite;

import com.csumb.project3Backend.services.FavoriteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

  @Autowired
  private FavoriteService favoriteService;

  // Get all favorites of a user
  @GetMapping("/user/{userId}")
  public List<Favorite> getFavoritesByUserId(@PathVariable Integer userId) {
    return favoriteService.getFavoritesByUserId(userId);
  }

}

