package com.developmentTracking.developtrack.service;

import com.developmentTracking.developtrack.model.User;
import com.developmentTracking.developtrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Login logic
    public User login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if ("disabled".equalsIgnoreCase(user.getUserStatus())) {
                throw new RuntimeException("Account is disabled. Please contact admin.");
            }

            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new RuntimeException("Invalid credentials");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    // Get all users (optional)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update user status
    public void updateUserStatus(Long userId, String status) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserStatus(status);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    // Get user by ID (optional)
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}

