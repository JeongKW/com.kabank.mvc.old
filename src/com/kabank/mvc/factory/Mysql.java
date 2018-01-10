package com.kabank.mvc.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mysql implements Database{
	private Connection conn;
	private String driver, url, id, pw;
	
	public Mysql() {
		this.conn = conn;
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pw = pw;
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
