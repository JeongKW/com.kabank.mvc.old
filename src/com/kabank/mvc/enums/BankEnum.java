package com.kabank.mvc.enums;

public enum BankEnum {
	CUSTOMER_NUM, ACCOUNT_NUM, MONEY, ID,
	PROPERTIES{
		@Override
		public String toString() {
			return CUSTOMER_NUM + "," + ACCOUNT_NUM + "," + MONEY + "," + ID;
		}
	}
}
