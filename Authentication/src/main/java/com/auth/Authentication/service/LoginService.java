package com.auth.Authentication.service;

import com.auth.Authentication.models.Login;
import com.auth.Authentication.models.LoginDTO;

public interface LoginService {

    public Login doLogin(LoginDTO dto) throws Exception;

    public Login getByUuid(String uuid) throws Exception;

}
