package com.kabank.mvc.constants;

public class CommonSQL {
	public static final String 
	ALLTABSQL = "SELECT * FROM TAB"
	;
	public static final String countTableSQL(String tableName) {
		return "SELECT COUNT(*) AS count FROM " + tableName;
	}
}