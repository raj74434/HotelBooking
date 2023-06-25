package com.auth.Authentication.controllers;

import com.auth.Authentication.models.Login;
import com.auth.Authentication.models.LoginDTO;
import com.auth.Authentication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Login> doLogin(LoginDTO dto) throws Exception {

       return new ResponseEntity<>( loginService.doLogin(dto), HttpStatus.OK);

    }

    @GetMapping("/uuid/{uuid}")
    private ResponseEntity<Login> findUserInLogedIn(String uuid) throws Exception {

        return new ResponseEntity<>(loginService.getByUuid(uuid),HttpStatus.OK);

    }


}
