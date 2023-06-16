package com.ratings.ratingService.services;

import com.ratings.ratingService.models.Rating;

import java.util.List;

public interface RatingService {

    public List<Rating> getByHotelid(Integer id);
    public Rating createRating(Rating rating);

}
