package com.ekrishak.userservice;

import com.ekrishak.userservice.form.UserForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class UserServiceApplication {

	public static Map<String, UserForm> registrationMap = new HashMap<>();

	public static Map<String, String> loginMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
