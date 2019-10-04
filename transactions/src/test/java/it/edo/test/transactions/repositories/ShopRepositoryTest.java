package it.edo.test.transactions.repositories;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringRunner;

import it.edo.test.transactions.domain.Shop;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopRepositoryTest {

	Logger logger = LoggerFactory.getLogger(ShopRepositoryTest.class);
	
	@Autowired
	ShopRepository repository;
	
	@Test
	public void contextLoads() {
		assertNotNull("repository nullo", repository);
	}
	
	@Test
	public void geoTest1() {
		List<Shop> list = repository.findByLocationWithin(
				new Circle(
						new Point(42.07376224, 12.81280518), 10d
						));
		logger.info("size: " + list.size());;
		logger.info(list.toString());
	}
	
	@Test
	public void geoTest2() {
		List<Shop> list = repository.findByLocationWithin(
				new Box(
						new Point(41.07376224, 11.81280518), 
						new Point(43.07376224, 13.81280518)
						));
		logger.info("size: " + list.size());;
		logger.info(list.toString());
	}
	
	@Test
	public void ranzaShop() {
		repository.deleteAll();
	}
}
