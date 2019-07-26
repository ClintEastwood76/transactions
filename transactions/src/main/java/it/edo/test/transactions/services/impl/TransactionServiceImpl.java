package it.edo.test.transactions.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.repositories.TransactionsRepository;
import it.edo.test.transactions.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionsRepository repository;
	
	public List<Transaction> getAllTransactions() {
		/*
		List<Transaction> trxs = new ArrayList<>();
		Transaction t = new Transaction(new Date(), "Trx 1");
		t.set_id(new ObjectId("666f6f2d6261722d71757578"));
		trxs.add(t);
		return trxs;
		*/
		return repository.findAll();
	}
	
	public Transaction insert(String desc) {
		Transaction t = new Transaction(new Date(), desc);
		// t.set_id(ObjectId.);
		return repository.insert(t);
		
	}
}
