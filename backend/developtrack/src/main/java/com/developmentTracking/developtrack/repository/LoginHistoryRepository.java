package com.developmentTracking.developtrack.repository;

import com.developmentTracking.developtrack.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
}
