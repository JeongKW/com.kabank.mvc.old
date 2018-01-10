package com.kabank.mvc.util;
import java.sql.ResultSet;

import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class JDBCTest {
	public static void main(String[] args) {
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
										  .createStatement().executeQuery(DmlEnum.ALLTABLE.toString());
			String count = "";
			while(rs.next()) {
				count = rs.getString("tname");
			}
			System.out.println("테이블 수 : " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
