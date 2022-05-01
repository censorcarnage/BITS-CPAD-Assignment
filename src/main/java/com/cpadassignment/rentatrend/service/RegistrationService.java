package com.cpadassignment.rentatrend.service;

import com.cpadassignment.rentatrend.repository.UserRepository;
import entity.FinalResponse;
import entity.Registration;
import entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
