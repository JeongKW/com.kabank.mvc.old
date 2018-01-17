package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.ChangeCommand;
import com.kabank.mvc.command.DeleteCommand;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.InsertCommand;
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
				System.out.println("----Member-C : Add In----");
				new InsertCommand(request).excute();
				if(InitCommand.cmd.getData().split("/")[1].equals(InitCommand.cmd.getData().split("#")[1])) {
					MemberServiceImpl.getInstance().insertMember();
					InitCommand.cmd.setDir("user");
					InitCommand.cmd.setPage("login");
				} else {
					InitCommand.cmd.setDir("user");
					InitCommand.cmd.setPage("join");
				}
				new MoveCommand(request).excute();
				System.out.println("----Member-C : Add Out----");
				DispatcherServlet.send(request, response);
				break;
			case CHANGE:
				System.out.println("----Member-C : Change In----");
				update(request, session);
				System.out.println("----Member-C : Change Out----");
				DispatcherServlet.send(request, response);
				break;
			case DELETE:
				System.out.println("----Member-C : Delete In----");
				new DeleteCommand(request).excute();
				String[] deleteInfo = InitCommand.cmd.getData().split("/");
				if(deleteInfo[0].equals(deleteInfo[1])) {
					MemberServiceImpl.getInstance().deleteMember();
					InitCommand.cmd.setDir("user");
					InitCommand.cmd.setPage("login");
					session.invalidate();
				} else {
					InitCommand.cmd.setDir("user");
					InitCommand.cmd.setPage("deletemember");
				}
				new MoveCommand(request).excute();
				System.out.println("----Member-C : Delete Out----");
				DispatcherServlet.send(request, response);
				break;
			default: break;
		}
	}

	private void update(HttpServletRequest request, HttpSession session) {
		new ChangeCommand(request).excute();
		String[] info = InitCommand.cmd.getData().split("/");
		if(info[0].equals(info[1])) {
			MemberServiceImpl.getInstance().updateMember();
			MemberBean m = (MemberBean) session.getAttribute("user");
			m.setPw(info[0]);
			session.setAttribute("user", m);
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("mypage");
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
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("mypage");
			session.setAttribute("user", member);
		}
		new MoveCommand(request).excute();
	}
}
