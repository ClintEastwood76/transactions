package it.edo.test.transactions.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.edo.test.transactions.domain.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {

	Shop findBy_id(ObjectId _id);
	
	List<Shop> findByLocationWithin(Box box);
	
	List<Shop> findByLocationWithin(Circle circle);
}
