package com.example.Polling.Modle;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationRequest {
    public UserRegistrationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;
}