package it.edo.test.transactions.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.edo.test.transactions.domain.Recharge;

@Repository
public interface RechargeRepository extends MongoRepository<Recharge, String>{

}
