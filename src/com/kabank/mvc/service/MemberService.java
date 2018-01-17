package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {
	public void insertMember();
	public MemberBean findMemberById(MemberBean m);
	public MemberBean login();
	public void updateMember();
	public void deleteMember();
}
