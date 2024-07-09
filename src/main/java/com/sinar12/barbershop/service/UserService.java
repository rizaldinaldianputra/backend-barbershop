package com.sinar12.barbershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinar12.barbershop.model.User;
import com.sinar12.barbershop.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    // tambahkan method lain sesuai kebutuhan
}
