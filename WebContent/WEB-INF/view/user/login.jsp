<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body>
	<div id="wrapper">
	<header id="index_header">
		<h1>BIT CAMP SAMPLE PROJECT</h1>
	</header>
	<section>
		<article>
			<table id="index_table">
				<tr>
					<td colspan="5">
						<form id="login_form" action="${pageContext.request.contextPath}/user/auth.do">
							<table id="index_login_box">
								<tr>
									<td><input id="index_input_id" type="text" placeholder="ID"
									name="id" /></td>
									<td rowspan="2"><button id="index_login_btn">로그인</button></td>
								</tr>
								<tr>
									<td><input id="index_input_pw" type="password"
									placeholder="PASSWORD" name="pw" /></td>
								</tr>
							</table>
							</form>
							<a id="go_admin_link" href="#">관리자모드</a>
							<a id="go_join_link" href="#">회원가입</a>
							<a id="go_jdbc_link" href="#">JDBC Test</a>
					</td>
				</tr>
			</table>
		</article>
	</section>
</div>
<footer id="index_footer">
	<address>
		Copyright &copy; <a href="http://bitcamp.co.kr/index.php?main_page=home">bitcamp</a>
	</address>
</footer>
</body>
<script>
	document.querySelector('#go_join_link').addEventListener('click', function () {
		location.href = "${pageContext.request.contextPath}/user/join.do";
	}, false);
	
	document.querySelector('#go_jdbc_link').addEventListener('click', function () {
		location.href = "${pageContext.request.contextPath}/common/jdbc_test.do";
	}, false);
	
	document.querySelector('#go_admin_link').addEventListener('click', function () {
		var adminOk = confirm('관리자?');
		if(adminOk){
			location.href = "${pageContext.request.contextPath}/admin/main.do";
		} else {
			alert('관리자만이 접근가능 합니다.');
		}
	}, false);
	
	document.querySelector('#index_login_btn').addEventListener('click', function() {
			document.querySelect('#login_form').submit();
	}, false);
</script>
</html>