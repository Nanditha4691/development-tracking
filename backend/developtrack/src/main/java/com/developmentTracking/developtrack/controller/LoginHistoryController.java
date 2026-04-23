package com.developmentTracking.developtrack.controller;


import com.developmentTracking.developtrack.model.LoginHistory;
import com.developmentTracking.developtrack.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login-history")
@CrossOrigin(origins = "http://localhost:3000") // or your frontend domain
public class LoginHistoryController {
    @Autowired
    private LoginHistoryService service;

    @GetMapping
    public List<LoginHistory> getAllLoginHistory() {
        return service.getAllLoginHistory();
    }

    @PostMapping("/login")
    public LoginHistory logUserLogin(@RequestBody LoginHistory loginHistory) {
        loginHistory.setLoginTime(java.time.LocalDateTime.now());
        return service.saveLoginHistory(loginHistory);
    }

    @PutMapping("/logout/{id}")
    public void logUserLogout(@PathVariable Long id) {
        service.updateLogoutTime(id);
    }
}
