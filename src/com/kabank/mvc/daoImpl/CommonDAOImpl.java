package com.kabank.mvc.daoImpl;

import java.sql.ResultSet;

import com.kabank.mvc.dao.CommonDAO;
import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class CommonDAOImpl implements CommonDAO{
	
	@Override
	public String selectTableCount() {
		String count = "";
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
						   .createStatement().executeQuery(DmlEnum.COUNT.toString() + TnameEnum.MEMBER);
			while(rs.next()) {
				count = rs.getString("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
