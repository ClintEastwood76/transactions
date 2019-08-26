package it.edo.test.transactions;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import it.edo.test.transactions.controllers.TransactionController;
import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.repositories.TransactionsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionsApplicationTests {

	Logger logger = LoggerFactory.getLogger(TransactionsApplicationTests.class);
	
	@Autowired
	TransactionsRepository repository;
	
	@Test
	public void contextLoads() {
		assertNotNull("repository nullo", repository);
	}

	@Test
	public void testFindAll() {
		for (Transaction t : repository.findAll()) {
			logger.info(t.toString());
		}

	}
	
	@Test
	public void testDelete() {
		repository.deleteAll();
	}
	
	@Test
	public void testInsert() {
		String owner1 = "edo";
		String owner2 = "ardo";
		Transaction t3 = new Transaction(new Date(), "trx3", owner2);
		repository.insert(t3);
		for (int i = 0; i < 40; i++) {
			Transaction t1 = new Transaction(new Date(), "trx " + i, owner1);
			repository.insert(t1);
		}
		
	}
	
	@Test
	public void findByOwner() {
		Transaction t = new Transaction();
		t.setOwner("edo");
		Example<Transaction> example = Example.of(t);
		for (Transaction t2 : repository.findAll(example)) {
			logger.info(t2.toString());
		};
		
	}
}
