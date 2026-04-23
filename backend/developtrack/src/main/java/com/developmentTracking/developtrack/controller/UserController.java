package com.developmentTracking.developtrack.controller;

import com.developmentTracking.developtrack.model.User;
import com.developmentTracking.developtrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/saveUsers")
@CrossOrigin(origins = "http://localhost:3000")// Allow frontend requests
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ✅ Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Create a new user (Signup)
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use!");
        }
        user.setUserStatus("enable");
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // ✅ Login user
    //@GetMapping("/login")
    //public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
      //  Optional<User> user = userRepository.findByEmail(email);
        //if (user.isPresent() && user.get().getPassword().equals(password)) {
          //  return ResponseEntity.ok(user.get()); // Success: return user details
        //}
        //return ResponseEntity.status(401).body("Invalid email or password!"); // Unauthorized
    //}

    // ✅ Login user (Updated to check if user is enabled)
    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            User existingUser = user.get();
            if (!existingUser.getPassword().equals(password)) {
                return ResponseEntity.status(401).body("Invalid email or password!");
            }

            if (!"enabled".equalsIgnoreCase(existingUser.getUserStatus())) {
                return ResponseEntity.status(403).body("Your account has been disabled by the admin.");
            }

            return ResponseEntity.ok(existingUser); // Success: return user details
        }

        return ResponseEntity.status(401).body("Invalid email or password!");
    }


    // ✅ Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setRole(userDetails.getRole());
            return ResponseEntity.ok(userRepository.save(user));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Delete user
   // @DeleteMapping("/{id}")
   // public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
      //  return userRepository.findById(id).map(user -> {
         //   userRepository.delete(user);
           // return ResponseEntity.noContent().build();
       // }).orElseGet(() -> ResponseEntity.notFound().build());
   // }


    @PutMapping("/admin/updateStatus/{userId}")
    public ResponseEntity<String> updateUserStatus(
            @PathVariable Long userId,
            @RequestParam String status) {

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserStatus(status);
            userRepository.save(user);
            return ResponseEntity.ok("User status updated to " + status);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    @PutMapping("/toggleStatus/{userId}")
    public ResponseEntity<String> toggleUserStatus(@PathVariable Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String currentStatus = user.getUserStatus();
            String newStatus = currentStatus.equalsIgnoreCase("enabled") ? "disabled" : "enabled";
            user.setUserStatus(newStatus);
            userRepository.save(user);
            return ResponseEntity.ok("User status updated to " + newStatus);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}