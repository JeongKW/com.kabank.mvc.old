package com.kabank.mvc.util;

public class Enums {
	public enum MembersColumn {
		ID, PW, NAME, SSN, PHONE, EMAIL, PROFILE, ADDR
	}
	public enum AttendColumn {
		SEQ, ID, WEEK, STATUS
	}
	public enum Table{
		MEMBER, ATTEND, ADMIN
	}
	public enum DML{
		SELECT, INSERT, INTO, UPDATE, DELETE, FROM, VALUES
	}
	public static String getBlanks(int count) {
		String blanks = "";
		for(int i = 0; i < count; i++) {
			if(i != count - 1) {
				blanks += "'%s',";
			} else {
				blanks += "'%s'";
			}
		}
		return blanks;
	}
}
