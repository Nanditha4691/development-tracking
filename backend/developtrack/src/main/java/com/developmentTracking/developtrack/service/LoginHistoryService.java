package com.developmentTracking.developtrack.service;

import com.developmentTracking.developtrack.model.LoginHistory;
import com.developmentTracking.developtrack.repository.LoginHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginHistoryService {

    @Autowired
    private LoginHistoryRepository repository;

    public List<LoginHistory> getAllLoginHistory() {
        return repository.findAll();
    }

    public LoginHistory saveLoginHistory(LoginHistory history) {
        return repository.save(history);
    }

    public void updateLogoutTime(Long id) {
        LoginHistory record = repository.findById(id).orElse(null);
        if (record != null) {
            record.setLogoutTime(java.time.LocalDateTime.now());
            repository.save(record);
        }
    }
}
