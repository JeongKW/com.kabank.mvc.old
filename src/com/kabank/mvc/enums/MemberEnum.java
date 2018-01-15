package com.kabank.mvc.enums;

public enum MemberEnum {
	ID, PW, NAME, SSN, PHONE, EMAIL, PROFILE, ADDR,
	PROPERTIES{
		@Override
		public String toString() {
			return ID + ", " + PW + ", " + NAME + ", " + SSN + ", " + PHONE + ", " + EMAIL + ", " + PROFILE + ", " + ADDR;
		}
	},
	LOGIN{
		@Override
		public String toString() {
			return "SELECT ID, PW, NAME, SSN , PHONE, EMAIL, PROFILE, ADDR FROM Member WHERE id LIKE '$' AND pw LIKE '@'";
		}
	},
	UPDATE{
		@Override
		public String toString() {
			return "UPDATE Member SET pw='$' WHERE id LIKE '@'";
		}
	}
}
