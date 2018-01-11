<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div id="wrapper">
		<header id="member_header">
			<h1>BIT CAMP SAMPLE PROJECT</h1>
			<hgroup>
				<h1>회원가입!</h1>
				<h2>당신의 소중한 정보를 입력해주세요</h2>
			</hgroup>
		</header>
		<section>
			<article>
				<form id="member_form" action="${pageContext.request.contextPath}/user.do?cmd=add&page=login">
					<table>
						<tr>
							<td id="memtype_td">ID </td>
							<td colspan="2">
								<input id="join_id" name="id" type="text" />
								<button id="check_dupl_btn" name="check_dupl_btn">중복확인</button>
							</td>
						</tr>
						<tr>
							<td id="memtype_td">비밀번호</td>
							<td colspan="2">
								<input id="join_pw" type="password" name="pw" />
							</td>
						</tr>
						<tr>
							<td id="memtype_td">비밀번호확인</td>
							<td colspan="2">
								<input type="password" name="pwch" />
							</td>
						</tr>
						<tr>
							<td id="memtype_td">이름</td>
							<td colspan="2">
								<input type="text" name="name" title="2~4자의 이름을 입력해주세요" />
							</td>
						</tr>
						<tr>
							<td id="memtype_td">주민번호</td>
							<td colspan="2">
								<input style="width: 80px" type="text" name="ssn_head" /> -
								<input style="width: 95px" type="text" name="ssn_tail" />
								<button>인증</button>
							</td>
						</tr>
						<tr>
							<td id="memtype_td" rowspan="2">주소</td>
							<td><input type="text" name="addr" />&nbsp;<button>주소 검색</button></td>
						</tr>
						<tr>
							<td><input type="text" name="addr_detail" /></td>
						</tr>
						<tr>
							<td id="memtype_td">핸드폰번호</td>
							<td>
								<select name="phone_head">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
								</select>
								<input style="width: 80px" type="tel" name="phone_mid" />
								<input style="width: 80px" type="tel" name="phone_tail"/>
							</td>
						</tr>
						<tr>
							<td id="memtype_td">이메일</td>
							<td>
								<input style="width: 100px" type="text" name="email" />&nbsp;@
								<select name="email_dot" id="">
									<option value="naver.com">naver.com</option>
									<option value="nate.com">nate.com</option>
									<option value="hanmail.net">hanmail.net</option>
									<option value="gmail.com">gmail.com</option>
								</select>
							</td>
						</tr>
						<tr>
							<td id="memtype_td">가입일</td>
							<td><input id="datepicker" type="date" /></td>
						</tr>
						<tr>
							<td id="memtype_td">프로필사진</td>
							<td><input type="text" name="profile"/><button>사진 선택</button></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center;"><button id="join_confirm_btn">확인</button>&nbsp;<button>취소</button></td>
						</tr>
					</table>
				</form>
			</article>
			
		</section>
	</div>
<%@ include file="../common/footer.jsp" %>
<script>
	document.querySelector('#join_confirm_btn').addEventListener('click', 
		function () {
			document.querySelect('#join_form').submit();
		}, false);
	
</script>
</html>