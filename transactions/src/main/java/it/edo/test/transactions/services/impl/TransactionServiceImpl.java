package it.edo.test.transactions.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.repositories.TransactionsRepository;
import it.edo.test.transactions.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionsRepository repository;
	
	public List<Transaction> getAllTransactions(String owner) {
		Transaction t = new Transaction();
		t.setOwner(owner);
		Example<Transaction> example = Example.of(t);
		return repository.findAll(example);
	}
	
	
}
