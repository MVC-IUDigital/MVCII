package com.rollerspeed.rollerspeed.Services;

import com.rollerspeed.rollerspeed.Models.user;
import com.rollerspeed.rollerspeed.Repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    
    private final userRepository userRepository;

    public userService (userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<user> listUsers () {
        return userRepository.findAll();
    }

    
}
