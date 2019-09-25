package it.edo.test.transactions.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: caricare le costanti dalla configurazione
public abstract class BasicService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected Integer defaultPageSize = 5;// Integer.parseInt(env.getProperty("pagesize.default"));
	protected Integer maxPageSize = 20;//Integer.parseInt(env.getProperty("pagesize.max"));
	protected Integer defaultPageNum = 0;//Integer.parseInt(env.getProperty("pagenum.default"));
	
	protected int getPageNum(Integer pageNum) {
		if (pageNum != null && pageNum >= 0) {
			return pageNum;
		} else {
			logger.warn("Invalid pageNum, getting default: " + defaultPageNum);
			return defaultPageNum;
		}
	}
	
	protected Integer getPageSize(Integer pageSize) {
		if (null == pageSize) {
			logger.warn("pageSize is null, using default: " + defaultPageSize);
			return defaultPageSize;
		} else {
			if (pageSize <= maxPageSize) {
				return pageSize;
			} else {
				logger.warn("pageSize is too big, using max: " + maxPageSize);
				return maxPageSize;
			}
		}
	}
	
}
