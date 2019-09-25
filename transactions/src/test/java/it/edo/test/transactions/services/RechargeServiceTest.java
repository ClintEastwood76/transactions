package it.edo.test.transactions.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import it.edo.test.transactions.domain.Recharge;
import it.edo.test.transactions.repositories.RechargeRepository;
import it.edo.test.transactions.repositories.TransactionsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RechargeServiceTest {

	Logger logger = LoggerFactory.getLogger(RechargeServiceTest.class);
	
	@Autowired
	private RechargeService rechargeService;
	
	@Autowired
	RechargeRepository repository;
	
	@Test
	public void basicTest() {
		assertNotNull(rechargeService);
	}
	
	@Test
	public void getRechargeTest() {
		String code = "000001";
		String owner = "edo";
		Recharge recharge = rechargeService.getRecharge(code, owner);
		logger.info(recharge.get_id().toString());
	
	}
	
	@Test
	public void getRechargesTest() {
		String owner = "edo";
		List<Recharge> recharge = rechargeService.getAllRecharges(owner);
		ObjectId o = recharge.get(0).get_id();
		
		logger.info(o.toHexString());
		logger.info(o.toString());
		logger.info(o.getDate().toString());
		
	}
	
	@Test
	public void getRechargePageTest() {
		Page<Recharge> page = rechargeService.getRechargePage("prova", 1, 5);
		logger.info(page.getContent().size() + "");
	}
	
	@Test
	public void insertSomeRechargesTest() throws ParseException {
		String owner = "prova";
		SimpleDateFormat sdf = new SimpleDateFormat("ddMyyyy");
		for (int i = 1; i <= 12; i++) {
			String dateToParse = "01" + (i<10 ? "0" + i: i) + "2019";
			Recharge recharge = new Recharge();
			recharge.setOwner(owner);
			recharge.setValidFrom(sdf.parse(dateToParse));
			recharge.setValidThru(sdf.parse(dateToParse));
			recharge.setCode("000000" + (i<10 ? "0" + i: i));
			recharge.setLength(30);
			recharge.setLeft(30 - i);
			repository.insert(recharge);
		}
		
	}
}
