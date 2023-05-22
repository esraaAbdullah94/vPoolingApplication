package com.example.Polling.Service;

import com.example.Polling.Modle.User;
import com.example.Polling.Modle.UserRegistrationRequest;
import com.example.Polling.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setIsActive(true);

        return userRepository.save(user);
    }
}