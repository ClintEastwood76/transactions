package it.edo.test.transactions.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.jsonwebtoken.ExpiredJwtException;
import it.edo.test.transactions.config.JwtTokenUtil;

public abstract class AbstractJwtController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	protected String getUsernameFromToken(HttpServletRequest request) {
		String requestTokenHeader = request.getHeader("Authorization");
		try {
			return jwtTokenUtil.getUsernameFromToken(requestTokenHeader);
		} catch (IllegalArgumentException e) {
			System.out.println("Unable to get JWT Token");
		} catch (ExpiredJwtException e) {
			System.out.println("JWT Token has expired");
		}
		return null;
	}
}
