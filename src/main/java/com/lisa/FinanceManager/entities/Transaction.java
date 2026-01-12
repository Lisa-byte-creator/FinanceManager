package com.lisa.FinanceManager.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity // Marks this class as a JPA entity, representing a row in the "transactions" table.
@Table(name = "transactions") // Explicitly maps the entity to the "transactions" database table.
public class Transaction {

    @Id // Designates 'id' as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Uses database auto-increment for ID generation (e.g., AUTO_INCREMENT in MySQL).
    private Long id;

    @ManyToOne // Many-to-one relationship: many transactions can belong to one user.
    private User user;

    @Enumerated(EnumType.STRING) // Persists the enum value as its string name (e.g., "INCOME" or "EXPENSE") rather than an ordinal.
    private TransactionType type;

    @ManyToOne // Many-to-one relationship: many transactions can belong to one category.
    private Category category;

    private Double amount; // Monetary amount of the transaction.

    private String description; // Optional textual description of the transaction.

    private LocalDate transactionDate; // Date when the transaction occurred (without time).

    private LocalDateTime createdAt = LocalDateTime.now(); // Timestamp when the transaction record was created; defaults to current time.

    // Default no-argument constructor required by JPA.
    public Transaction() {}

    // Getter for the primary key.
    public Long getId() {
        return id;
    }

    // Getter for the associated user.
    public User getUser() {
        return user;
    }

    // Setter for the associated user.
    public void setUser(User user) {
        this.user = user;
    }

    // Getter for the transaction type (INCOME or EXPENSE).
    public TransactionType getType() {
        return type;
    }

    // Setter for the transaction type.
    public void setType(TransactionType type) {
        this.type = type;
    }

    // Getter for the associated category.
    public Category getCategory() {
        return category;
    }

    // Setter for the associated category.
    public void setCategory(Category category) {
        this.category = category;
    }

    // Getter for the transaction amount.
    public Double getAmount() {
        return amount;
    }

    // Setter for the transaction amount.
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    // Getter for the transaction description.
    public String getDescription() {
        return description;
    }

    // Setter for the transaction description.
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for the date the transaction took place.
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    // Setter for the transaction date.
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Getter for the creation timestamp.
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

// Enum defining the two possible types of financial transactions.
enum TransactionType {
    INCOME,  // Represents money coming in.
    EXPENSE  // Represents money going out.
}