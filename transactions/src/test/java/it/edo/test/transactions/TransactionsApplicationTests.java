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
import it.edo.test.transactions.domain.Recharge;
import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.repositories.RechargeRepository;
import it.edo.test.transactions.repositories.TransactionsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionsApplicationTests {

	Logger logger = LoggerFactory.getLogger(TransactionsApplicationTests.class);
	
	@Autowired
	TransactionsRepository repository;
	
	@Autowired
	RechargeRepository rechargeRepo;
	
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
	public void findByOwner() {
		Transaction t = new Transaction();
		t.setOwner("ardo");
		Example<Transaction> example = Example.of(t);
		for (Transaction t2 : repository.findAll(example)) {
			logger.info(t2.toString());
		};
		
	}
	
	@Test
	public void testInsertRecharge() {
		String owner1 = "prova";
		// String owner2 = "ardo";
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
