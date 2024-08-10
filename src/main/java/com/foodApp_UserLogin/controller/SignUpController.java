package com.foodApp_UserLogin.controller;

import com.foodApp_UserLogin.models.SignUp;
import com.foodApp_UserLogin.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/signUp")
    public ResponseEntity<SignUp> createNewSignUpHandler(@RequestBody SignUp newSignUp) {

        SignUp newSignedUp =signUpService.createNewSignUp(newSignUp);
        return new ResponseEntity<SignUp>(newSignedUp, HttpStatus.CREATED);

    }

    @PutMapping("/updateSignUp")
    public ResponseEntity<SignUp> updateSignUpDetailsHandler(@RequestBody SignUp signUp, @RequestParam String key)
    {
        SignUp newUpdatedSignUp = signUpService.updateSignUpDetails(signUp,key);

        return new ResponseEntity<SignUp>(newUpdatedSignUp,HttpStatus.ACCEPTED);


    }

}
