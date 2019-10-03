package it.edo.test.transactions.services;

import java.util.List;

import org.springframework.data.geo.Point;

import it.edo.test.transactions.domain.Shop;

public interface ShopService {

	List<Shop> getAllShops();

	List<Shop> getShopsInCircle(Point center, Double radius);
	
	List<Shop> getShopsInBox(Point upLeft, Point downRight);

}
