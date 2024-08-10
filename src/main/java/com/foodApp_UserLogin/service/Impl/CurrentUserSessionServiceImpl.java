package com.foodApp_UserLogin.service.Impl;

import com.foodApp_UserLogin.Repository.CurrentUserSessionDAO;
import com.foodApp_UserLogin.Repository.SignUpDAO;
import com.foodApp_UserLogin.exception.LoginException;
import com.foodApp_UserLogin.models.CurrentUserSession;
import com.foodApp_UserLogin.models.SignUp;
import com.foodApp_UserLogin.service.CurrentUserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrentUserSessionServiceImpl implements CurrentUserSessionService {

    @Autowired
    private CurrentUserSessionDAO currentUserSessionDAO;

    @Autowired
    private SignUpDAO signUpDAO;

    @Override
    public CurrentUserSession getCurrentUserSession(String key) {

        Optional<CurrentUserSession> currentUser = currentUserSessionDAO.findByUuid(key);
        if(!currentUser.isPresent())
        {
            throw new LoginException("UnAuthorized!!!");
        }
        return currentUser.get();
    }

    @Override
    public Integer getCurrentUserSessionId(String key) {

        Optional<CurrentUserSession> currentUser = currentUserSessionDAO.findByUuid(key);
        if(!currentUser.isPresent())
        {
            throw new LoginException("UnAuthorized!!!");
        }
        return currentUser.get().getId();

    }


    @Override
    public SignUp getSignUpDetails(String key) {

        Optional<CurrentUserSession> currentUser = currentUserSessionDAO.findByUuid(key);
        if(!currentUser.isPresent())
        {
            return null;
        }
        Integer SignUpUserId = currentUser.get().getUserId();
        System.out.println(SignUpUserId );

        return (signUpDAO.findById(SignUpUserId)).get();
    }

}
