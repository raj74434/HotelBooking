package com.bookany.UserService.Repository;

import com.bookany.UserService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

    public Optional<User> findByPhone(String phone);

}
