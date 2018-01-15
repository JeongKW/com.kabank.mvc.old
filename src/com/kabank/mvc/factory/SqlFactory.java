package com.kabank.mvc.factory;

public class SqlFactory {
	public static String create(int pos, String sql, String add) {
		StringBuffer buffer = new StringBuffer(sql);
		buffer.insert(pos, add);
		return buffer.toString();
	}
}
