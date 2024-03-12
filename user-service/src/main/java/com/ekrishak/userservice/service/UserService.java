package com.ekrishak.userservice.service;

import com.ekrishak.userservice.UserServiceApplication;
import com.ekrishak.userservice.base.BaseResponse;
import com.ekrishak.userservice.entity.User;
import com.ekrishak.userservice.form.UserForm;
import com.ekrishak.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public BaseResponse registerUser(UserForm userForm) {
        BaseResponse response = new BaseResponse();
        String otp = "1234";
        userForm.setOtp(otp);
        UserServiceApplication.registrationMap.put(userForm.getMobile(), userForm);
        return response.set(200, "OTP sent...", userForm.getMobile());
    }

    public BaseResponse validateRegistration(UserForm userForm) {
        BaseResponse response = new BaseResponse();
        UserForm savedUserForm = UserServiceApplication.registrationMap.get(userForm.getMobile());
        if (!userForm.getOtp().equals(savedUserForm.getOtp())) {
            return response.set(302, "Invalid OTP");
        }
        User user = new User();
        user.setName(savedUserForm.getName());
        user.setMobile(savedUserForm.getMobile());
        user.setCreatedBy(1);
        user.setCreatedDate(new Date());
        user = userRepository.save(user);
        UserServiceApplication.registrationMap.remove(user.getMobile());
        return response.set(200, "User registered successfully", user);
    }

    public BaseResponse login(String mobile) {
        BaseResponse response = new BaseResponse();
        String otp = "1234";
        UserServiceApplication.loginMap.put(mobile, otp);
        return response.set(200, "OTP sent...", mobile);
    }

    public BaseResponse validateLogin(String mobile, String otp) {
        BaseResponse response = new BaseResponse();
        String savedOtp = UserServiceApplication.loginMap.get(mobile);
        if (!otp.equals(savedOtp)) {
            return response.set(302, "Invalid OTP");
        }
        User user = userRepository.findByMobile(mobile);
        return response.set(200, "Login success", user);
    }
}
