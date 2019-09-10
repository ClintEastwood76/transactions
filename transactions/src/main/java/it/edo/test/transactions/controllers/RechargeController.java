package it.edo.test.transactions.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.edo.test.transactions.domain.Recharge;
import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.services.RechargeService;

@RestController
public class RechargeController {

	@Autowired
	RechargeService rechargeService;
	
	Logger logger = LoggerFactory.getLogger(RechargeController.class);
	
	@RequestMapping("/recharges")
	public List<Recharge> getAllTransactions(@RequestParam String owner) {
		return rechargeService.getAllRecharges(owner);
	}
}
