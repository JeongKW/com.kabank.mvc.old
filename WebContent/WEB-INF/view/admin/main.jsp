<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body>
	<div id="wrapper">
		<header>
			<h1>관리자 메인 페이지</h1>
		</header>
		<nav id="admin_nav">
			<a href="#" id="member_mgmt_link">회원관리</a><br/>
			<a href="#">...</a><br/>
			<a href="#">...</a>
		</nav>
		<section id="admin_section">
			<table id="admin_table">
				<tr>
					<td> <button id="admin_manage">회원관리</button> </td>
					<td>a</td>
					<td>a</td>
				</tr>
				<tr>
					<td>a</td>
					<td>a</td>
					<td>a</td>
				</tr>
			</table>
		</section>
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
<script src="../../resources/js/admin/main.js"></script>
</html>