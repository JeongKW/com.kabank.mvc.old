package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.util.ParamsIterator;

public class LoginCommand implements IOrder{
	Map<?,?> map;
	public LoginCommand(HttpServletRequest request) {
		map = ParamsIterator.excute(request);
	}

	@Override
	public void excute() {
		String id = String.valueOf(map.get("id"));
		String pw = String.valueOf(map.get("pw"));
		InitCommand.cmd.setColumn("id/pw");
		InitCommand.cmd.setData(id+"/"+pw);
	}
}
