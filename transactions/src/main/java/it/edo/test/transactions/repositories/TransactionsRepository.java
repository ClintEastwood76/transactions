package it.edo.test.transactions.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.edo.test.transactions.domain.Transaction;

import org.bson.types.ObjectId;

@Repository
public interface TransactionsRepository extends MongoRepository<Transaction, String> {

	Transaction findBy_id(ObjectId _id);

}
