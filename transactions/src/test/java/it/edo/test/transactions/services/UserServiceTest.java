package it.edo.test.transactions.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.edo.test.transactions.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	public void findByUserNameTest() {
		User u = userService.loadUserByUsername("edo");
		logger.info(u.toString());
	}
	
	@Test
	public void storeUserTest() {
		User u = new User();
		u.setUsername("prova");
		u.setPassword("provona");
		userService.storeUser(u);
	}
}
