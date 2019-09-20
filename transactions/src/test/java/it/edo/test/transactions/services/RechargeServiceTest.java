package it.edo.test.transactions.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.edo.test.transactions.domain.Recharge;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RechargeServiceTest {

	Logger logger = LoggerFactory.getLogger(RechargeServiceTest.class);
	
	@Autowired
	private RechargeService RechargeService;
	
	@Test
	public void basicTest() {
		assertNotNull(RechargeService);
	}
	
	@Test
	public void getRechargeTest() {
		String code = "000001";
		String owner = "edo";
		Recharge recharge = RechargeService.getRecharge(code, owner);
		logger.info(recharge.get_id().toString());
	}
	
	@Test
	public void getRechargesTest() {
		String owner = "edo";
		List<Recharge> recharge = RechargeService.getAllRecharges(owner);
		logger.info(recharge.get(0).get_id().toString());
		logger.info(recharge.get(0).getCode());
	}
	
}
