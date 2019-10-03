package it.edo.test.transactions.services;

import java.util.List;

import org.springframework.data.geo.Point;

import it.edo.test.transactions.domain.Shop;

public interface ShopService {

	List<Shop> getAllShops();

	List<Shop> getNearShops(Point center, Double radius);

}
