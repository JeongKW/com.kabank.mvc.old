package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.dao.AttendDAO;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.daoImpl.AttendDAOImpl;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService{
	MemberDAO memberDao = null;
	AttendDAO attendDao;
	public AdminServiceImpl() {
		attendDao = new AttendDAOImpl();
	}
	@Override
	public void createTable(String tname) {
		switch(tname) {
		case "member":
			memberDao.createMember();
			break;
		case "attend":
			attendDao.createAttend();
			break;
		}
	}
}
