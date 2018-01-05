package com.kabank.mvc.daoImpl;

import com.kabank.mvc.constants.AdminSQL;
import com.kabank.mvc.constants.CommonSQL;
import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.dao.AttendDAO;

import java.sql.*;
import java.util.*;

public class AttendDAOImpl implements AttendDAO{
//	private static AttendDAO instance;
//	public static AttendDao AttendDAOImpl() {
//		if(instance == null) {
//			instance = new AttendDAOImpl();
//		}
//		return instance;
//	}
//	private Connection conn;
//	private AttendDAOImpl() {
//		try {
//			Class.forName(DBMS.ORACLE_DRIVER);
//			conn = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_USERPW);
//			} catch (Exception e) {
//				e.printStackTrace();
//		}
//	}
	@Override
	public void createAttend() {
		List<String> tlist = new ArrayList<>();
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_USERPW);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(CommonSQL.ALLTABSQL);
			boolean exist = false;
			while(rs.next()) {
				String temp = rs.getString("tname");
				tlist.add(temp);
			}
			for(int i = 0; i < tlist.size(); i++) {
				if(tlist.get(i).equalsIgnoreCase("attend")) {
					exist = true;
					break;
				}
			}
			if(!exist) {
				stmt.executeUpdate(AdminSQL.CREATE_ATTEND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
