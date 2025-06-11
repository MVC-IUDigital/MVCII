package com.rollerspeed.rollerspeed.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rollerspeed.rollerspeed.Models.user;
import com.rollerspeed.rollerspeed.Repository.userRepository;

@Service
public class userService {

    private final userRepository userRepository;

    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<user> listUsers() {
        return userRepository.findAll();
    }

    public user save(user user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public user getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean emailYaExiste(String correo) {
        Optional<user> usuario = userRepository.findByCorreo(correo);
        return usuario.isPresent();
    }
}

