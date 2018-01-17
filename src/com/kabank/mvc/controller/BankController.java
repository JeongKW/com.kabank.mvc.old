package com.kabank.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.InsertCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.serviceImpl.BankServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet("/kakao.do")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		InitCommand init = new InitCommand(request);
		init.excute();
		switch(InitCommand.cmd.getAction()) {
		case MOVE:
			System.out.println("----Bank-C : Move In----");
			new MoveCommand(request).excute();
			session.getAttribute("user");
			System.out.println("DEST IS " + InitCommand.cmd.getView());
			System.out.println("----Bank-C : Move Out----");
			DispatcherServlet.send(request, response);
			break;
		case CREATE:
			System.out.println("----Bank-C : Create In----");
			new InsertCommand(request).excute();
			BankServiceImpl.getInstance().createAccount();
			new MoveCommand(request).excute();
			System.out.println("----Bank-C : Create Out----");
			DispatcherServlet.send(request, response);
			break;
			default:
				break;
		}
	}

}
