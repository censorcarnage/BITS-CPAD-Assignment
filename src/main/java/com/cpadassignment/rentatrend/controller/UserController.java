package com.cpadassignment.rentatrend.controller;

import com.cpadassignment.rentatrend.service.RegistrationService;
import entity.FinalResponse;
import entity.LoginRequest;
import entity.Registration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<FinalResponse> registerUser(@RequestBody Registration registration) {
        HttpStatus httpStatus;
        log.info("Request received {}",registration);
        FinalResponse finalResponse = registrationService.registerUser(registration);
        if(finalResponse.getStatus() == 0)
            httpStatus = HttpStatus.OK;
        else
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(finalResponse,httpStatus);
    }

    @PostMapping("/login")
    public ResponseEntity<FinalResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        HttpStatus httpStatus;
        log.info("Request received {}",loginRequest);
        FinalResponse finalResponse = registrationService.loginUser(loginRequest);
        if(finalResponse.getStatus() == 0)
            httpStatus = HttpStatus.OK;
        else
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(finalResponse,httpStatus);
    }
}
