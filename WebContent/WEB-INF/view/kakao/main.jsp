<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<section>
	<button id="bank_create">통장개설</button>
	<button>입금</button>
	<button>출금</button>
	<button>송금</button>
	<button>통장해지</button><br/>
</section>
<aside></aside>
<%@ include file="../common/footer.jsp" %>
<script>
	document.querySelector('#bank_create').addEventListener('click', function(){
		location.href = "${ctx}/kakao.do?cmd=create&page=mypage&dir=user&id=${sessionScope.user.id}";
	}, false);
</script>
</html>
