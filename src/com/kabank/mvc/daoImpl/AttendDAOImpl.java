package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.AttendDAO;
import com.kabank.mvc.enums.DdlEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class AttendDAOImpl implements AttendDAO{
	public static AttendDAO getInstance() { return new AttendDAOImpl(); }
	private AttendDAOImpl() { }

	@Override
	public void createAttend() {
		try {
			DatabaseFactory.create(Vendor.ORACLE)
						   .getConnection().createStatement()
						   .executeUpdate(DdlEnum.CREATE_TABLE_ATTEND.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}