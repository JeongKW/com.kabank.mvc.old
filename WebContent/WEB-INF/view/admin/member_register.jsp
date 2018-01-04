<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kabank.mvc.domain.MemberBean"%>
<%@ page import="java.sql.*" %>
<jsp:useBean id="member" class="com.kabank.mvc.domain.MemberBean" scope="request" ></jsp:useBean>
<%
	String addr = request.getParameter("addr_head") + " " + request.getParameter("addr_tail");
	member.setId(request.getParameter("id"));
	member.setPw(request.getParameter("pw"));
	member.setName(request.getParameter("name"));
	member.setSsn(request.getParameter("ssn"));
	member.setEmail(request.getParameter("email"));
	member.setPhone(request.getParameter("phone"));
	member.setProfile(request.getParameter("profile"));
	member.setAddr(addr);
	
	Connection conn = null;
	Statement stmt = null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "bitcamp", "bitcamp");
		stmt = conn.createStatement();
		
		String sql = String.format("INSERT INTO Member("
					+ "id,"
					+ "pw,"
					+ "name,"
					+ "ssn,"
					+ "phone,"
					+ "email,"
					+ "profile,"
					+ "addr"
					+ ") VALUES ("
					+ "'%s','%s','%s','%s','%s','%s','%s','%s')",
					 member.getId(), member.getPw(), member.getName(), member.getSsn(),
					 member.getPhone(), member.getEmail(), member.getProfile(), member.getAddr());
		stmt.executeUpdate(sql);
	}catch(SQLException ex){
		out.println(ex.getMessage());
		ex.printStackTrace();
	} finally {
		if(stmt != null){
			try{ stmt.close(); } catch(Exception e){ e.printStackTrace(); } }
		if(conn != null){
			try{ conn.close(); } catch(Exception e){ e.printStackTrace(); } }
	}
		
	pageContext.forward("member_list.jsp");
%>