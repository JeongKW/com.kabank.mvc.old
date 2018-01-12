package com.kabank.mvc.serviceImpl;

import java.util.*;

import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance() { return new MemberServiceImpl(); }

	private MemberServiceImpl() { }
	@Override
	public MemberBean findMemberById(MemberBean m) {
		return MemberDAOImpl.getInstance().selectMemberById(m);
	}
	
	@Override
	public void join(MemberBean m) {
		List<MemberBean> list = MemberDAOImpl.getInstance().selectMembers();
		boolean exist = false;
		for(int i=0; i < list.size(); i++) {
			if(m.getId().equals(list.get(i).getId())) {
				exist = true;
				break;
			}
		}
		if(!exist) {
			MemberDAOImpl.getInstance().insertMember(m);
		}
	}

	@Override
	public MemberBean login() {
		return MemberDAOImpl.getInstance().login();
	}

	@Override
	public void update() {
		MemberDAOImpl.getInstance().update();
	}
	
	
	
}
