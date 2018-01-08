package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {
	public void join(MemberBean m);
	public MemberBean findMemberById(MemberBean m);
}
