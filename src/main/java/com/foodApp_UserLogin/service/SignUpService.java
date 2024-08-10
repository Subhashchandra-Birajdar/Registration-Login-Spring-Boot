package com.foodApp_UserLogin.service;

import com.foodApp_UserLogin.exception.LoginException;
import com.foodApp_UserLogin.models.SignUp;

public interface SignUpService {

    public SignUp createNewSignUp(SignUp signUp) throws LoginException;;

    public SignUp updateSignUpDetails(SignUp signUp,String key) throws LoginException;;

}
