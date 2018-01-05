package com.kabank.mvc.constants;

public class AdminSQL {
	public static final String 
	CREATE_MEMBER = "CREATE TABLE Member("
			+ "id VARCHAR2(20) PRIMARY KEY,"
			+ "pw VARCHAR2(20),"
			+ "name VARCHAR2(20),"
			+ "ssn VARCHAR2(20),"
			+ "phone VARCHAR2(20),"
			+ "email VARCHAR2(20),"
			+ "profile VARCHAR2(20),"
			+ "addr VARCHAR2(40)"
			+ ")",
	CREATE_ATTEND = "CREATE TABLE Attend("
			+ "seq NUMBER PRIMARY KEY,"
			+ "week VARCHAR2(10),"
			+ "status VARCHAR2(10)"
			+ "id VARCHAR2(20)"
			+ ")"
	;
}
