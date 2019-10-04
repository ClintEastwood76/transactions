package it.edo.test.transactions.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.edo.test.transactions.domain.Shop;
import it.edo.test.transactions.services.ShopService;

@RestController
public class ShopController extends AbstractJwtController {

	@Autowired
	private ShopService shopService;
	
	@RequestMapping("/shopbox")
	public List<Shop> getRechargePage(HttpServletRequest request,
			@RequestParam(value = "upLeft", required = true) Point upLeft,
			@RequestParam(value = "downright", required = true) Point downRight
            ) {
		logger.warn("from " + upLeft.toString() + " to " + downRight.toString());
		return shopService.getShopsInBox(upLeft, downRight);
	}
}
