package com.developmentTracking.developtrack.service;

import com.developmentTracking.developtrack.model.Admin;
import com.developmentTracking.developtrack.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public boolean validateAdmin(String username, String rawPassword) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin == null) {
            return false; // ❌ Admin not found
        }
        return passwordEncoder.matches(rawPassword, admin.getPassword()); // ✅ Check hashed password
    }
}