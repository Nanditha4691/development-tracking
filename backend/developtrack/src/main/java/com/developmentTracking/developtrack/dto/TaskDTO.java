package com.developmentTracking.developtrack.dto;

import java.time.LocalDateTime;

public class TaskDTO {

    private Long id;
    private String moduleName;
    private String subModule;
    private String assignTo;
    private String priority;
    private String description;
    private String actualResult;
    private String expectedResult;
    private String dateOfUat;
    private String targetDate;
    private String anySpecificIssues;
    private String suggestionForImprovement;
    private String status;
    private String progressUpdate;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

    // Constructor

    public TaskDTO(Long id, String moduleName, String subModule, String assignTo, String priority, String description, String actualResult, String expectedResult, String dateOfUat, String targetDate, String anySpecificIssues, String suggestionForImprovement, String status,String progressUpdate,LocalDateTime createdAt, LocalDateTime lastUpdated) {
        this.id = id;
        this.moduleName = moduleName;
        this.subModule = subModule;
        this.assignTo = assignTo;
        this.priority = priority;
        this.description = description;
        this.actualResult = actualResult;
        this.expectedResult = expectedResult;
        this.dateOfUat = dateOfUat;
        this.targetDate = targetDate;
        this.anySpecificIssues = anySpecificIssues;
        this.suggestionForImprovement = suggestionForImprovement;
        this.status = status;

        this.progressUpdate = progressUpdate;
        this.createdAt = createdAt;
        this.lastUpdated = lastUpdated;
    }


    // Getters and Setters




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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
