<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@page import="com.kabank.mvc.domain.AttendBean"%>
<jsp:useBean id="attend" class="com.kabank.mvc.domain.AttendBean" scope="request" ></jsp:useBean>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<AttendBean> result = new ArrayList<>();
	String sql = "";
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bitcamp", "bitcamp");
		stmt = conn.createStatement();
		sql = "SELECT * FROM TAB";
		rs = stmt.executeQuery(sql);
		List<String> list = new ArrayList<>();
		while(rs.next()){
			String temp = rs.getString("tname");
			list.add(temp);
		}
		boolean exist = false;
		for(String s : list){
			if(s.equalsIgnoreCase("attendstatus")){
				exist = true;
				break;
			}
		}
		if(!exist){
			stmt.executeQuery("CREATE TABLE Attendstatus("
					+ "id VARCHAR2(20) PRIMARY KEY,"
					+ "week VARCHAR2(10),"
					+ "status VARCHAR2(10)"
				+ ")");
		} else {
			while(rs.next()){
				
			}
		}
	} catch(SQLException ex){
		ex.printStackTrace();
	} finally{
			if(rs != null){ try{ rs.close(); } catch(Exception e){ e.printStackTrace(); } }
			if(stmt != null){ try{ stmt.close(); } catch(Exception e){ e.printStackTrace(); } }
			if(conn != null){ try{ conn.close(); } catch(Exception e){ e.printStackTrace(); } }
	}
	pageContext.forward("main.jsp");
%>