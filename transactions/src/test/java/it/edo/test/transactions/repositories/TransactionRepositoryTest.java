package it.edo.test.transactions.repositories;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import it.edo.test.transactions.domain.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionRepositoryTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TransactionsRepository repository;
	
	@Test
	public void testGetAll() {
		List<Transaction> list = repository.findAll();
		logger.info(list.toString());
		String owner = list.get(0).getOwner();
		logger.info(owner);
		Transaction t = new Transaction();
		t.setOwner(owner);
		Example<Transaction> example = Example.of(t);
		List<Transaction> list2 = repository.findAll(example);
		logger.info("Numero " + list2.size());
	}
}
