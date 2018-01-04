<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.kabank.mvc.domain.BurgerKingBean" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="hamburger" class="com.kabank.mvc.domain.BurgerKingBean" scope="request"></jsp:useBean>
<jsp:useBean id="beverage" class="com.kabank.mvc.domain.BurgerKingBean" scope="request"></jsp:useBean>
<jsp:useBean id="coffee" class="com.kabank.mvc.domain.BurgerKingBean" scope="request"></jsp:useBean>
<jsp:useBean id="salad" class="com.kabank.mvc.domain.BurgerKingBean" scope="request"></jsp:useBean>
<jsp:useBean id="bagel" class="com.kabank.mvc.domain.BurgerKingBean" scope="request"></jsp:useBean>
<jsp:useBean id="sides" class="com.kabank.mvc.domain.BurgerKingBean" scope="request"></jsp:useBean>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<%
	List<BurgerKingBean> list = new ArrayList<>();
	String place = request.getParameter("place");
	int temp = 0;
	String total = "";

	hamburger.setMenu("햄버거");
	hamburger.setPrice(request.getParameter("hamburger"));
	hamburger.setCount(request.getParameter("hamburger_count"));
	beverage.setMenu("음료");
	beverage.setPrice(request.getParameter("beverage"));
	beverage.setCount(request.getParameter("beverage_count"));
	coffee.setMenu("커피");
	coffee.setPrice(request.getParameter("coffee"));
	coffee.setCount(request.getParameter("coffee_count"));
	salad.setMenu("샐러드");
	salad.setPrice(request.getParameter("salad"));
	salad.setCount(request.getParameter("salad_count"));
	bagel.setMenu("베이글");
	bagel.setPrice(request.getParameter("bagel"));
	bagel.setCount(request.getParameter("bagel_count"));
	sides.setMenu("사이드");
	sides.setPrice(request.getParameter("sides"));
	sides.setCount(request.getParameter("sides_count"));
	
	list.add(hamburger);
	list.add(beverage);
	list.add(sides);
	list.add(coffee);
	list.add(salad);
	list.add(bagel);
%>
<div id="wrapper">
<section>
	<article>
		<%=place %><br/>
	<%
		for(BurgerKingBean s: list){
			if(!s.getCount().equals("")){
		%>
				<%=s %><br />
		<%
				temp += Integer.parseInt(s.getPrice()) * Integer.parseInt(s.getCount());
			}
		}
			if(place.equalsIgnoreCase("테이크아웃")){
			temp = temp - 1000;
		}
			total = String.valueOf(temp);
		%>
		총 가격 : <%="￦"+total %>원
	</article>
</section>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
	<script src="../../../resources/js/burgerking.js"></script>
</html>