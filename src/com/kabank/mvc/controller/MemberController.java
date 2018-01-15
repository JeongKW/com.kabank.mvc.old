package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.ChangeCommand;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.LoginCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet({"/user.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		InitCommand init = new InitCommand(request);
		init.excute();
		switch (InitCommand.cmd.getAction()) {
			case MOVE:
				System.out.println("----Member-C : Move In----");
				new MoveCommand(request).excute();
				System.out.println("DEST IS " + InitCommand.cmd.getView());
				System.out.println("----Member-C : Move Out----");
				DispatcherServlet.send(request, response);
				break;
			case ADD:
				System.out.println("----Member-C : Add In----");
				
				System.out.println("----Member-C : Add Out----");
				DispatcherServlet.send(request, response);
				break;
			case LOGIN:
				System.out.println("----Member-C : Login In----");
				login(request, session);
				DispatcherServlet.send(request, response);
				System.out.println("----Member-C : Login Out----");
				break;
			case JOIN:
				
				break;
			case CHANGE:
				System.out.println("----Member-C : Change In----");
				update(request, session);
				System.out.println("----Member-C : Change Out----");
				DispatcherServlet.send(request, response);
				break;
			default: break;
		}
	}

	private void update(HttpServletRequest request, HttpSession session) {
		new ChangeCommand(request, session).excute();
		String[] changePass = InitCommand.cmd.getData().split("/");
		if(changePass[1].equals(changePass[2])) {
			MemberServiceImpl.getInstance().update();
			MemberBean m = (MemberBean) session.getAttribute("user");
			m.setPw(changePass[1]);
			session.setAttribute("user", m);
			InitCommand.cmd.setDir("bitcamp");
			InitCommand.cmd.setPage("main");
		} else {
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("changepw");
		}
		new MoveCommand(request).excute();
	}

	private void login(HttpServletRequest request, HttpSession session) {
		new LoginCommand(request).excute();
		MemberBean member = MemberServiceImpl.getInstance().login();
		if(member == null) {
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("login");
		} else {
			InitCommand.cmd.setDir("bitcamp");
			InitCommand.cmd.setPage("main");
			session.setAttribute("user", member);
		}
		System.out.println(member);
		new MoveCommand(request).excute();
	}
	
}
