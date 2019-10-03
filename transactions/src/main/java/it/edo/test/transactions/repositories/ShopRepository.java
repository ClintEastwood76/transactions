package it.edo.test.transactions.repositories;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.edo.test.transactions.domain.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {

	List<Shop> findByLocationNear(Point location, Distance distance);
}
