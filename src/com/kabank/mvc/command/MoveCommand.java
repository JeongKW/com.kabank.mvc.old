package com.kabank.mvc.command;

import com.kabank.mvc.enums.Action;

public class MoveCommand extends Command{
	public MoveCommand(String dir, String page, Action action) {
		setDir(dir);
		setPage(page);
		setAction(action);
		excute();
	}
}
