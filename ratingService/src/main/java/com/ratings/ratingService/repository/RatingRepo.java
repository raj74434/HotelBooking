package com.ratings.ratingService.repository;

import com.ratings.ratingService.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,Integer> {

    public List<Rating> findByHotelId(Integer id);

}
