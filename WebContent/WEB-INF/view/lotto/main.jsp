<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<body>
<section>
	<article>
		<form action="result.jsp" style="width: 300px; height: 200px; margin: 0 auto;">
			구매 금액 : <input type="text" name="money" placeholder="게임당 1000원 최대 5게임" />
			<input type="submit" value="게임시작" />
		</form>	
	</article>
</section>
<%@ include file="../common/footer.jsp" %>
</body>
<script src="../../resources/js/lotto/lotto.js"></script>
</html>
