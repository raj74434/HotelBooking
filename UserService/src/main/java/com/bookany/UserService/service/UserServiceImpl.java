package com.bookany.UserService.service;

import com.bookany.UserService.Repository.UserRepo;
import com.bookany.UserService.dto.UserDto;
import com.bookany.UserService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

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

}
