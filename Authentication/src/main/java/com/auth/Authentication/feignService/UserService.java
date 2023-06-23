package com.auth.Authentication.feignService;

import com.auth.Authentication.models.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserService {

    @GetMapping("/phone/{phone}")
    public ResponseEntity<Users> getByPhone(@PathVariable String phone);


}
