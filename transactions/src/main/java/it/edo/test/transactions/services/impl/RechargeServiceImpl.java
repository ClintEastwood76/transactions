package it.edo.test.transactions.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import it.edo.test.transactions.domain.Recharge;
import it.edo.test.transactions.repositories.RechargeRepository;
import it.edo.test.transactions.services.RechargeService;

@Service
public class RechargeServiceImpl implements RechargeService {

	@Autowired
	RechargeRepository repository;
	
	@Override
	public List<Recharge> getAllRecharges(String owner) {
		Recharge r = new Recharge();
		r.setOwner(owner);
		Example<Recharge> example = Example.of(r);
		return repository.findAll(example);
	}
	

}