package com.example.Polling.Controller;

import com.example.Polling.Modle.UserRegistrationRequest;
import com.example.Polling.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
@Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest request) {
        // Validate request and handle errors if needed
        userService.createUser(request.getUsername(), request.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body("User registration successful.");
    }
}
