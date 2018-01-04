<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kabank.mvc.domain.LottoBean" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="../common/head.jsp" %>
<%@ include file="../common/nav.jsp" %>
<%!
	public int countRow(String money){
		return Integer.parseInt(money) / 1000;
	}
	public List<LottoBean> createLottos(int count){
		List<LottoBean> list = new ArrayList<>();
		LottoBean lb = null;
		String res = "";
		for(int i = 0; i < count && i < 5; i++){
			lb = new LottoBean();
			lb.setLottoNum(createLotto());
			list.add(lb);
		}
		return list;
	}
	public String createLotto(){
		String lotto = "";
		int[] lottoInt = new int[6];
		for(int i = 0; i < 6; i++){
			lottoInt[i] = (int)(Math.random() * 45) + 1;
			for(int j = 0; j < i; j++){
				if(lottoInt[i] == lottoInt[j]){
					i--;
					break;
				}
			}
		}
		Arrays.sort(lottoInt);
		for(int i = 0; i < 6; i++){
			lotto += lottoInt[i] + " ";
		}
		return lotto;
	}
%>
	<section>
		<article>
			<%
			int count = countRow(request.getParameter("money"));
			String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss\n").format(new Date());
			%>
				<%=date %><br />
			<%
				for(LottoBean lot : createLottos(count)){
			%>
					<%=lot %><br />
			<%
				}
			%>		
		</article>
	</section>
	<aside></aside>
<%@ include file="../common/footer.jsp" %>