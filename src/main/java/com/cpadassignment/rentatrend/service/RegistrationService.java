package com.cpadassignment.rentatrend.service;

import com.cpadassignment.rentatrend.repository.UserRepository;
import entity.FinalResponse;
import entity.LoginRequest;
import entity.Registration;
import entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public FinalResponse registerUser(Registration registration) {
        boolean isSuccess = true;
        FinalResponse finalResponse;
        Users newUsers = Users.builder().username(registration.getUsername()).password(registration.getPassword()).addressLine1(registration.getAddressLine1())
                .addressLine2(registration.getAddressLine2()).city(registration.getCity()).state(registration.getState()).firstName(registration.getFirstName())
                .lastName(registration.getLastName()).pincode(registration.getPincode()).mobileNumber(registration.getMobileNumber()).build();
        try {
            userRepository.save(newUsers);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Exception while adding user.");
            isSuccess  = false;
        }
        if(isSuccess)
            finalResponse = FinalResponse.builder().errorCode("RAT_0").status(0).errorMessage("User added successfully.").build();
        else
            finalResponse = FinalResponse.builder().errorCode("RAT_1").status(1).errorMessage("There was an issue in adding new user.").build();
        return finalResponse;
    }

    public FinalResponse loginUser(LoginRequest loginRequest) {
        boolean isSuccess = true;
        FinalResponse finalResponse = null;
        Users user = null;
        try {
            user = userRepository.findItemByName(loginRequest.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Exception while adding user.");
            isSuccess  = false;
        }
        if(isSuccess) {
            if(null != user) {
                if(StringUtils.equals(user.getPassword(),loginRequest.getPassword()))
                    finalResponse = FinalResponse.builder().status(0).errorCode("RAT_0").errorMessage("User Logged In Successfully.").build();
                else
                    finalResponse = FinalResponse.builder().status(0).errorCode("RAT_2").errorMessage("Wrong User ID/Password.").build();
            } else
                finalResponse = FinalResponse.builder().status(0).errorCode("RAT_3").errorMessage("User does not exist. Please register.").build();
        } else
            finalResponse = FinalResponse.builder().status(1).errorCode("RAT_4").errorMessage("There was a problem in validating the user.").build();
        return finalResponse;
    }
}
