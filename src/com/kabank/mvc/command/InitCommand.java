package com.kabank.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.factory.ActionFactory;
import com.kabank.mvc.factory.CommandFactory;

public class InitCommand {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request, HttpServletResponse response) {
		String servletPath = request.getServletPath();
		cmd = CommandFactory.create(
				servletPath.substring(1, servletPath.indexOf(".")),
				request.getParameter("page"),
				ActionFactory.create(request.getParameter("cmd")),
				request.getParameter(""),
				request.getParameter("")
				);
	}
}
