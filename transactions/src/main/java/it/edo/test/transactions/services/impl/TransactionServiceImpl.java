package it.edo.test.transactions.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	public List<Transaction> getAllTransactions() {
		
		List<Transaction> trxs = new ArrayList<>();
		trxs.add(new Transaction(new Date(), "Trx 1"));
		trxs.add(new Transaction(new Date(), "Trx 2"));
		trxs.add(new Transaction(new Date(), "Trx 3"));
		trxs.add(new Transaction(new Date(), "Trx 4"));
		trxs.add(new Transaction(new Date(), "Trx 5"));

		return trxs;
	}
}
