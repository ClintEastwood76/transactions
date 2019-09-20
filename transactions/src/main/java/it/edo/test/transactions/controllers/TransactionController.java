package it.edo.test.transactions.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.services.TransactionService;

@RestController
public class TransactionController extends AbstractJwtController {

	@Autowired
	TransactionService transactionService;
	
	Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@RequestMapping("/transactions")
	public List<Transaction> getAllTransactions(HttpServletRequest request) {
		String owner = getUsernameFromToken(request);
		return transactionService.getAllTransactions(owner);
	}
	
	@RequestMapping(value = "/transaction/{id}" , method=RequestMethod.GET)
	public Transaction getTransaction(HttpServletRequest request, @PathVariable("id") String id) {
		logger.debug("");
		String owner = getUsernameFromToken(request);
		return transactionService.getTransaction(id, owner);
	}
	
}
