package com.kabank.mvc.factory;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.enums.DmlEnum;

public class SqlReplaceFactory {
	public static String update(String sql, String[] data, String[] columns) {
		StringBuffer resSql = new StringBuffer(sql);
		String temp = "";
		resSql.replace(resSql.indexOf("@"), resSql.indexOf("@")+1, data[2]);
		for(int i = 0; i < columns.length; i++) {
			if(!(columns[i].equals("id") || columns[i].equals("pwch"))) {
				temp += columns[i] + "='" + data[i] + "'";
				if(i != columns.length - 1) {
					temp += ", ";
				}
			}
		}
		resSql.insert(18, temp);
		System.out.println(resSql.toString());
		return resSql.toString();
	}
	public static String delete(String sql, String id) {
		StringBuffer resSql = new StringBuffer(sql);
		resSql.replace(resSql.indexOf("@"), resSql.indexOf("@")+1, id);
		return resSql.toString();
	}
	public static String updatetest(String sql, String id) {
		//"UPDATE Member SET  WHERE id LIKE '@'"
		StringBuffer resSql = new StringBuffer(sql);
		resSql.replace(resSql.indexOf("#"), resSql.indexOf("#")+1, id);
		System.out.println(resSql.toString());
		return resSql.toString();
	}
	public static String join() {
		StringBuffer resSql = new StringBuffer(DmlEnum.INSERT_MEMBER.toString());
		resSql.insert(12, DmlEnum.INTOVAL_MEMBER);
		String params = InitCommand.cmd.getData().substring(0, InitCommand.cmd.getData().indexOf("#"));
		String[] arr = params.split("/");
		return String.format(resSql.toString(), arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
	}
	
}
