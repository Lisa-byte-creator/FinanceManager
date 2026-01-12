package com.lisa.FinanceManager.controllers;

import com.lisa.FinanceManager.entities.User;
import com.lisa.FinanceManager.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Marks this class as a REST controller, automatically serializing return values as JSON (or other formats) in HTTP responses.
@RequestMapping("/api/users") // Sets the base path for all endpoints in this controller to "/api/users".
public class UserController {

    private final UserRepository userRepository; // Repository dependency for database operations related to User entities.

    // Constructor injection of UserRepository—ensures the dependency is provided at startup and supports immutability.
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Handles HTTP GET requests to "/api/users" to retrieve all users.
    @GetMapping
    public List<User> getAllUsers() {
        // Delegates to the repository to fetch all User records from the database.
        return userRepository.findAll();
    }

    // Handles HTTP POST requests to "/api/users" to create a new user.
    @PostMapping
    public User createUser(@RequestBody User user) { // Expects a JSON payload that maps to a User object.
        // Saves the incoming user to the database via the repository and returns the saved entity (typically with generated ID).
        return userRepository.save(user);
    }
}


