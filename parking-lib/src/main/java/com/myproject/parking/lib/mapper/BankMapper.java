package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.entity.Bank;

public interface BankMapper {

	public List<Bank> findAllBank();
	public Bank findBankById(int id);
	public void insertBank(Bank bank);
	public void updateBank(Bank bank);
	
	
}
