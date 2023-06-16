package com.hotel.hotelService.controllers;

import com.hotel.hotelService.models.Hotel;
import com.hotel.hotelService.service.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelServices hotelService;

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Hotel>> allHotels(){
       return new ResponseEntity<>(hotelService.allhotels(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Integer id) throws Exception {

        return new ResponseEntity<>(hotelService.getHotelById(id),HttpStatus.OK);
    }

}
