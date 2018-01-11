package com.kabank.mvc.command;

import com.kabank.mvc.enums.Action;

public class Command implements Order{
	protected String dir, page, search, column;
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	protected Action action;

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = (page == null) ? "login" : page;
	}

	@Override
	public String excute() {
		return Action.VIEW.toString()
			  + dir
			  + Action.SEPARATOR
			  + page
			  + Action.EXTENSION
			  ;
	}
}
