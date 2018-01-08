<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.kabank.mvc.domain.AttendBean"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<div id="bitwrapper">
	<section>
		<table id="bitcamp_profile">
			<tr>
				<td id="profile_photo" rowspan="4"><img id="profile_img" src="${pageContext.request.contextPath}/resources/img/default_profile.jpg" alt="" /></td>
				<td class="profile_attr">ID</td>
				<td class="profile_info">${sessionScope.user.id}</td>
				<td class="profile_attr">생년월일</td>
				<td class="profile_info">
					<c:set var="checks" value="${sessionScope.user.ssn }"/>
					<c:set var="check_array" value="${fn:split(checks,'-')}"/>
					${check_array[0] }
				</td>
			</tr>
			<tr>
				<td class="profile_attr">PW</td>
				<td class="profile_info"></td>
				<td class="profile_attr">h.p</td>
				<td class="profile_info">${sessionScope.user.phone }</td>
			</tr>
			<tr>
				<td class="profile_attr">이름</td>
				<td class="profile_info">${sessionScope.user.name }</td>
				<td class="profile_attr">이메일</td>
				<td class="profile_info">${sessionScope.user.email }</td>
			</tr>
			<tr>
				<td class="profile_attr">성별</td>
				<td class="profile_info">
					<c:set var="tail_first" value="${fn:substring(check_array[1], 0, 1)}"/>
					<c:choose>
						<c:when test="${tail_first eq '1'}">
							남
						</c:when>
						<c:when test="${tail_first eq '3'}">
							남
						</c:when>
						<c:when test="${tail_first eq '2'}">
							여
						</c:when>
						<c:when test="${tail_first eq '4'}">
							여
						</c:when>
					</c:choose>
				</td>
				<td class="profile_attr">주소</td>
				<td class="profile_info">${sessionScope.user.addr }</td>
			</tr>
		</table>
	</section>
	<section>
		<form id="bit_main_form" action="result.jsp">
		<table id="bitmain_table">
			<tr>
				<th></th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
			</tr>
			<tr>
				<td>결석</td>
				<td><input type="radio" name="monday" value="absent" checked/></td>
				<td><input type="radio" name="tuesday" value="absent" checked/></td>
				<td><input type="radio" name="wednesday" value="absent" checked/></td>
				<td><input type="radio" name="thursday" value="absent" checked/></td>
				<td><input type="radio" name="friday" value="absent" checked/></td>				
			</tr>
			<tr>
				<td>지각</td>
				<td><input type="radio" name="monday" value="late" /></td>
				<td><input type="radio" name="tuesday" value="late" /></td>
				<td><input type="radio" name="wednesday" value="late" /></td>
				<td><input type="radio" name="thursday" value="late" /></td>
				<td><input type="radio" name="friday" value="late" /></td>
			</tr>
			<tr>
				<td>조퇴</td>
				<td><input type="radio" name="monday" value="early_leave"/></td>
				<td><input type="radio" name="tuesday" value="early_leave"/></td>
				<td><input type="radio" name="wednesday" value="early_leave"/></td>
				<td><input type="radio" name="thursday" value="early_leave"/></td>
				<td><input type="radio" name="friday" value="early_leave"/></td>

			</tr>
			<tr>
				<td>출석</td>
				<td><input type="radio" name="monday" value="attend"/></td>
				<td><input type="radio" name="tuesday" value="attend"/></td>
				<td><input type="radio" name="wednesday" value="attend"/></td>
				<td><input type="radio" name="thursday" value="attend"/></td>
				<td><input type="radio" name="friday" value="attend"/></td>
			</tr>
			<tr>
				<td>결과</td>
				<td><input type="text" name="result" /> </td>
				<td><input type="text" name="result" /> </td>
				<td><input type="text" name="result" /> </td>
				<td><input type="text" name="result" /> </td>
				<td><input type="text" name="result" /> </td>
			</tr>
			<tr>
				<td colspan="6">
					<button id="attend_result">확 인</button>
				</td>
			</tr>
		</table>
		</form>
	</section>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>