package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.constants.Path;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;

@WebServlet({"/user/login.do", "/user/join.do", "/user/auth.do", "/user/confirm.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberServiceImpl();
		MemberBean param = null;
		String dir = request.getServletPath().split(Path.SEPARATOR)[1];
		String action = request.getServletPath().split(Path.SEPARATOR)[2].split(Path.DOT)[0];
		String dest = "";
		HttpSession session = request.getSession();
		switch(action) {
			case "auth":
				param = new MemberBean();
				param.setId(request.getParameter("id"));
				param.setPw(request.getParameter("pw"));
				MemberBean member = service.findMemberById(param);
				if(member != null) {
					dir = "bitcamp";
					dest = "main";
					session.setAttribute("user", member);
				} else {
					dest = "login";
				}
				break;
			case "confirm":
				param = new MemberBean();
				param.setId(request.getParameter("id"));
				param.setPw(request.getParameter("pw"));
				param.setName(request.getParameter("name"));
				param.setSsn(request.getParameter("ssn_head") + "-" + request.getParameter("ssn_tail"));
				param.setPhone(request.getParameter("phone_head") + "-" + request.getParameter("phone_mid") + "-" + request.getParameter("phone_tail"));
				param.setEmail(request.getParameter("email") + "@" + request.getParameter("email_dot"));
				param.setProfile(request.getParameter("profile"));
				param.setAddr(request.getParameter("addr") + " " + request.getParameter("addr_detail"));
				service.join(param);
				dest = "login";
				break;
			case "join":
				dest = action;
				break;
			case "login":
				dest = action;
				break;
		}
		request.getRequestDispatcher(Path.VIEW + dir + Path.SEPARATOR + dest + Path.EXTENSION).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
