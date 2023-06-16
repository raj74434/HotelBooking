package com.hotel.hotelService.service;

import com.hotel.hotelService.feignClient.RatingService;
import com.hotel.hotelService.models.Hotel;
import com.hotel.hotelService.models.Rating;
import com.hotel.hotelService.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServicesImpl implements HotelServices{

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private RatingService ratingService;

    public Hotel createHotel (Hotel hotel){
        return hotelRepo.save(hotel);
    }

    public List<Hotel> allhotels(){
        List<Hotel> hotels=hotelRepo.findAll();
//        List<Rating> ratings=new ArrayList<>();
        for(int x=0;x<hotels.size();x++){
           List<Rating> ratings= ratingService.getRatingByHotelId(hotels.get(x).getId()).getBody();
            hotels.get(x).setRatings(ratings);
        }


        return hotels;
    }

    public Hotel getHotelById(Integer id) throws  Exception{
        return hotelRepo.findById(id).orElseThrow(() ->new Exception("unable to find hotel with this id"));
    }

}
