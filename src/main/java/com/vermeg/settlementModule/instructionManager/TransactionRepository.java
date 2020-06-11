package com.vermeg.settlementModule.instructionManager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.settlementModule.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
