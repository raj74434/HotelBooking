package com.auth.Authentication.repository;

import com.auth.Authentication.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo  extends JpaRepository<Login,Integer> {

    public Login findByPhone(String email);
    public Login findByUuid(String uuid);


}
