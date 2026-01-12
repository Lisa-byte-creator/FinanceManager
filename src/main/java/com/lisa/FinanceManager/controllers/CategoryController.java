package com.lisa.FinanceManager.controllers;

import com.lisa.FinanceManager.entities.Category;
import com.lisa.FinanceManager.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController // Indicates that this class is a REST controller, handling HTTP requests and returning data directly (typically JSON/XML).
@RequestMapping("/api/categories") // Base URL path for all endpoints in this controller.
public class CategoryController {

    private final CategoryService categoryService; // Service dependency for handling category-related business logic.

    // Constructor-based dependency injection for CategoryService (preferred in Spring for immutability and testability).
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Handles HTTP POST requests to "/api/categories" to create a new category.
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category) { // Expects a JSON payload mapped to a Category object.
        try {
            // Delegates category creation to the service layer.
            Category saved = categoryService.createCategory(category);
            // Returns 200 OK with the saved category as the response body.
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException ex) {
            // If the service throws an IllegalArgumentException (e.g., invalid input), returns 400 Bad Request with the error message.
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

