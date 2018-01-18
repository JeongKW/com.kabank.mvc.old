package com.kabank.mvc.enums;

public enum DmlEnum {
	COUNT{
		@Override
		public String toString() {
			return "SELECT COUNT(*) AS count FROM ";
		}
	},
	ALLTABLE{
		@Override
		public String toString() {
			return "SELECT * FROM TAB";
		}
	},
	SELECT{
		@Override
		public String toString() {
			return "SELECT  FROM ";
		}
	},
	INSERT_MEMBER{
		@Override
		public String toString() {
			return "INSERT INTO  VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
		}
	},
	INTOVAL_MEMBER{
		@Override
		public String toString() {
			return "MEMBER(" + MemberEnum.PROPERTIES.toString() + ")";
		}
	},
	MEMBER_LOGIN{
		@Override
		public String toString() {
			return " WHERE id like '%s' AND pw like '%s'";
		}
	},
	DELETE_MEMBER{
		@Override
		public String toString() {
			return "DELETE FROM MEMBER WHERE id = '@'";
		}
	},
	INSERT_BANK{
		@Override
		public String toString() {
			return "INSERT INTO BANK(" + BankEnum.PROPERTIES.toString() + ") VALUES(%s, '%s', '%s', '%s')";
		}
	},
	BANK_INCRETMENT{
		@Override
		public String toString() {
			return "create sequence customer_num start with 1000 increment by 1";
		}
	}
}
