package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.AttendDAOImpl;
import com.kabank.mvc.daoImpl.BankDAOImpl;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService{
	@Override
	public void createTable(String tname) {
		switch(tname) {
		case "member":
			MemberDAOImpl.getInstance().createMember();
			break;
		case "attend":
			AttendDAOImpl.getInstance().createAttend();
			break;
		case "bank":
			BankDAOImpl.getInstance().createBank();
			break;
		}
	}
}
