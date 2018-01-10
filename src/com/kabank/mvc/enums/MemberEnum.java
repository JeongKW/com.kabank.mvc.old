package com.kabank.mvc.enums;

public enum MemberEnum {
	ID, PW, NAME, SSN, PHONE, EMAIL, PROFILE, ADDR,
	PROPERTIES{
		@Override
		public String toString() {
			return " " + ID + ", " + PW + ", " + NAME + ", " + SSN + ", " + PHONE + ", " + EMAIL + ", " + PROFILE + ", " + ADDR;
		}
	}
}
