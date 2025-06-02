package com.rollerspeed.rollerspeed.Services;

import com.rollerspeed.rollerspeed.Models.user;
import com.rollerspeed.rollerspeed.Repository.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    private final userRepository userRepository;

    public userService (userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<user> listUsers () {
        return userRepository.findAll();
    }

    public user save (user user) {
        return userRepository.save(user);
    }

    public void deleteById (Long id) {
        userRepository.deleteById(id);
    }
    
}
