package com.kabank.mvc.command;

import java.util.Map;
import java.util.Set;

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
		@SuppressWarnings("unchecked")
		Set<String> keys = (Set<String>) map.keySet();
		String data = "";
		String column = "";
		String indexNum = "";
		for(String s : keys) {
			if(!(map.get(s).equals(""))) {
				data += map.get(s) + "/";
				column += s + "/";
			}
		}
		data = data.substring(0, data.length()-1);
		column = column.substring(0, column.length()-1);
		String[] columns = InitCommand.cmd.getColumn().split("/");
		String[] datas = InitCommand.cmd.getData().split("/");
		
		
	}
}
