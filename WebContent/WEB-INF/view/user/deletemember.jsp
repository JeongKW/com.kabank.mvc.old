<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrapper">
	<section>
		<form id="delete_form" action="${ctx}/user.do">
			비밀번호 <input type="text" name="pw"/><br/>
			비밀번호 확인<input type="text" name="pwch"/><br/>
			<input type="hidden" name="cmd" value="drop"/>
			<input type="hidden" name="page" value="login"/>
			<input type="hidden" name="id" value="${user.id}"/>
		</form>
		<button id="delete_confirm_btn">확인</button>
		<button id="delete_cancel_btn">취소</button>
	</section>
</div>
<%@ include file="../common/footer.jsp" %>
<script>
	document.querySelector('#delete_confirm_btn').addEventListener('click', function(){
		document.querySelector('#delete_form').submit();
	}, false);
	document.querySelector('#delete_cancel_btn').addEventListener('click', function(){
		location.href = "${ctx}/user.do?cmd=move&page=main&dir=bitcamp";
	}, false);
</script>
</html>