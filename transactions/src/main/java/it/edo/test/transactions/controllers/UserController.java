package it.edo.test.transactions.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.edo.test.transactions.domain.User;
import it.edo.test.transactions.services.UserService;

@RestController
public class UserController extends AbstractJwtController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/user")
	public User getUserInfo(HttpServletRequest request) {
		String userName = getUsernameFromToken(request);
		return userService.loadUserByUsername(userName);
	}
}
