<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<td>
						테이블 생성<br/>
					<form id="create_form" action="${pageContext.request.contextPath}/admin/create_table.do ">
						<select name="tname" id="tname">
							<option>선택하세요</option>
							<option value="member">회원테이블</option>
							<option value="attend">출석테이블</option>
						</select>
						<button id="create_btn">생 성</button>
					</form>
					</td>
				</tr>
			</table>
		</section>
	</div>
	<%@ include file="../common/footer.jsp" %>
<script>
	document.querySelector('#create_btn').addEventListener("click", function(){
		document.querySelector('#create_form').submit();
	}, false);
</script>
</html>