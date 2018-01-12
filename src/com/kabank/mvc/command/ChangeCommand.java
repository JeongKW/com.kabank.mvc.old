package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.util.ParamsIterator;

public class ChangeCommand implements IOrder{
	Map<?,?> map;
	public ChangeCommand(HttpServletRequest request) {
		map = ParamsIterator.excute(request);
	}
	@Override
	public void excute() {
		String c_pw = String.valueOf(map.get("c_pw"));
		String m_pw = String.valueOf(map.get("m_pw"));
		String m_pwch = String.valueOf(map.get("m_pwch"));
		InitCommand.cmd.setColumn("c_pw/m_pw/m_pwch");
		InitCommand.cmd.setData(c_pw+"/"+m_pw+"/"+m_pwch);
	}
}
