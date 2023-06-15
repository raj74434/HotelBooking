package com.bookany.UserService.feignClientService;

import com.bookany.UserService.models.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotel/{id}")
     ResponseEntity<Hotel> getHotel(@PathVariable Integer id) throws Exception ;


    @GetMapping ("/hotel/")
     ResponseEntity<List<Hotel>> allHotels();

}
