package com.kabank.mvc.serviceImpl;

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
	public void insertMember() {
		MemberDAOImpl.getInstance().insertMember();
	}

	@Override
	public MemberBean login() {
		return MemberDAOImpl.getInstance().login();
	}
	
	@Override
	public void deleteMember() {
		MemberDAOImpl.getInstance().deleteMember();
	}
	
	@Override
	public void updateMember() {
		MemberDAOImpl.getInstance().updateMember();
	}
	
	
	
}
