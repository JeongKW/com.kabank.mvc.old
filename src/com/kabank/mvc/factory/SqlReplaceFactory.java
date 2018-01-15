package com.kabank.mvc.factory;

public class SqlReplaceFactory {
	public static String create(String sql, String[] arr) {
		StringBuffer resSql = new StringBuffer(sql);
		resSql.replace(resSql.indexOf("$"), resSql.indexOf("$")+1, arr[0]);
		resSql.replace(resSql.indexOf("@"), resSql.indexOf("@")+1, arr[3]);
		return resSql.toString();
	}
}
