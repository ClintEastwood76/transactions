package it.edo.test.transactions.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public abstract class BasicService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${pagesize.default}")
	protected Integer defaultPageSize;
	
	@Value("${pagesize.max}")
	protected Integer maxPageSize;
	
	@Value("${pagenum.default}")
	protected Integer defaultPageNum;
	
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
