<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<div id="bitwrapper">
	<section>
		<form id="bit_main_form" action="#">
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
			</table>
				<input type="hidden" name="cmd" value="move"/>
				<input type="hidden" name="page" value="changepw"/>
				<input type="hidden" name="dir" value="user"/>
		</form>
		<button id="attend_result">확 인</button>
	
	</section>
</div>
<%@ include file="../common/footer.jsp" %>
<script>
	
</script>
</html>