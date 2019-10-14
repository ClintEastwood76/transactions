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
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import it.edo.test.transactions.domain.Recharge;
import it.edo.test.transactions.domain.Shop;
import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.repositories.RechargeRepository;
import it.edo.test.transactions.repositories.ShopRepository;
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
	ShopRepository shopRepo;
	
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
		List<Shop> shops = shopRepo.findAll();
		for (int i = 0; i < 11; i++) {
			Transaction transaction = new Transaction();
			transaction.setOwner(owner1);
			
			int numBuoni = new Double(Math.random() * 3 + 1).intValue();
			transaction.setNumTickets(numBuoni);
			float importo = new Double(Math.random() * 20 + 1).floatValue();
			transaction.setAmount(importo);
			transaction.set_shopId(
					shops.get(new Double(Math.random() * shops.size()).intValue()).get_id());
		
			transaction.setDate(new Date());
			transaction.setDesc("todo");
		
			repository.insert(transaction);
			// logger.info(transaction.toString());
		}
	}
	
	@Test
	public void getTransactionTest() {
		String code = "5d835cbf4208a8d9a41714d6";
		String owner = "prova";
		Transaction transaction = transactionService.getTransaction(code, owner);
		logger.info(transaction.toString());
		logger.info(transaction.get_id());
		
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
	
	@Test
	public void ranzaTransaction() {
		repository.deleteAll();
	}
	
	@Test
	public void getTransactionPage() {
		Page<Transaction> page = transactionService.getTransactionPage("prova", 1, 2);
		logger.info(page.getContent().toString());
	}
}
