package com.kabank.mvc.dao;

import java.util.List;

import com.kabank.mvc.domain.MemberBean;

public interface MemberDAO {
	public List<MemberBean> selectMembers();
	public void createMember();
	public void insertMember(MemberBean m);
	public MemberBean selectMemberById(MemberBean m);
	public MemberBean login();
	public void update();
}
