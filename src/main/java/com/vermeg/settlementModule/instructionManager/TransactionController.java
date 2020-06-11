package com.vermeg.settlementModule.instructionManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vermeg.settlementModule.model.Transaction;

public class TransactionController {
	@Autowired
	private TransactionRepository TransactionRepository;

	@GetMapping("/transactions")
	public List<com.vermeg.settlementModule.model.Transaction> getAllTransactions() {
		return TransactionRepository.findAll();
	}

	@GetMapping("/transactions/{id}")
	public ResponseEntity<com.vermeg.settlementModule.model.Transaction> getTransactionById(
			@PathVariable(value = "id") Long transactionId) throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.Transaction transaction = TransactionRepository.findById(transactionId)
				.orElseThrow(
						() -> new RessourceNotFoundException("transaction not found for this id :: " + transactionId));
		return ResponseEntity.ok().body(transaction);
	}

	@PostMapping("/transaction")
	public Transaction createTransaction(@Valid @RequestBody Transaction transaction) {
		return TransactionRepository.save(transaction);
	}

	@PutMapping("/assets/{id}")
	public ResponseEntity<Transaction> updateTransaction(@PathVariable(value = "id") Long transactionId,
			@Valid @RequestBody com.vermeg.settlementModule.model.Transaction TransactionDetails)
			throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.Transaction transaction = TransactionRepository.findById(transactionId)
				.orElseThrow(
						() -> new RessourceNotFoundException("transaction not found for this id :: " + transactionId));

		transaction.setIdtransaction(TransactionDetails.getIdtransaction());
		transaction.setContracttype(TransactionDetails.getContracttype());
		transaction.setTransactiontype(TransactionDetails.getTransactiontype());
		transaction.setSettelmentnature( TransactionDetails.getSettelmentnature());
		
		

		final com.vermeg.settlementModule.model.Transaction updatedTransaction = TransactionRepository
				.save(transaction);
		return ResponseEntity.ok(updatedTransaction);
	}

	@DeleteMapping("/transactions/{Id}")
	public Map<String, Boolean> deleteTransaction(@PathVariable(value = "Id") Long transactionId)
			throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.Transaction transaction = TransactionRepository.findById(transactionId)
				.orElseThrow(
						() -> new RessourceNotFoundException("transaction not found for this id :: " + transactionId));

		TransactionRepository.delete(transaction);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
