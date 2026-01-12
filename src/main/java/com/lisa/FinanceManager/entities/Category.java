package com.lisa.FinanceManager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity // Indicates that this class is a JPA entity, mapped to a database table.
@Table(name = "categories") // Specifies the database table name; ensures it's named "categories".
public class Category {

    @Id // Marks this field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Uses auto-incremented database identity for ID generation (e.g., AUTO_INCREMENT in MySQL).
    private Long id;

    @NotBlank(message = "Category name is required") // Validation constraint: ensures the name is not null, empty, or whitespace-only; used during bean validation.
    @Column(unique = true) // Maps this field to a database column with a unique constraint to prevent duplicate category names.
    private String name;

    // Default no-argument constructor required by JPA for entity instantiation.
    public Category() {}

    // Convenience constructor to create a Category with a name.
    public Category(String name) {
        this.name = name;
    }

    // Getter for the id field.
    public Long getId() {
        return id;
    }

    // Setter for the id field (typically used by JPA; usually not called manually).
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the name field.
    public String getName() {
        return name;
    }

    // Setter for the name field.
    public void setName(String name) {
        this.name = name;
    }
}
