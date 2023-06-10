package com.hotel.hotelService.service;

import com.hotel.hotelService.models.Hotel;

import java.util.List;

public interface HotelServices {

    public Hotel createHotel (Hotel hotel);
    public List<Hotel> allhotels();

    public Hotel getHotelById(Integer id) throws  Exception;

}
