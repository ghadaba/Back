package com.vermeg.settlementModule.instructionManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vermeg.settlementModule.model.Transaction;

public class TransactionService {
	@Autowired
	private TransactionRepository repo ;

	public List<Transaction> ListAll() {
		return repo.findAll();
	}
	 public void save(Transaction transaction) {
		 repo.save(transaction);
		 
		 
	 }
	 public Transaction get (Long id ) {
		 return repo.findById(id).get();
	 }
	 public void delete(long id) {
		 repo.deleteById(id);
	 }

}
