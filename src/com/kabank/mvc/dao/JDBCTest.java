package com.kabank.mvc.dao;
import java.sql.*;

import com.kabank.mvc.constants.CommonSQL;
import com.kabank.mvc.constants.DBMS;

public class JDBCTest {
	public static void main(String[] args) {
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_USERPW);
			Statement stmt = conn.createStatement();
			String sql = CommonSQL.countTableSQL("tab");
			ResultSet rs = stmt.executeQuery(sql);
			String count = "";
			while(rs.next()) {
				count = rs.getString("count");
			}
			System.out.println("테이블 수 : " + count);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
