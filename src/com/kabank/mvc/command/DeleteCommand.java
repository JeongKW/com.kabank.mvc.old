package com.kabank.mvc.command;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.factory.SqlReplaceFactory;
import com.kabank.mvc.util.ParamsIterator;

public class DeleteCommand implements IOrder{
	Map<?,?> map;
	public DeleteCommand(HttpServletRequest request) {
		map = ParamsIterator.excute(request);
	}
	@Override
	public void excute() {
		String id = String.valueOf(map.get("id"));
		String pw = String.valueOf(map.get("pw"));
		String pwch = String.valueOf(map.get("pwch"));
		InitCommand.cmd.setColumn("id/pw/pwch");
		InitCommand.cmd.setData(id + "/" + pw + "/" + pwch);
		InitCommand.cmd.setSql(SqlReplaceFactory.delete(DmlEnum.DELETE_MEMBER.toString(), id));
	}
}
