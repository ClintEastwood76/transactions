package it.edo.test.transactions.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.services.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@RequestMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
	
	@PostMapping("createTransaction")
	public Transaction createTransaction(@Valid @RequestBody String desc) {
		return transactionService.insert(desc);
	}
}
