package com.ratings.ratingService.services;

import com.ratings.ratingService.models.Rating;
import com.ratings.ratingService.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepo ratingRepo;

    public List<Rating> getByHotelid(Integer id){
        System.out.println("-----------------------------------------------------");
        System.out.println(id);
//        System.out.println();

        List<Rating> lst=new ArrayList<>();
        return (ratingRepo.findByHotelId(id));
//       return lst;

    }

    public Rating createRating(Rating rating){
       return ratingRepo.save(rating);
    }

}
