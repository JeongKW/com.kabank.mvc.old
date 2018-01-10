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
			return "INSERT INTO VALUES";
		}
	},
	INTOVAL_MEMBER{
		@Override
		public String toString() {
			return " MEMBER(" + MemberEnum.PROPERTIES.toString() + ")";
		}
	}
}
