package it.edo.test.transactions.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	public List<Transaction> getAllTransactions() {
		
		List<Transaction> trxs = new ArrayList<>();
		Transaction t = new Transaction(new Date(), "Trx 1");
		t.set_id(new ObjectId("666f6f2d6261722d71757578"));
		trxs.add(t);
		return trxs;
	}
}
