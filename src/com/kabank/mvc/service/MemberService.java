package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {
	public Boolean login(MemberBean m);
	public void join(MemberBean m);
}
