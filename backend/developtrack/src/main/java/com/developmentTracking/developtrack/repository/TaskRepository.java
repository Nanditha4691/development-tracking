package com.developmentTracking.developtrack.repository;

import com.developmentTracking.developtrack.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignTo(String assignTo);
}
