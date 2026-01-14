package com.example.MeowDate.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "roles")
    private String roles;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id")
    private UserProfile userProfile;

    public User() {}

    public User(String email, String password, UserProfile userProfile) {
        this.email = email;
        this.password = password;
        this.userProfile = userProfile;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserProfile getUserProfileId() {
        return userProfile;
    }

    public Long getId() {
        return id;
    }

    public String getRoles() {
        return roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserProfileId(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
