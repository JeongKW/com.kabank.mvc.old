package com.kabank.mvc.util;

import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.enums.OracleEnum;

public class FactoryTest {
	public static void main(String[] args) {
		System.out.println(OracleEnum.ORACLE_CONNECTION_URL.getValue());
		StringBuffer sql = new StringBuffer(DmlEnum.INSERT.toString());
//		"INSERT INTO VALUES"
//		"123456789012345678
		
		System.out.println(sql.toString());
	}
}
