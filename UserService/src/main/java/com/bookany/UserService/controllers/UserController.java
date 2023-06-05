package com.bookany.UserService.controllers;

import com.bookany.UserService.dto.UserDto;
import com.bookany.UserService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookany.UserService.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDto dto){


        return new ResponseEntity<> (userService.createUser(dto), HttpStatus.CREATED);

    }
    @GetMapping("")
    public ResponseEntity<List<User>> allUsers(){
        return new ResponseEntity<>(userService.allUser(),HttpStatus.OK);
    }



}
