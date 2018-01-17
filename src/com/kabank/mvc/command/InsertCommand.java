package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.factory.CreateFactory;
import com.kabank.mvc.factory.SqlReplaceFactory;
import com.kabank.mvc.util.ParamsIterator;

public class InsertCommand implements IOrder{
	Map<?,?> map;
	String servletPath;
	public InsertCommand(HttpServletRequest request) {
		map = ParamsIterator.excute(request);
		servletPath = request.getServletPath();
	}
	@Override
	public void excute() {
		switch(servletPath.substring(1, servletPath.indexOf("."))) {
			case "user":
				String id = String.valueOf(map.get("id"));
				String pw = String.valueOf(map.get("pw"));
				String pwch = String.valueOf(map.get("pwch"));
				String name = String.valueOf(map.get("name"));
				String ssn = String.valueOf(map.get("ssn_head")) + "-" + String.valueOf(map.get("ssn_tail"));
				String phone = String.valueOf(map.get("phone_head")) + "-" + String.valueOf(map.get("phone_mid")) + "-" + String.valueOf(map.get("phone_tail"));
				String email = String.valueOf(map.get("email")) + String.valueOf(map.get("email_dot"));
				String profile = String.valueOf(map.get("profile"));
				String addr = String.valueOf(map.get("addr")) + " " + String.valueOf(map.get("addr_detail"));
				InitCommand.cmd.setColumn("id/pw/name/ssn/phone/email/profile/addr/pwch");
				InitCommand.cmd.setData(id+"/"+pw+"/"+name+"/"+ssn+"/"+phone+"/"+email+"/"+profile+"/"+addr+"#"+pwch);
				InitCommand.cmd.setSql(SqlReplaceFactory.join());
			break;
			case "kakao":
				InitCommand.cmd.setSql(String.format(DmlEnum.INSERT_BANK.toString(),
					CreateFactory.createCustomNum(), CreateFactory.createAccountNum(), "0", map.get("id")));
				System.out.println(InitCommand.cmd.getSql());
			break;
		}
	}
}
