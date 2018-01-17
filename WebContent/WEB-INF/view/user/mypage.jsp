<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<div id="wrapper">
	<section>
		<table id="bitcamp_profile">
			<tr>
				<td id="profile_photo" rowspan="5"><img id="profile_img" src="${img}/default_profile.jpg" alt="" /></td>
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
			<tr>
				<td class="profile_attr">계좌번호</td>
				<td class="profile_info">1234-5678-9102</td>
				<td class="profile_attr"></td>
				<td class="profile_info"></td>
			</tr>
		</table>
		<button id="mypage_ch">수 정</button>
		<button id="mypage_rm">탈 퇴</button>
		<button id="mypage_test">테스트</button>
	</section>
</div>
<%@ include file="../common/footer.jsp" %>
<script>
	document.querySelector('#mypage_ch').addEventListener("click", function(){
		location.href = "${ctx}/user.do?cmd=move&page=changepw";
	}, false);
	document.querySelector('#mypage_rm').addEventListener('click', function(){
		location.href = "${ctx}/user.do?cmd=move&page=deletemember";
	}, false);
	document.querySelector('#mypage_test').addEventListener('click', function(){
		location.href = "${ctx}/user.do?cmd=move&page=changepw2";
	}, false);
</script>
</html>