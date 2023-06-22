package com.bookany.UserService.service;

import com.bookany.UserService.dto.UserDto;
import com.bookany.UserService.models.User;

import java.util.List;

public interface UserService {

    public User createUser(UserDto dto);
    public List<User> allUser();

    public User getById(Integer id) throws Exception;

    public User getByPhone(String phone) throws Exception;

}
