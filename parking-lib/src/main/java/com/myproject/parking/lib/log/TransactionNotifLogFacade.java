package com.myproject.parking.lib.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.parking.lib.entity.TransactionNotifVO;
import com.myproject.parking.lib.mapper.TransactionNotifMapper;

public class TransactionNotifLogFacade {
	private static final Logger LOG = LoggerFactory.getLogger(TransactionNotifLogFacade.class);

	@Autowired
	private TransactionNotifMapper transactionNotifMapper;
	
	@Autowired
	private MessageSource messageSource;
	
	@Transactional(rollbackFor=Exception.class)
	public void createLog(TransactionNotifVO task) throws Exception {
		LOG.info("[#{}] createLog: {}", task.getOrderId(), task);
		transactionNotifMapper.createTransactionNotif(task);
	}
	
}
