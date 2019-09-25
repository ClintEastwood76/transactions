package it.edo.test.transactions.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.edo.test.transactions.domain.Recharge;
import it.edo.test.transactions.repositories.RechargeRepository;
import it.edo.test.transactions.services.RechargeService;

@Service
public class RechargeServiceImpl extends BasicService implements RechargeService {

	
	@Autowired
	RechargeRepository repository;
	
	@Override
	public List<Recharge> getAllRecharges(String owner) {
		Recharge r = new Recharge();
		r.setOwner(owner);
		Example<Recharge> example = Example.of(r);
		return repository.findAll(example);
	}

	@Override
	public Recharge getRecharge(String code, String owner) {
		Recharge t = new Recharge();
		t.setOwner(owner);
		// t.set_id(new ObjectId(id));
		t.setCode(code);
		Example<Recharge> example = Example.of(t);
		return repository.findAll(example).get(0);
	}

	@Override
	public Page<Recharge> getRechargePage(String owner, Integer pageNum, Integer pageSize) {
		Recharge t = new Recharge();
		t.setOwner(owner);
		Example<Recharge> example = Example.of(t);
		Pageable pageable = PageRequest.of(
				getPageNum(pageNum), 
				getPageSize(pageSize));
		return repository.findAll(example, pageable);
		
	}

	
	

}
