package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.enums.Action;
import com.kabank.mvc.util.ParamsIterator;

public class MoveCommand implements IOrder{
	
	Map<?, ?> map;
	String servletPath;
	public MoveCommand(HttpServletRequest request) {
		map = ParamsIterator.excute(request);
		servletPath = request.getServletPath();
	}

	@Override
	public void excute() {
		String page = (String.valueOf(map.get("page")).equals("null")) ?
				"login" : String.valueOf(map.get("page"));
		String dir = (String.valueOf(map.get("dir")).equals("null")) ?
				servletPath.substring(1, servletPath.indexOf(".")) : String.valueOf(map.get("dir"));
		InitCommand.cmd.setDir(dir);
		InitCommand.cmd.setPage(page);
		InitCommand.cmd.setView(
				Action.VIEW.toString()
			   +InitCommand.cmd.getDir()
			   +Action.SEPARATOR
			   +InitCommand.cmd.getPage()
			   +Action.EXTENSION);
	}
}
