package com.kabank.mvc.daoImpl;

import java.util.*;
import java.sql.*;

import com.kabank.mvc.command.InitCommand;
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
			ResultSet rs = DatabaseFactory.create(Vendor.ORACLE)
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
			DatabaseFactory.create(Vendor.ORACLE).getConnection()
			.createStatement().executeUpdate(DdlEnum.CREATE_TABLE_MEMBER.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertMember(MemberBean m) {
		try {
			DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement()
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
			ResultSet rs = DatabaseFactory.create(Vendor.ORACLE).getConnection()
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

	@Override
	public MemberBean login() {
		System.out.println("----Member-D : Login In----");
		StringBuffer sql = new StringBuffer(MemberEnum.LOGIN.toString());
		String[] arr = InitCommand.cmd.getData().split("/");
		System.out.println("ID : " + arr[0]);
		System.out.println("PW : " + arr[1]);
		sql.replace(sql.indexOf("$"), sql.indexOf("$")+1, arr[0]);
		sql.replace(sql.indexOf("@"), sql.indexOf("@")+1, arr[1]);
		System.out.println("SQL : " + sql.toString());
		MemberBean member = null;
		try {
			ResultSet rs = DatabaseFactory.create(Vendor.ORACLE).getConnection()
					.createStatement().executeQuery(sql.toString());
			while(rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(MemberEnum.ID.name()));
				member.setPw(rs.getString(MemberEnum.PW.name()));
				member.setName(rs.getString(MemberEnum.NAME.name()));
				member.setSsn(rs.getString(MemberEnum.SSN.name()));
				member.setPhone(rs.getString(MemberEnum.PHONE.name()));
				member.setEmail(rs.getString(MemberEnum.EMAIL.name()));
				member.setProfile(rs.getString(MemberEnum.PROFILE.name()));
				member.setAddr(rs.getString(MemberEnum.ADDR.name()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("----Member-D : Login Out----");
		return member;
	}

	@Override
	public void update() {
		System.out.println("----Member-D : Update In----");
		StringBuffer sql = new StringBuffer(MemberEnum.UPDATE.toString());
		String[] arr = InitCommand.cmd.getData().split("/");
		System.out.println("현재 패스워드 : " + arr[0]);
		System.out.println("변경할 패스워드 : " + arr[1]);
		sql.replace(sql.indexOf("@"), sql.indexOf("@")+1, arr[0]);
		sql.replace(sql.indexOf("$"), sql.indexOf("$")+1, arr[1]);
		try {
			DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeUpdate(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("----Member-D : Update Out----");
	}

}
