package it.edo.test.transactions.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.edo.test.transactions.domain.User;
import it.edo.test.transactions.repositories.UserRepository;
import it.edo.test.transactions.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private List<User> loadUserListByUsername(String username) {
		User u = new User();
		u.setUsername(username);
		Example<User> example = Example.of(u);
		return repository.findAll(example);
	}

	@Override
	public User loadUserByUsername(String username) {
		User user = loadUserListByUsername(username).get(0);
		return user;
	}

	@Override
	public void storeUser(User u) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		repository.save(u);
	}
	
	
}
