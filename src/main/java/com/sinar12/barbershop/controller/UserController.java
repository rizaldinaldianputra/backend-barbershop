package com.sinar12.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sinar12.barbershop.dto.UserResponse;
import com.sinar12.barbershop.model.User;
import com.sinar12.barbershop.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Endpoint untuk mendapatkan semua users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    // Endpoint untuk mendapatkan user berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserResponse response = new UserResponse();
            response.setSuccess(true);
            response.setMessage("User found");
            response.setData(userOptional.get());
            return ResponseEntity.ok(response);
        } else {
            UserResponse response = new UserResponse();
            response.setSuccess(false);
            response.setMessage("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // Endpoint untuk menambahkan user baru
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody User user) {
        try {
            User newUser = userRepository.save(user);
            UserResponse response = new UserResponse();
            response.setSuccess(true);
            response.setMessage("User created successfully");
            response.setData(newUser);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            UserResponse response = new UserResponse();
            response.setSuccess(false);
            response.setMessage("Failed to create user");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint untuk mengupdate user berdasarkan ID
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User updatedUser = userData.get();
            updatedUser.setFullName(user.getFullName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setAddress(user.getAddress());

            userRepository.save(updatedUser);

            UserResponse response = new UserResponse();
            response.setSuccess(true);
            response.setMessage("User updated successfully");
            response.setData(updatedUser);
            return ResponseEntity.ok(response);
        } else {
            UserResponse response = new UserResponse();
            response.setSuccess(false);
            response.setMessage("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // Endpoint untuk menghapus user berdasarkan ID
    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {
        try {
            userRepository.deleteById(id);
            UserResponse response = new UserResponse();
            response.setSuccess(true);
            response.setMessage("User deleted successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            UserResponse response = new UserResponse();
            response.setSuccess(false);
            response.setMessage("Failed to delete user");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
