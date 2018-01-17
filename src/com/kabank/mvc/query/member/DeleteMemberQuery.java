package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class DeleteMemberQuery implements IQuery{
	PreparedStatement pstmt;
	public DeleteMemberQuery() {
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
						DML.DELETE + " "
						+ DML.FROM + " "
						+ TnameEnum.MEMBER + " "
						+ DML.WHERE + " id LIKE ?");
			pstmt.setString(1, InitCommand.cmd.getData().split("/")[0]);
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
