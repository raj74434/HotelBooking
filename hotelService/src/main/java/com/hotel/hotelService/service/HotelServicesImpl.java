package com.hotel.hotelService.service;

import com.hotel.hotelService.models.Hotel;
import com.hotel.hotelService.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServicesImpl implements HotelServices{

    @Autowired
    private HotelRepo hotelRepo;

    public Hotel createHotel (Hotel hotel){
        return hotelRepo.save(hotel);
    }

    public List<Hotel> allhotels(){
        return hotelRepo.findAll();
    }

    public Hotel getHotelById(Integer id) throws  Exception{
        return hotelRepo.findById(id).orElseThrow(() ->new Exception("unable to find hotel with this id"));
    }

}
