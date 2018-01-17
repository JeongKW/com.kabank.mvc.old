package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.MemberProps;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.PropertiesFactory;

public class InsertMemberQuery implements IQuery{
	PreparedStatement pstmt;
	public InsertMemberQuery() {
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
						DML.INSERT + " "
						+ DML.INTO + " "
						+ TnameEnum.MEMBER + "("
						+ PropertiesFactory.create(MemberProps.values()) + ") "
						+ DML.VALUES + "(?, ?, ?, ?, ?, ?, ?, ?)");
			String[] arr = InitCommand.cmd.getData().split("#")[0].split("/");
			for(int i = 0; i < arr.length; i++) {
				pstmt.setString(i+1, arr[i]);
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Object excute() {
		return null;
	}

}
