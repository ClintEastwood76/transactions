package it.edo.test.transactions.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.services.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@RequestMapping("/transactions")
	public List<Transaction> getAllTransactions(HttpServletRequest request, @RequestParam String owner) {
		logger.info("Session id: " + request.getSession().getId());
		logger.info("Request id: " + request.toString());
		logger.info("Owner: " + owner);
		return transactionService.getAllTransactions(owner);
	}
	
}
