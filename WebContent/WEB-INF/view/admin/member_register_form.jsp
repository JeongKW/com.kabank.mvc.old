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
			<a href="#">회원관리</a><br/>
			<a href="#">...</a><br/>
			<a href="#">...</a>
		</nav>
		<section id="admin_section">
			<form id="member_register_form" action="member_register.jsp">
				<table id="add_member_table">
					<tr>
						<td>ID</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>주민번호</td>
						<td><input type="text" name="ssn"></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td rowspan="2">주소</td>
						<td rowspan="2">
							<input type="text" name="zipcode"> <button>주소검색</button><br/>
							<input type="text" name="addr_head">
							<input type="text" name="addr_tail">
						</td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td colspan="2">
							<button id="member_register_btn">추 가</button>
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
<script src="../../resources/js/admin/member_register_form.js"></script>
</html>