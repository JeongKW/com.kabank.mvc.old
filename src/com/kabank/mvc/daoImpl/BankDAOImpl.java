package com.kabank.mvc.daoImpl;

import java.sql.SQLException;
import java.sql.Statement;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.BankDAO;
import com.kabank.mvc.enums.DdlEnum;
import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class BankDAOImpl implements BankDAO{
	public static BankDAO getInstance() { return new BankDAOImpl();	}
	private BankDAOImpl() { }

	@Override
	public void createBank() {
		try {
			Statement stmt = DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement();
			stmt.executeUpdate(DmlEnum.BANK_INCRETMENT.toString());
			stmt.executeUpdate(DdlEnum.CREATE_TABLE_BANK.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void createAccount() {
		try {
			DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeUpdate(InitCommand.cmd.getSql());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
