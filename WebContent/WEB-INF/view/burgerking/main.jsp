<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<section>
	<article>
		<hgroup>
			<h1>버거킹 주문 화면</h1>
			<h6>상품과 수량을 선택해 주세요</h6>
		</hgroup>
		<div id="wrapper">
		<form id="order_form" action="result.jsp">
		<table>
			<tr>
				<td>
					<figure>
						<img src="${pageContext.request.contextPath}/resources/img/Hamburger.jpg" style="width: 150px; height: 150px;"	 alt="햄버거" /><br/>
						<figcaption>
								<input type="checkbox" name="menu" value="hamburger" /> 햄버거 : ￦ 5,500<br/>
								<input type="text" style="width: 20px" name="hamburger_count" min="1" max="9" /> 개
						</figcaption>
					</figure>
				</td>
				<td>
					<figure>
						<img src="${pageContext.request.contextPath}/resources/img/Beverages.jpg" style="width: 150px; height: 150px;" alt="음료" /><br/>
						<figcaption>
							<input type="checkbox" name="menu" value="beverages" /> 음료 : ￦ 1,000<br/>
							<input type="text" style="width: 20px" name="beverage_count" min="1" max="9" /> 개						
						</figcaption>
					</figure>
				</td>
				<td>
					<figure>
					<img src="${pageContext.request.contextPath}/resources/img/Sides.jpg" style="width: 150px; height: 150px;" alt="사이드" /><br/>
						<figcaption>
							<input type="checkbox" name="menu" value="sides" /> 사이드 : ￦ 1,000<br/>
							<input type="text" style="width: 20px" name="sides_count" min="1" max="9" /> 개						
						</figcaption>
					</figure>
				</td>
			</tr>
			<tr>
				<td>
					<figure>
						<img src="${pageContext.request.contextPath}/resources/img/Coffee.jpg" style="width: 150px; height: 150px;" alt="커피" /><br/>
						<figcaption>
							<input type="checkbox" name="menu" value="coffee" /> 커피 : ￦ 900<br/>
							<input type="text" style="width: 20px" name="coffee_count" min="1" max="9" /> 개			
						</figcaption>
					</figure>
				</td>
				<td>
					<figure>
						<img src="${pageContext.request.contextPath}/resources/img/Salad.jpg" style="width: 150px; height: 150px;" alt="샐러드" /><br/>
						<figcaption>
							<input type="checkbox" name="menu" value="salad" /> 샐러드 : ￦ 3,000<br/>
							<input type="text" style="width: 20px" name="salad_count" min="1" max="9" /> 개
						</figcaption>
					</figure>
				</td>
				<td>
					<figure>
						<img src="${pageContext.request.contextPath}/resources/img/Bagel.jpg" style="width: 150px; height: 150px;" alt="베이글" /><br/>					
						<figcaption>
							<input type="checkbox" name="menu" value="bagel" /> 베이글 : ￦ 4,000<br/>
							<input type="text" style="width: 20px" name="bagel_count" min="1" max="9" /> 개						
						</figcaption>
					</figure>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td colspan="2">
					<input type="radio"name="place" value="매장식사" checked="checked" />
					매장식사
					<input type="radio" name="place" value="테이크아웃" />
					테이크아웃
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name="hamburger" value="5500" />
					<input type="hidden" name="beverage" value="1000" />
					<input type="hidden" name="sides" value="1000" />
					<input type="hidden" name="coffee" value="900" />
					<input type="hidden" name="bagel" value="4000" />
					<input type="hidden" name="salad" value="3000" />
				</td>
				<td style="border: 0">
					<input id="burgerking_order_btn" type="button" value="주문" style="width: 100px"/>
				</td>
			</tr>
		</table>
	</form>	
</div>
	</article>
</section>
<%@ include file="../common/footer.jsp" %>
</body>
<script src="../../resources/js/burgerking/burgerking.js"></script>
</html>