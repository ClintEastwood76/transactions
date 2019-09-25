package it.edo.test.transactions.services;

import java.util.List;

import org.springframework.data.domain.Page;

import it.edo.test.transactions.domain.Recharge;

public interface RechargeService {

	List<Recharge> getAllRecharges(String owner);

	Recharge getRecharge(String code, String owner);

	Page<Recharge> getRechargePage(String owner, Integer pageNum, Integer pageSize);
}
