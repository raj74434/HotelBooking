package com.ratings.ratingService.controllers;

import com.ratings.ratingService.models.Rating;
import com.ratings.ratingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("hotelId") Integer id){
       return new ResponseEntity<>( ratingService.getByHotelid(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
       return new ResponseEntity<>(ratingService.createRating(rating),HttpStatus.CREATED);
    }


}
