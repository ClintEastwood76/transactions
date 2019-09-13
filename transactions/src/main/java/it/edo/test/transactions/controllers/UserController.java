package it.edo.test.transactions.controllers;

import it.edo.test.transactions.domain.User;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);	
	
	User mockUser;
	
	@RequestMapping("/users")
	public List<User> getAll() {
		mockUser = new User();
		mockUser.setFirstName("edo");
		List<User> list = new ArrayList<>();
		list.add(mockUser);
		return list;
	}
	
	@GetMapping("/users/{id}")
	@ResponseBody
	public User getById(@PathVariable Integer id) {
		mockUser = new User();
		mockUser.setId(id);
		mockUser.setFirstName("edo");
		return mockUser;
	}
	
}
