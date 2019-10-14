package it.edo.test.transactions.services.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.edo.test.transactions.domain.Transaction;
import it.edo.test.transactions.repositories.ShopRepository;
import it.edo.test.transactions.repositories.TransactionsRepository;
import it.edo.test.transactions.services.TransactionService;

@Service
public class TransactionServiceImpl extends BasicService implements TransactionService {
	
	@Autowired
	TransactionsRepository repository;
	
	@Autowired
	ShopRepository shopRepository;
	
	public List<Transaction> getAllTransactions(String owner) {
		Transaction t = new Transaction();
		t.setOwner(owner);
		Example<Transaction> example = Example.of(t);
		return repository.findAll(example);
	}

	@Override
	public Transaction getTransaction(String id, String owner) {
		Transaction t = new Transaction();
		t.setOwner(owner);
		t.set_id(new ObjectId(id));
		Example<Transaction> example = Example.of(t);
		return repository.findAll(example).get(0);
		
	}

	@Override
	public Page<Transaction> getTransactionPage(String owner, Integer pageNum, Integer pageSize) {
		Transaction t = new Transaction();
		t.setOwner(owner);
		Example<Transaction> example = Example.of(t);
		Pageable pageable = PageRequest.of(
				getPageNum(pageNum), 
				getPageSize(pageSize),
				Sort.by("date").descending()
			);
		Page<Transaction> page = repository.findAll(example, pageable);
		for (int i = 0; i < page.getContent().size(); i++) {
			page.getContent().get(i).setShop(
				shopRepository.findBy_id(page.getContent().get(i).get_shopId())
			);
		}
		return page;
	}
	
	
}
