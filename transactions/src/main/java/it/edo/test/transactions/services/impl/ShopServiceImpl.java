package it.edo.test.transactions.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import it.edo.test.transactions.domain.Shop;
import it.edo.test.transactions.repositories.ShopRepository;
import it.edo.test.transactions.services.ShopService;

@Service
public class ShopServiceImpl extends BasicService implements ShopService {
	
	@Autowired
	ShopRepository repository;
	
	@Override
	public List<Shop> getAllShops() {
		Shop shop = new Shop();
		Example<Shop> example = Example.of(shop);
		return repository.findAll(example);
	}

	@Override
	public List<Shop> getNearShops(Point center, Double radius) {
		try {
		List<Shop> shops = repository.findByLocationNear(center, new Distance(radius));
		return shops;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
