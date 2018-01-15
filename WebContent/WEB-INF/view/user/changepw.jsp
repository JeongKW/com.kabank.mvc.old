<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrapper">
	<section>
		<form id="pwch_form" action="${ctx}/user.do">
			현재 비밀번호 <input type="text" name="c_pw" value="${user.pw}"/><br/>
			수정할 비밀번호 <input type="text" name="m_pw"/><br/>
			수정할 비밀번호 확인 <input type="text" name="m_pwch"/><br/>
			휴대폰 번호 <input type="text" name="m_phone"/><br/>
			E-Mail <input type="text" name="m_email" /><br/>
			Profile <input type="text" name="m_profile" /><br/>
			주소 <input type="text" name="m_addr" /><br/>
			<input type="hidden" name="cmd" value="change"/>
			<input type="hidden" name="page" value="main"/>
			<input type="hidden" name="dir" value="bitcamp"/>
			<input type="hidden" name="c_phone" value="${user.phone}"/>
			<input type="hidden" name="c_email" value="${user.email}"/>
			<input type="hidden" name="c_profile" value="${user.profile}"/>
			<input type="hidden" name="c_addr" value="${user.addr}"/>
		</form>
		<button id="pwch_confirm_btn">확인</button>
		<button id="pwch_cancel_btn">취소</button>
	</section>
</div>
<%@ include file="../common/footer.jsp" %>
<script>
	document.querySelector('#pwch_confirm_btn').addEventListener('click', function(){
		document.querySelector('#pwch_form').submit();
	}, false);
	document.querySelector('#pwch_cancel_btn').addEventListener('click', function(){
		location.href = "${ctx}/user.do?cmd=move&page=main&dir=bitcamp";
	}, false);
</script>
</html>