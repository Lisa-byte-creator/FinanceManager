package com.lisa.FinanceManager.services;

import com.lisa.FinanceManager.entities.Category;
import com.lisa.FinanceManager.repositories.CategoryRepository;
import org.springframework.stereotype.Service;


@Service // Marks this class as a Spring service component, typically containing business logic.
public class CategoryService {

    private final CategoryRepository categoryRepository; // Repository dependency for database operations on Category entities.

    // Constructor-based dependency injection for CategoryRepository.
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Creates a new category after checking for duplicates by name.
    public Category createCategory(Category category) {

        // Checks if a category with the same name already exists in the database.
        if (categoryRepository.existsByName(category.getName())) {
            // Throws an IllegalArgumentException if a duplicate name is found—this will be caught by the global or controller-level exception handler.
            throw new IllegalArgumentException(
                    "Category already exists: " + category.getName()
            );
        }

        // Saves and returns the new category if no duplicate is found.
        return categoryRepository.save(category);
    }
}
