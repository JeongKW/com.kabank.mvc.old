package com.kabank.mvc.daoImpl;

import java.util.*;
import java.sql.*;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DdlEnum;
import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO{
	public static MemberDAO getInstance() { return new MemberDAOImpl(); }
	
	private MemberDAOImpl() { }
	@Override
	public List<MemberBean> selectMembers() {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeQuery(DmlEnum.ALLTABLE.toString());
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
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
			.createStatement().executeUpdate(DdlEnum.CREATE_TABLE_MEMBER.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertMember(MemberBean m) {
		try {
			StringBuffer sql = new StringBuffer(DmlEnum.INSERT.toString());
			sql.insert(11, DmlEnum.INTOVAL_MEMBER);
			sql.append(String.format("('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
					m.getId(), m.getPw(), m.getName(), m.getSsn(), m.getPhone(), m.getEmail(), m.getProfile(), m.getAddr()));
			DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().createStatement().executeUpdate(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public MemberBean selectMemberById(MemberBean m) {
		MemberBean res = null;
		try {
			StringBuffer sql = new StringBuffer(DmlEnum.SELECT.toString());
			sql.insert(12, TnameEnum.MEMBER);
			sql.insert(6, MemberEnum.PROPERTIES.toString());
			sql.append(String.format(" WHERE id like '%s' AND pw like '%s'", m.getId(), m.getPw()));
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
			.createStatement()
			.executeQuery(sql.toString());
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
