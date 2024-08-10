package com.foodApp_UserLogin.service.Impl;

import com.foodApp_UserLogin.Repository.CurrentUserSessionDAO;
import com.foodApp_UserLogin.Repository.LoginDataDAO;
import com.foodApp_UserLogin.Repository.SignUpDAO;
import com.foodApp_UserLogin.exception.LoginException;
import com.foodApp_UserLogin.models.CurrentUserSession;
import com.foodApp_UserLogin.models.LoginData;
import com.foodApp_UserLogin.models.SignUp;
import java.time.LocalDateTime;
import com.foodApp_UserLogin.service.CurrentUserSessionService;
import com.foodApp_UserLogin.service.LoginService;
import com.foodApp_UserLogin.service.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SignUpDAO signUpDAO;

    @Autowired
    private CurrentUserSessionDAO currentUserSessionDAO;

    @Autowired
    private CurrentUserSessionService getCurrentLoginUserSession;

    @Autowired
    private LoginDataDAO loginDataDAO;

    @Override
    public String logInAccount(LoginData loginData) {

        Optional<SignUp> opt = signUpDAO.findById(loginData.getUserId());

        if(!opt.isPresent())
        {
            throw new LoginException("Invalid Login UserId");
        }

        SignUp newSignUp = opt.get();

        Integer newSignUpId = newSignUp.getUserId();
        Optional<CurrentUserSession> currentUserOptional = currentUserSessionDAO.findByUserId(newSignUpId);

        if(currentUserOptional.isPresent()) {
            throw new LoginException("User Already login with this UserId");
        }

        if((newSignUp.getUserId() == loginData.getUserId()) && (newSignUp.getPassword().equals(loginData.getPassword())))
        {
            String key = RandomString.getRandomNumberString();

            CurrentUserSession currentUserSession = new CurrentUserSession(newSignUp.getUserId(),key,LocalDateTime.now());
            currentUserSessionDAO.save(currentUserSession);
            loginDataDAO.save(loginData);

            return currentUserSession.toString();

        }
        else
            throw new LoginException("Invalid UserName or Password!");
    }

    @Override
    public String logOutFromAccount(String key) {

        Optional<CurrentUserSession> currentUserOptional = currentUserSessionDAO.findByUuid(key);
        if(!currentUserOptional.isPresent())
        {
            throw new LoginException("User has not logged in with this UserId");
        }
        CurrentUserSession currentUserSession = getCurrentLoginUserSession.getCurrentUserSession(key);

        currentUserSessionDAO.delete(currentUserSession);

        Optional<LoginData> loginData = loginDataDAO.findById(currentUserOptional.get().getUserId());
        System.out.println(loginData);
        loginDataDAO.delete(loginData.get());


        return "Logged Out......";

    }

}
