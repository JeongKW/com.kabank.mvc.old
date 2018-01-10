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
			return "SELECT FROM ";
		}
	},
	INSERT{
		@Override
		public String toString() {
			return "INSERT INTO VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
		}
	},
	INTOVAL_MEMBER{
		@Override
		public String toString() {
			return " MEMBER(" + MemberEnum.PROPERTIES.toString() + ")";
		}
	},
	MEMBER_LOGIN{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return " WHERE id like '%s' AND pw like '%s'";
		}
	}
}
