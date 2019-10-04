package it.edo.test.transactions.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.edo.test.transactions.domain.Recharge;
import it.edo.test.transactions.services.RechargeService;

@RestController
public class RechargeController extends AbstractJwtController {

	@Autowired
	RechargeService rechargeService;
	
	// @RequestMapping("/recharges")
	@Deprecated
	public List<Recharge> getAllRecharges(HttpServletRequest request) {
		String owner = getUsernameFromToken(request);
		List<Recharge> list = rechargeService.getAllRecharges(owner);
		return list;
	}

	@RequestMapping("/recharges")
	public Page<Recharge> getRechargePage(HttpServletRequest request,
			@RequestParam(value = "pagenum", required = false) Integer pageNum,
			@RequestParam(value = "pagesize", required = false) Integer pageSize
            ) {
		String owner = getUsernameFromToken(request);
		Page<Recharge> list = rechargeService.getRechargePage(owner, pageNum, pageSize);
		return list;
	}
	

	@RequestMapping(value = "/recharge/{code}" , method=RequestMethod.GET)
	public Recharge getRecharge(HttpServletRequest request, @PathVariable("code") String code) {
		String owner = getUsernameFromToken(request);
		return rechargeService.getRecharge(code, owner);
	}
}
