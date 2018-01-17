package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.MemberProps;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.PropertiesFactory;

public class LoginQuery implements IQuery{
	PreparedStatement pstmt;
	public LoginQuery() {
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
						DML.SELECT + " "
						+ PropertiesFactory.create(MemberProps.values()) + " "
						+ DML.FROM + " MEMBER "
						+ DML.WHERE
						+ " id LIKE ? "
						+ DML.AND + " pw LIKE ?");
			String[] arr = InitCommand.cmd.getData().split("/");
			for(int i = 0; i < arr.length; i++) {
				pstmt.setString(i+1, arr[i]);
			}
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Object excute() {
		MemberBean member = null;
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(MemberProps.ID.name()));
				member.setPw(rs.getString(MemberProps.PW.name()));
				member.setName(rs.getString(MemberProps.NAME.name()));
				member.setSsn(rs.getString(MemberProps.SSN.name()));
				member.setPhone(rs.getString(MemberProps.PHONE.name()));
				member.setEmail(rs.getString(MemberProps.EMAIL.name()));
				member.setProfile(rs.getString(MemberProps.PROFILE.name()));
				member.setAddr(rs.getString(MemberProps.ADDR.name()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
}
