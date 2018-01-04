<%@page import="com.kabank.mvc.domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%
	String sql = "";
	
	Statement stmt = null;
	Connection conn = null;
	ResultSet rs = null;
	List<MemberBean> result = new ArrayList<>();
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "bitcamp", "bitcamp");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM tab");
		List<String> list = new ArrayList<>();
		while(rs.next()){
			String temp = rs.getString("TNAME");
			list.add(temp);
		}
		rs.close();
		boolean exist = false;
		for(String s : list){
			if(s.equalsIgnoreCase("member")){
				exist = true;
				break;
			}
		}
		if(!exist){
			stmt.executeUpdate("CREATE TABLE Member("
					+ "id VARCHAR2(20) PRIMARY KEY,"
					+ "pw VARCHAR2(20),"
					+ "name VARCHAR2(20),"
					+ "ssn VARCHAR2(20),"
					+ "phone VARCHAR2(20),"
					+ "email VARCHAR2(20),"
					+ "profile VARCHAR2(20),"
					+ "addr VARCHAR2(40)"
					+ ")");
		} else {
			rs = stmt.executeQuery("SELECT id, pw, name, ssn, phone, email, profile, addr FROM Member");
			while(rs.next()){
				MemberBean m = new MemberBean();
				m.setId(rs.getString("ID"));
				m.setPw(rs.getString("PW"));
				m.setName(rs.getString("NAME"));
				m.setSsn(rs.getString("SSN"));
				m.setPhone(rs.getString("PHONE"));
				m.setEmail(rs.getString("EMAIL"));
				m.setProfile(rs.getString("PROFILE"));
				m.setAddr(rs.getString("ADDR"));
				result.add(m);
			}
		}
	} catch(SQLException ex){
		out.println(ex.getMessage());
		ex.printStackTrace();
	} finally {
		if(rs != null) { 
			try{ rs.close(); } catch(Exception e){ e.printStackTrace(); } }
		if(stmt != null){
			try{ stmt.close(); } catch(Exception e){ e.printStackTrace(); } }
		if(conn != null){
			try{ conn.close(); } catch(Exception e){ e.printStackTrace(); } }
	}
%>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body>
	<div id="wrapper">
		<header>
			<h1>관리자 메인 페이지</h1>
		</header>
		<nav id="admin_nav">
			<a href="#">회원관리</a><br/>
			<a href="#">...</a><br/>
			<a href="#">...</a>
		</nav>
		<section id="admin_section">
			<table id="member_table">
				<tr id="member_trth">
					<td colspan="8">
						<select style="width: 80px; height: 25px;"name="" id="">
							<option>ID</option>
							<option>이름</option>
							<option>성별</option>
						</select>
						<input style="width: 300px; height: 25px;" type="text" /> <button>검 색</button>
					</td>
				</tr>
				<tr id="member_trtd">
					<td id="member_notd">No</td>
					<td id="member_idtd">ID</td>
					<td id="member_nametd">이름</td>
					<td id="member_birthtd">생년월일</td>
					<td id="member_gendertd">성별</td>
					<td id="member_phonetd">전화번호</td>
					<td id="member_emailtd">이메일</td>
					<td id="member_addrtd">주소</td>
				</tr>
<%
				
				for(int i = result.size() - 1, index = result.size(); i >= 0; i--){
%>
					<tr>
						<td id="member_notd"><%=index-- %></td>
						<td id="member_idtd"><%=result.get(i).getId() %></td>
						<td id="member_nametd"><%=result.get(i).getName() %></td>
						<td id="member_birthtd"><%=result.get(i).getSsn().split("-")[0] %></td>
						<td id="member_gendertd"><% out.print(((result.get(i).getSsn().split("-")[1].charAt(0) == '1') || (result.get(i).getSsn().split("-")[1].charAt(0) == '3'))
								? "남" : "여"); %></td>
						<td id="member_phonetd"><%=result.get(i).getPhone() %></td>
						<td id="member_emailtd"><%=result.get(i).getEmail() %></td>
						<td id="member_addrtd"><%=result.get(i).getAddr() %></td>
					</tr>					
<%				
				}
%>
				<tr>
					<td colspan="8"> <button id="add_member_btn">추 가</button> </td>
				</tr>
			</table>
		</section>
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
<script src="../../resources/js/admin/member_list.js"></script>
</html>