package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.factory.SqlReplaceFactory;
import com.kabank.mvc.util.ParamsIterator;

public class TestCommand implements IOrder{
	Map<?,?> map;
	MemberBean member;
	public TestCommand(HttpServletRequest request, HttpSession session) {
		map = ParamsIterator.excute(request);
		member = (MemberBean) session.getAttribute("user");
	}
	@Override
	public void excute() {
		String c_pw = String.valueOf(map.get("c_pw"));
		String m_pw = String.valueOf(map.get("m_pw"));
		String m_pwch = String.valueOf(map.get("m_pwch"));
		
		InitCommand.cmd.setColumn("c_pw/m_pw");
		InitCommand.cmd.setData(c_pw+"/"+m_pw+"/"+m_pwch+"/"+member.getId());
		InitCommand.cmd.setSql(SqlReplaceFactory.create(MemberEnum.UPDATE.toString(), InitCommand.cmd.getData().split("/")));
	}
}
