package com.kabank.mvc.command;

import com.kabank.mvc.enums.Action;

public class SearchCommand extends Command{
	public SearchCommand(String dir, String page, Action action, String search, String column) {
		setDir(dir);
		setPage(page);
		setAction(action);
		setSearch(search);
		setColumn(column);
		excute();
	}
}
