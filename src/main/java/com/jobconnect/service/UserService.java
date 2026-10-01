package com.jobconnect.service;

import org.springframework.stereotype.Service;

import com.jobconnect.entity.User;
import com.jobconnect.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public User loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    
    
}