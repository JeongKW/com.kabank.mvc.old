package com.kabank.mvc.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import com.kabank.mvc.enums.OracleEnum;

public class Oracle implements IDatabase{
	private Connection conn;
	private String driver, url, id, pw;
	public Oracle() {
		this.driver = OracleEnum.ORACLE_DRIVER.getValue();
		this.url = OracleEnum.ORACLE_CONNECTION_URL.getValue();
		this.id = OracleEnum.ORACLE_USERNAME.getValue();
		this.pw = OracleEnum.ORACLE_USERPW.getValue();
	}
	@Override
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
