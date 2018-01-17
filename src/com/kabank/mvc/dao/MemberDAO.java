package com.kabank.mvc.dao;

import java.util.List;

import com.kabank.mvc.domain.MemberBean;

public interface MemberDAO {
	public List<MemberBean> selectMembers();
	public void createMember();
	public void insertMember();
	public MemberBean selectMemberById(MemberBean m);
	public MemberBean login();
	public void deleteMember();
	public void updateMember();
}
