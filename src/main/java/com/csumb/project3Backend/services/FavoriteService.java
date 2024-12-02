package com.csumb.project3Backend.services;

import com.csumb.project3Backend.entities.Favorite;
import com.csumb.project3Backend.repos.FavoriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

  @Autowired
  private FavoriteRepository favoriteRepository;

  // Get all favorites of a user
  public List<Favorite> getFavoritesByUserId(Integer userId) {
    return favoriteRepository.findByUser_UserId(userId);
  }

}

