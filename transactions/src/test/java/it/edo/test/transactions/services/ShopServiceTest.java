package it.edo.test.transactions.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringRunner;

import it.edo.test.transactions.domain.Shop;
import it.edo.test.transactions.repositories.ShopRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest {

	Logger logger = LoggerFactory.getLogger(ShopServiceTest.class);
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	ShopRepository repository;
	
	@Test
	public void basicTest() {
		assertNotNull(repository);
		assertNotNull(shopService);
	}
	
	@Test
	public void createSomeShop() {
		Shop shop1 = new Shop();
		shop1.setCode("000000000001");
		shop1.setName("Luppolo e Farina");
		shop1.setAddress("65/71, Viale delle Accademie, Municipio Roma VIII, Roma, RM, Lazio, 00147, Italia");
		shop1.setCity("Roma");
		shop1.setLocation(new Point(new Double(42.07376224), new Double(12.81280518)));
		repository.insert(shop1);
	}
	
	@Test
	public void getShops() {
		List<Shop> list = shopService.getAllShops();
		logger.info(list.toString());
	}
	
	@Test
	public void getShopNearMe() {
		Point center = new Point(new Double(42.07376224), new Double(12.81280518));
		Double radius = 0.1;
		List<Shop> shopList = shopService.getNearShops(center, radius);
		assertSame("Sono diversi", 1, shopList.size());
	}
	
}
