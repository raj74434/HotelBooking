package com.bookany.UserService.Repository;

import com.bookany.UserService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
