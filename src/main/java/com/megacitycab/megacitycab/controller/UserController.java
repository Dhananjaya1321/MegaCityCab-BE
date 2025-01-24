package com.megacitycab.megacitycab.controller;

import com.megacitycab.megacitycab.service.UserService;
import com.megacitycab.megacitycab.util.ExceptionHandler;
import com.megacitycab.megacitycab.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/check-login")
    private ResponseEntity<ResponseUtil> checkLogin(
            @RequestParam("emailOrUsername") String emailOrUsername,
            @RequestParam("password") String password
    ) {
        try {
            return ResponseEntity.ok(new ResponseUtil(HttpStatus.OK, "Successfully loaded", userService.checkLogin(emailOrUsername, password)));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());

            if (e.getMessage().equals("Incorrect email or username") || e.getMessage().equals("Incorrect password"))
                return ExceptionHandler.handleCustomException(HttpStatus.BAD_REQUEST, e);

            return ExceptionHandler.handleException(e);
        }
    }
}
