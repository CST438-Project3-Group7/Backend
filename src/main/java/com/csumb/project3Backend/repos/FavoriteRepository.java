package com.csumb.project3Backend.repos;

import com.csumb.project3Backend.entities.Favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

  // Find all Favorites of a specific user
  List<Favorite> findBy_UserId(Integer userId);

}

