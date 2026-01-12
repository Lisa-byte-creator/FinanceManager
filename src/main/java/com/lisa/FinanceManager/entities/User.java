package com.lisa.FinanceManager.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity // Indicates this class is a JPA entity, mapped to a database table.
@Table(name = "users") // Specifies the corresponding database table name as "users".
public class User {

    @Id // Marks this field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Uses database auto-increment (e.g., AUTO_INCREMENT in MySQL) for ID generation.
    private Long id;

    private String name; // User's full name or display name.

    @Column(unique = true) // Ensures the email column has a unique constraint in the database to prevent duplicate emails.
    private String email;

    private String passwordHash; // Stores the hashed version of the user's password (never store plain-text passwords).

    private LocalDateTime createdAt = LocalDateTime.now(); // Timestamp when the user record was created; defaults to current time.

    // Default no-argument constructor required by JPA for entity instantiation.
    public User() {}

    // Convenience constructor to create a User with essential fields.
    public User(String name, String email, String passwordHash) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    // Getter for the user's ID (primary key).
    public Long getId() {
        return id;
    }

    // Getter for the user's name.
    public String getName() {
        return name;
    }

    // Setter for the user's name.
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the user's email.
    public String getEmail() {
        return email;
    }
    
    // Setter for the user's email.
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for the hashed password.
    public String getPasswordHash() {
        return passwordHash;
    }
    
    // Setter for the hashed password.
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // Getter for the creation timestamp.
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
