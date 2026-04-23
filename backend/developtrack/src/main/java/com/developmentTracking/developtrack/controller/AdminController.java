package com.developmentTracking.developtrack.controller;

import com.developmentTracking.developtrack.model.Admin;
import com.developmentTracking.developtrack.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saveAdmin")
 @CrossOrigin(origins = "http://localhost:3000")// Allow frontend requests
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<String> loginAdmin(@RequestBody Admin admin) {
        boolean isValid = adminService.validateAdmin(admin.getUsername(), admin.getPassword());
        if (isValid) {
            return ResponseEntity.ok("Login Successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials!");
        }
    }
}

