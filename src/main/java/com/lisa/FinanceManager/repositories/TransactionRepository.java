package com.lisa.FinanceManager.repositories;

import com.lisa.FinanceManager.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByCategoryId(Long categoryId);
}
