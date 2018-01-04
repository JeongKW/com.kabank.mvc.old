package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.dao.CommonDAO;
import com.kabank.mvc.daoImpl.CommonDAOImpl;
import com.kabank.mvc.service.CommonService;

public class CommonServiceImpl implements CommonService{
	CommonDAO cmDAO;
	
	public CommonServiceImpl() {
		cmDAO = new CommonDAOImpl();
	}
	@Override
	public String countTable() {
		return cmDAO.selectTableCount();
	}
	
}
