package com.developmentTracking.developtrack.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;


@Entity
@Table(name="users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Username is required")
    @Column(unique = true)
    private String username;


    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;


    @NotBlank(message = "Role is required")
    private String role;

    @Column(name = "userStatus")
    private String userStatus="enable"; // expected values: "enable" or "disable"//default value



    // Constructors
    public User() {}

    public User(String username, String password, String role,String email,String userStatus) {
        this.username = username;
        this.email=email;
        this.password = password;
        this.role = role;
        this.userStatus=userStatus;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }


}
