package com.developmentTracking.developtrack.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener.class)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String moduleName;
    private String subModule;

    @Column(name = "assigned_to")
    private String assignTo;

    private String description;
    private String actualResult;
    private String expectedResult;

    @Column(name = "date_of_uat")
    private String dateOfUat;

    @Column(name = "target_date")
    private String targetDate;

    private String priority;

    @Column(columnDefinition = "TEXT")
    private String anySpecificIssues;

    @Column(columnDefinition = "TEXT")
    private String suggestionForImprovement;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'Pending'")
    private String status = "Pending"; // Pending / Completed


    private String progressUpdate;

    @LastModifiedDate
    private LocalDateTime lastUpdated;

    private boolean createdBy; // Boolean field to track if task is created

    @CreatedDate
    private LocalDateTime createdAt; // Stores timestamp of task creation

    public Task(Long id, String moduleName, String subModule, String assignTo, String priority, String actualResult, String expectedResult, String dateOfUat, String targetDate, String anySpecificIssues, String suggestionForImprovement, String status, String progressUpdate, LocalDateTime createdAt, LocalDateTime lastUpdated) {
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = "Pending";
    }

    public Task() {}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSubModule() {
        return subModule;
    }

    public void setSubModule(String subModule) {
        this.subModule = subModule;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProgressUpdate() {
        return progressUpdate;
    }

    public void setProgressUpdate(String progressUpdate) {
        this.progressUpdate = progressUpdate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(boolean createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getDateOfUat() {
        return dateOfUat;
    }

    public void setDateOfUat(String dateOfUat) {
        this.dateOfUat = dateOfUat;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAnySpecificIssues() {
        return anySpecificIssues;
    }

    public void setAnySpecificIssues(String anySpecificIssues) {
        this.anySpecificIssues = anySpecificIssues;
    }

    public String getSuggestionForImprovement() {
        return suggestionForImprovement;
    }

    public void setSuggestionForImprovement(String suggestionForImprovement) {
        this.suggestionForImprovement = suggestionForImprovement;
    }



    public Task(String expectedResult, Long id, String moduleName, String subModule, String assignTo, String description, String actualResult, String dateOfUat, String targetDate, String priority, String anySpecificIssues, String suggestionForImprovement, String status, String progressUpdate, LocalDateTime lastUpdated, boolean createdBy, LocalDateTime createdAt) {
        this.expectedResult = expectedResult;
        this.id = id;
        this.moduleName = moduleName;
        this.subModule = subModule;
        this.assignTo = assignTo;
        this.description = description;
        this.actualResult = actualResult;
        this.dateOfUat = dateOfUat;
        this.targetDate = targetDate;
        this.priority = priority;
        this.anySpecificIssues = anySpecificIssues;
        this.suggestionForImprovement = suggestionForImprovement;
        this.status = status;
        this.progressUpdate = progressUpdate;
        this.lastUpdated = lastUpdated;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }
}

