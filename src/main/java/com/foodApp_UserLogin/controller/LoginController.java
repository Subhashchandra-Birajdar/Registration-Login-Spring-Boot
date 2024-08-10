package com.foodApp_UserLogin.controller;

import com.foodApp_UserLogin.models.LoginData;
import com.foodApp_UserLogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    //http://localhost:8080/api/login
    public String loginHandler(@RequestBody LoginData loginData) {
        return loginService.logInAccount(loginData);
    }

    @PatchMapping("/logout")
    // http://localhost:8080/api/logout/
    public String logOutFromAccount(@RequestParam String key)
    {
        return loginService.logOutFromAccount(key);
    }
    
}
