package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Vendor;

public class DatabaseFactory {
	public static IDatabase create(Vendor vendor) {
		IDatabase db = null;
		switch (vendor) {
		case ORACLE:
			db = new Oracle();
			break;
		case MYSQL:
			
			break;
		case MARIADB:
			
			break;
		default:
			break;
		}
		return db;
	}
}
