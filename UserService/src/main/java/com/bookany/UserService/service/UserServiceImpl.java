package com.bookany.UserService.service;

import com.bookany.UserService.Repository.UserRepo;
import com.bookany.UserService.dto.UserDto;
import com.bookany.UserService.feignClientService.HotelService;
import com.bookany.UserService.models.Hotel;
import com.bookany.UserService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    public User createUser(UserDto dto){
        User user=new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        return userRepo.save(user);
    }
    public List<User> allUser(){
        return userRepo.findAll();
    }


    public User getById(Integer id) throws Exception {
        User user=userRepo.findById(id).orElseThrow(()->  new Exception("User Not found"));

        ResponseEntity<List<Hotel>> hotels=hotelService.allHotels();
        List<Hotel> hotel= hotels.getBody();

        System.out.println(hotel);
        System.out.println("Yes");
        user.setHotels(hotel);
        return user;
    }
}
