package it.edo.test.transactions.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.edo.test.transactions.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}
