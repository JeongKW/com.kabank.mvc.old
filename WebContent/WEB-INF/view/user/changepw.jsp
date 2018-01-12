<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrapper">
	<section>
		<form id="pwch_form" action="${ctx}/user.do">
			현재 비밀번호 <input type="text" name="c_pw" value="${user.pw}"/>
			수정할 비밀번호 <input type="text" name="m_pw"/>
			수정할 비밀번호 확인 <input type="text" name="m_pwch"/>			
			<button id="pwch_confirm_btn">확인</button>
			<input type="hidden" name="cmd" value="change"/>
			<input type="hidden" name="page" value="main"/>
			<input type="hidden" name="dir" value="bitcamp"/>
		</form>
	</section>
</div>
<%@ include file="../common/footer.jsp" %>
</html>