package it.edo.test.transactions.services;

import java.util.List;

import it.edo.test.transactions.domain.User;

public interface UserService {

	User loadUserByUsername(String username);

	void storeUser(User u);

}
