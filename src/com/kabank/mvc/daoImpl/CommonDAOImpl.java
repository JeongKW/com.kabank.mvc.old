package com.kabank.mvc.daoImpl;

import java.sql.*;

import com.kabank.mvc.constants.CommonSQL;
import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.dao.CommonDAO;

public class CommonDAOImpl implements CommonDAO{
	
	@Override
	public String selectTableCount() {
		String count = "";
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_USERPW);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(CommonSQL.countTableSQL("Member"));
			while(rs.next()) {
				count = rs.getString("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
