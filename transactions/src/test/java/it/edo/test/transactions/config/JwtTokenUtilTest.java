package it.edo.test.transactions.config;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTokenUtilTest {

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	Logger logger = LoggerFactory.getLogger(JwtTokenUtilTest.class);
	
	@Test
	public void variousTests() {
		Assert.assertNotNull(jwtTokenUtil);
		User user = new User("edoardo", "myPassword", new ArrayList<>());
		String token = jwtTokenUtil.generateToken(user);
		logger.info(token);
		logger.info(jwtTokenUtil.getUsernameFromToken(token));
	}
	
}
