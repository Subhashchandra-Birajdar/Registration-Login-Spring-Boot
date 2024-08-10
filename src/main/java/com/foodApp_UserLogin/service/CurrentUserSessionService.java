package com.foodApp_UserLogin.service;

import com.foodApp_UserLogin.exception.LoginException;
import com.foodApp_UserLogin.models.CurrentUserSession;
import com.foodApp_UserLogin.models.SignUp;

public interface CurrentUserSessionService {

    CurrentUserSession getCurrentUserSession(String key) throws LoginException;
    Integer getCurrentUserSessionId(String key) throws LoginException;;

    SignUp getSignUpDetails(String key) throws LoginException;;


}
