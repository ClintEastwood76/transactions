package it.edo.test.transactions.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import it.edo.test.transactions.domain.Transaction;


public interface TransactionService {

	public List<Transaction> getAllTransactions();
}
