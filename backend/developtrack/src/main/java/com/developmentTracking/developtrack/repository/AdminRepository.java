package com.developmentTracking.developtrack.repository;

import com.developmentTracking.developtrack.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);  // Fetch admin by username
}
