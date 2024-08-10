package com.foodApp_UserLogin.service;

import com.foodApp_UserLogin.exception.LoginException;
import com.foodApp_UserLogin.models.LoginData;

public interface LoginService {

    public String logInAccount(LoginData loginData) throws LoginException;
    public String logOutFromAccount(String key) throws LoginException;

}

