package it.edo.test.transactions.services;

import java.util.List;

import org.springframework.data.domain.Page;

import it.edo.test.transactions.domain.Recharge;
import it.edo.test.transactions.domain.Transaction;


public interface TransactionService {

	public List<Transaction> getAllTransactions(String owner);

	public Transaction getTransaction(String id, String owner);
	
	Page<Transaction> getTransactionPage(String owner, Integer pageNum, Integer pageSize);

}
