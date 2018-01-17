package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.BankDAOImpl;
import com.kabank.mvc.service.BankService;

public class BankServiceImpl implements BankService{
	public static BankService getInstance() { return new BankServiceImpl(); }
	private BankServiceImpl() { }
	@Override
	public void createAccount() { 
		BankDAOImpl.getInstance().createAccount();
	}
}
