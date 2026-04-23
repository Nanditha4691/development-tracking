package com.developmentTracking.developtrack.controller;

import com.developmentTracking.developtrack.dto.TaskDTO;
import com.developmentTracking.developtrack.model.Task;
import com.developmentTracking.developtrack.model.User;
import com.developmentTracking.developtrack.repository.TaskRepository;
import com.developmentTracking.developtrack.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<TaskDTO> getAllTasks() {
        logger.info("Fetching all tasks");
        return taskRepository.findAll().stream()
                .map(task -> new TaskDTO(task.getId(), task.getModuleName(), task.getSubModule(),
                        task.getAssignTo(), task.getPriority(),task.getDescription(),
                        task.getActualResult(),task.getExpectedResult(),
                        task.getDateOfUat(),task.getTargetDate(),task.getAnySpecificIssues(),task.getSuggestionForImprovement(),
                        task.getStatus(), task.getProgressUpdate(),
                        task.getCreatedAt(), task.getLastUpdated()))
                .collect(Collectors.toList());
    }

    // ✅ Fetch tasks assigned to a specific user
    @GetMapping("/user/{username}")
    public List<Task> getUserTasks(@PathVariable String username) {
        return taskRepository.findByAssignTo(username);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setCreatedBy(true);
        Task savedTask = taskRepository.save(task);
        logger.info("Task created successfully: {}", savedTask);
        return ResponseEntity.ok(savedTask);
    }

    @PutMapping("/{id}/assign/{userId}")
    public ResponseEntity<String> assignTask(@PathVariable Long id, @PathVariable Long userId) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        Optional<User> userOptional = userRepository.findById(userId);

        if (taskOptional.isPresent() && userOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setAssignTo(userOptional.get().getUsername());
            taskRepository.save(task);
            logger.info("Task assigned to user: {}", userOptional.get().getUsername());
            return ResponseEntity.ok("Task assigned successfully");
        }
        logger.error("Task or User not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task or User not found");
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable Long id, @RequestBody String status) {
        return taskRepository.findById(id).map(task -> {
            task.setStatus(status.replace("\"",""));
            task.setLastUpdated(LocalDateTime.now());
            taskRepository.save(task);
            logger.info("Task status updated successfully");
            return ResponseEntity.ok("Task status updated successfully");
        }).orElseGet(() -> {
            logger.error("Task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        return taskRepository.findById(id).map(task -> {
            taskRepository.delete(task);
            logger.info("Task deleted successfully");
            return ResponseEntity.ok("Task deleted successfully");
        }).orElseGet(() -> {
            logger.error("Task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        });
    }

    @PutMapping("/markCompleted/{id}")
    public ResponseEntity<String> markTaskAsCompleted(@PathVariable Long id) {
        return taskRepository.findById(id).map(task -> {
            task.setStatus("Completed"); // Make sure this matches the exact string used in your logic
            task.setLastUpdated(LocalDateTime.now());
            taskRepository.save(task);
            logger.info("Task marked as completed");
            return ResponseEntity.ok("Task marked as completed");
        }).orElseGet(() -> {
            logger.error("Task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        });
    }
    @PutMapping("/tasks/{id}/complete")
    public ResponseEntity<?> markTaskCompleted(@PathVariable Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setStatus("Completed");
            taskRepository.save(task);
            return ResponseEntity.ok("Task marked as completed");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }
    }

    @GetMapping("/generate-pdf")
    public ResponseEntity<byte[]> generateDummyPdf() {
        byte[] pdfContent = "This is a dummy PDF content.".getBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "dummy.pdf");

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }



}
