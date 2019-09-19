package it.edo.test.transactions.services;

import java.util.List;

import it.edo.test.transactions.domain.Recharge;

public interface RechargeService {

	List<Recharge> getAllRecharges(String owner);

	Recharge getRecharge(String code, String owner);
	
}
