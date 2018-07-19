package com.omega.mtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.omega.mtest.services.UserService;
import com.omega.mtest.services.UserServiceImpl;

@SpringBootApplication
public class MTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MTestApplication.class, args);
    }
    
    @Bean
    public UserService userService() {
    	return new UserServiceImpl();
    }
}
