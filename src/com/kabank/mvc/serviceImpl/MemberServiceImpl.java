package com.kabank.mvc.serviceImpl;

import java.util.*;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao;
	
	public MemberServiceImpl() {
		dao = new MemberDAOImpl();
	}
	@Override
	public Boolean login(MemberBean m) {
		List<MemberBean> list = dao.selectMembers();
		Boolean loginOk = false;
		for(int i = 0; i < list.size(); i++) {
			if(m.getId().equalsIgnoreCase(list.get(i).getId()) && m.getPw().equalsIgnoreCase(list.get(i).getPw())) {
					loginOk = true;
					break;
			}
		}
		return loginOk;
	}
	@Override
	public void join(MemberBean m) {
		List<MemberBean> list = dao.selectMembers();
		boolean exist = false;
		for(int i=0; i < list.size(); i++) {
			if(m.getId().equals(list.get(i).getId())) {
				exist = true;
				break;
			}
		}
		if(!exist) {
			dao.insertMember(m);
		}
	}
	
}
