package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet({"/user.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberBean member = null;
		HttpSession session = request.getSession();
		InitCommand.init(request, response);
		switch (InitCommand.cmd.getAction()) {
			case MOVE:
				DispatcherServlet.send(request, response); 
				break;
			case SEARCH:
				member = new MemberBean();
				member.setId(request.getParameter("id"));
				member.setPw(request.getParameter("pw"));
				MemberBean result = MemberServiceImpl.getInstance().findMemberById(member);
				if(result == null) {
					InitCommand.cmd.setDir("user");
					InitCommand.cmd.setPage("login");
					InitCommand.cmd.excute();
				} else {
					InitCommand.cmd.setDir(request.getParameter("dir"));
					InitCommand.cmd.setPage(request.getParameter("page"));
					session.setAttribute("user", result);
				}
				DispatcherServlet.send(request, response);
				break;
			default: break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
