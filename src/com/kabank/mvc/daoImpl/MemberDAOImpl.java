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
import com.kabank.mvc.factory.SqlFactory;

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
				MemberBean res = new MemberBean();
				res.setId(rs.getString(MemberEnum.ID.name()));
				res.setPw(rs.getString(MemberEnum.PW.name()));
				res.setName(rs.getString(MemberEnum.NAME.name()));
				res.setSsn(rs.getString(MemberEnum.SSN.name()));
				res.setPhone(rs.getString(MemberEnum.PHONE.name()));
				res.setEmail(rs.getString(MemberEnum.EMAIL.name()));
				res.setProfile(rs.getString(MemberEnum.PROFILE.name()));
				res.setAddr(rs.getString(MemberEnum.ADDR.name()));
				list.add(res);
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
			DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().createStatement()
			.executeUpdate(String.format(SqlFactory.create(11, DmlEnum.INSERT.toString(), DmlEnum.INTOVAL_MEMBER.toString()),
					m.getId(), m.getPw(), m.getName(), m.getSsn(), m.getPhone(), m.getEmail(), m.getProfile(), m.getAddr()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public MemberBean selectMemberById(MemberBean m) {
		MemberBean res = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
			.createStatement()
			.executeQuery(String.format(DmlEnum.SELECT.toString() + TnameEnum.MEMBER.name() + DmlEnum.MEMBER_LOGIN.toString(), m.getId(), m.getPw()));
			while(rs.next()) {
				res = new MemberBean();
				res.setId(rs.getString(MemberEnum.ID.name()));
				res.setPw(rs.getString(MemberEnum.PW.name()));
				res.setName(rs.getString(MemberEnum.NAME.name()));
				res.setSsn(rs.getString(MemberEnum.SSN.name()));
				res.setPhone(rs.getString(MemberEnum.PHONE.name()));
				res.setEmail(rs.getString(MemberEnum.EMAIL.name()));
				res.setProfile(rs.getString(MemberEnum.PROFILE.name()));
				res.setAddr(rs.getString(MemberEnum.ADDR.name()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
