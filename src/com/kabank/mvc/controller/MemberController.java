package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.constants.Path;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;

@WebServlet({"/user/login.do", "/user/join.do", "/user/auth.do", "/user/confirm.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService service;
	MemberBean m;
	
	public MemberController() {
		service = new MemberServiceImpl();
		m = new MemberBean();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = request.getServletPath().split(Path.SEPARATOR)[1];
		String action = request.getServletPath().split(Path.SEPARATOR)[2].split(Path.DOT)[0];
		String dest = "";
		switch(action) {
			case "auth":
				m.setId(request.getParameter("id"));
				m.setPw(request.getParameter("pw"));
				if(service.login(m) == true) {
					dir = "bitcamp";
					dest = "main";
				} else {
					dest = "login";
				}
				break;
			case "confirm":
				m.setId(request.getParameter("id"));
				m.setPw(request.getParameter("pw"));
				m.setName(request.getParameter("name"));
				m.setSsn(request.getParameter("ssn_head") + "-" + request.getParameter("ssn_tail"));
				m.setPhone(request.getParameter("phone_head") + "-" + request.getParameter("phone_mid") + "-" + request.getParameter("phone_tail"));
				m.setEmail(request.getParameter("email") + "@" + request.getParameter("email_dot"));
				m.setProfile(request.getParameter("profile"));
				m.setAddr(request.getParameter("addr") + " " + request.getParameter("addr_detail"));
				service.join(m);
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
