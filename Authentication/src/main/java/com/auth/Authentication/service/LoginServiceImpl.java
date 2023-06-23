package com.auth.Authentication.service;

import com.auth.Authentication.feignService.UserService;
import com.auth.Authentication.models.Login;
import com.auth.Authentication.models.LoginDTO;
import com.auth.Authentication.models.Users;
import com.auth.Authentication.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private UserService userService;

    @Override
    public Login doLogin(LoginDTO dto) throws Exception {

    ResponseEntity<Users> user=userService.getByPhone(dto.getPhone());
    Users user1=user.getBody();
    if(user1==null){throw new Exception("Please SignUp first with this phone number..");}
    else{

        Login log=loginRepo.findByPhone(user1.getPhone());
        if(log == null) throw new Exception("You already logged in");

        if(dto.getPassword().equals(user1.getPassword())){
            Login login=new Login();
            login.setDateTime(LocalDateTime.now());
            login.setId(user1.getId());
            String key = RandomString.make(7);
            login.setUuid(key);
            return login;
        }
        else{
            throw new Exception("Incorrect Password");
        }

    }


    }

    @Override
    public Login getByUuid(String uuid) throws Exception {
      Login login =loginRepo.findByUuid(uuid);
      if(login != null ){
          return login;
      }
      else{
          throw new Exception("Please login first");
      }
    }





}
