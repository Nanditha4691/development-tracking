package com.developmentTracking.developtrack.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="track")
public class Develop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String moduleName;
    private String subModule;
    private String description;
    private String actualResult;
    private String expectedResult;
    private String DateOfUat;
    private String targetDate;
    private String assignTo;
    private String priority;

    @Column(columnDefinition = "TEXT")
    private String anySpecificIssues;

    @Column(columnDefinition = "TEXT")
    private String suggestionforImprovement;

    private String createdBy;
    private LocalDateTime createdAt;

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
        return DateOfUat;
    }

    public void setDateOfUat(String dateOfUat) {
        this.DateOfUat = dateOfUat;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
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

    public String getAnySpecificIssues() {
        return anySpecificIssues;
    }

    public void setAnySpecificIssues(String anySpecificIssues) {
        this.anySpecificIssues = anySpecificIssues;
    }

    public String getSuggestionforImprovement() {
        return suggestionforImprovement;
    }

    public void setSuggestionforImprovement(String suggestionforImprovement) {
        this.suggestionforImprovement = suggestionforImprovement;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(String completed) {
    }
}

