package it.edo.test.transactions.services;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.edo.test.transactions.domain.Recharge;
import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.repositories.RechargeRepository;
import it.edo.test.transactions.repositories.TransactionsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {

	Logger logger = LoggerFactory.getLogger(TransactionServiceTest.class);
	
	@Autowired
	RechargeRepository rechargeRepo;
	
	@Autowired
	TransactionsRepository repository;
	
	@Autowired
	private TransactionService transactionService;
	
	@Test
	public void 
	basicTest() {
		assertNotNull(transactionService);
	}
	
	@Test
	public void getTransactions() {
		String owner = "prova";
		List<Transaction> transactions = transactionService.getAllTransactions(owner);
		for (Transaction transaction : transactions) {
			logger.info(transaction.get_id());
		}
		logger.info(transactions.toString());
	}
	
	@Test
	public void insertTransactions() {
		String owner1 = "prova";
		for (int i = 0; i < 6; i++) {
			Transaction t1 = new Transaction(new Date(), "trx " + i, owner1);
			repository.insert(t1);
		}
	}
	
	@Test
	public void getTransactionTest() {
		String code = "0";
		String owner = "edo";
		Transaction transaction = transactionService.getTransaction(code, owner);
		logger.info(transaction.toString());
	}
	
	@Test
	public void testInsertRecharge() {
		String owner1 = "prova";
		Recharge r1 = new Recharge();
		r1.setOwner(owner1);
		r1.setValidFrom(new Date());
		r1.setValidThru(new Date());
		r1.setLength(30);
		r1.setLeft(12);
		r1.setCode("000002");
		rechargeRepo.insert(r1);
	}
}
