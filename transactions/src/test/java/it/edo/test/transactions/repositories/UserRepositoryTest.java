package it.edo.test.transactions.repositories;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.edo.test.transactions.TransactionsApplicationTests;
import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);
	
	@Autowired
	UserRepository repository;
	
	@Test
	public void contextLoads() {
		assertNotNull("repository nullo", repository);
	}
	
	@Test
	public void testInsert() {
		User user = new User();
		user.setUsername("javainuse");
		user.setPassword("$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6");
		repository.insert(user);
	}
	
	@Test
	public void testFindAll() {
		for (User u : repository.findAll()) {
			logger.info(u.toString());
		}

	}
	
	@Test
	public void ranzaTest() {
		repository.deleteAll();
	}
	
}
