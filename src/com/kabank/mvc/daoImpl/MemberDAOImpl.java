package com.kabank.mvc.daoImpl;

import java.util.*;
import java.sql.*;

import com.kabank.mvc.constants.AdminSQL;
import com.kabank.mvc.constants.CommonSQL;
import com.kabank.mvc.constants.DBMS;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.util.Enums;
import com.kabank.mvc.util.Enums.MembersColumn;

public class MemberDAOImpl implements MemberDAO{
	public static MemberDAO getInstance() {
		return new MemberDAOImpl();
	}
	
	private MemberDAOImpl() {
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<MemberBean> selectMembers() {
		List<MemberBean> list = new ArrayList<>();
		List<String> tlist = new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_USERPW)
					.createStatement()
					.executeQuery(CommonSQL.ALLTABSQL);
			boolean exist = false;
			while(rs.next()) {
				String temp = rs.getString("tname");
				tlist.add(temp);
			}
			for(int i = 0; i < tlist.size(); i++) {
				if(tlist.get(i).equalsIgnoreCase("member")) {
					exist = true;
					break;
				}
			}
			if(!exist) {
				createMember();
			}
			while(rs.next()) {
				MemberBean temp = new MemberBean();
				temp.setId(rs.getString("id"));
				temp.setPw(rs.getString("pw"));
				temp.setName(rs.getString("name"));
				temp.setSsn(rs.getString("ssn"));
				temp.setPhone(rs.getString("phone"));
				temp.setEmail(rs.getString("email"));
				temp.setProfile(rs.getString("profile"));
				temp.setAddr(rs.getString("addr"));
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void createMember() {
		List<String> tlist = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_USERPW);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(CommonSQL.ALLTABSQL);
			boolean exist = false;
			while(rs.next()) {
				String temp = rs.getString("tname");
				tlist.add(temp);
			}
			for(int i = 0; i < tlist.size(); i++) {
				if(tlist.get(i).equalsIgnoreCase("member")) {
					exist = true;
					break;
				}
			}
			if(!exist) {
				stmt.executeUpdate(AdminSQL.CREATE_MEMBER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertMember(MemberBean m) {
		try {
			String sql = "";
			sql += Enums.DML.INSERT + " " + Enums.DML.INTO + " " + Enums.Table.MEMBER + "(";
//			for(Enums.MembersColumn c : Enums.MembersColumn.values()) {
//				if(c.ordinal() == Enums.MembersColumn.values().length - 1) {
//					sql += c + ") ";
//				} else {
//					sql += c + ", ";
//				}
//			}
			MembersColumn[] values = Enums.MembersColumn.values();
			for(int i = 0; i < Enums.MembersColumn.values().length; i++) {
				if(!(i==Enums.MembersColumn.values().length - 1)) {
					sql += values[i] + ", ";
				} else {
					sql += values[i] + ") ";
				}
			}
			sql += String.format(Enums.DML.VALUES + " ("
					+ Enums.getBlanks(Enums.MembersColumn.values().length)
					+ ")", 
					m.getId(), m.getPw(), m.getName(), m.getSsn(), m.getPhone(), m.getEmail(), m.getProfile(), m.getAddr());
			System.out.println(sql);
			DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_USERPW)
			.createStatement()
			.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public MemberBean selectMemberById(MemberBean m) {
		MemberBean res = null;
		String sql = String.format("SELECT * FROM Member WHERE id like '%s' AND pw like '%s'", m.getId(), m.getPw());
		try {
			ResultSet rs = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_USERPW)
			.createStatement()
			.executeQuery(sql);
			while(rs.next()) {
				res = new MemberBean();
				res.setId(rs.getString("id"));
				res.setPw(rs.getString("pw"));
				res.setName(rs.getString("name"));
				res.setSsn(rs.getString("ssn"));
				res.setPhone(rs.getString("phone"));
				res.setEmail(rs.getString("email"));
				res.setProfile(rs.getString("profile"));
				res.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
