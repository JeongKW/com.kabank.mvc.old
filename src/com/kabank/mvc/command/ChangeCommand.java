package com.kabank.mvc.command;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.factory.SqlReplaceFactory;
import com.kabank.mvc.util.ParamsIterator;

public class ChangeCommand implements IOrder{
	Map<?,?> map;
	public ChangeCommand(HttpServletRequest request) {
		map = ParamsIterator.excute(request);
	}
	@Override
	public void excute() {
		@SuppressWarnings("unchecked")
		Set<String> keys = (Set<String>) map.keySet();
		StringBuffer getDataParams = null;
		StringBuffer getColumnParams = null;
		String data = "";
		String column = "";
		for(String s : keys) {
			String ls = (String) map.get(s);
			if(!(s.equals("cmd") || s.equals("page") || ls.equals(""))) {
				if(s.equals("pw") || s.equals("pwch") || s.equals("id")) {
					if(getDataParams == null && getColumnParams == null) {
						getDataParams = new StringBuffer(map.get(s) + "/");
						getColumnParams = new StringBuffer(s + "/");
					} else {
						getDataParams.append(map.get(s) + "/");
						getColumnParams.append(s + "/");
					}
				} else {
					System.out.println("s : " + s);
					System.out.println("ls : " + ls);
					data += map.get(s) + "/";
					column += s + "/";
				}
			}
		}
		data = data.substring(0, data.length()-1);
		column = column.substring(0, column.length()-1);
		getDataParams.append(data);
		getColumnParams.append(column);
		System.out.println(data);
		System.out.println(column);
		System.out.println(getDataParams.toString());
		System.out.println(getColumnParams.toString());
		InitCommand.cmd.setColumn(getColumnParams.toString());
		InitCommand.cmd.setData(getDataParams.toString());
		InitCommand.cmd.setSql(SqlReplaceFactory.update(MemberEnum.UPDATE_TEST.toString(), InitCommand.cmd.getData().split("/"), InitCommand.cmd.getColumn().split("/")));
	}
}
