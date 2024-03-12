package com.ekrishak.userservice.controller;

import com.ekrishak.userservice.base.BaseResponse;
import com.ekrishak.userservice.form.UserForm;
import com.ekrishak.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public BaseResponse registerUser(@RequestBody UserForm userForm) {
        return userService.registerUser(userForm);
    }

    @PostMapping("/validateRegistration")
    public BaseResponse validateRegistration(@RequestBody UserForm userForm) {
        return userService.validateRegistration(userForm);
    }

    @PostMapping("/login")
    public BaseResponse login(@RequestParam("mobile") String mobile) {
        return userService.login(mobile);
    }

    @PostMapping("/validateLogin")
    public BaseResponse validateLogin(@RequestParam("mobile") String mobile,
                                      @RequestParam("otp") String otp) {
        return userService.validateLogin(mobile, otp);
    }
}
