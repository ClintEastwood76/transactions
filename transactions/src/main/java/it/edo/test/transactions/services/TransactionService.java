package it.edo.test.transactions.services;

import java.util.List;

import it.edo.test.transactions.domain.Transaction;


public interface TransactionService {

	public List<Transaction> getAllTransactions(String owner);

	public Transaction getTransaction(String id, String owner);

}
