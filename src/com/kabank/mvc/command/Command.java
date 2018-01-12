package com.kabank.mvc.command;

import com.kabank.mvc.enums.Action;

public class Command{
	protected String cmd, dir, page, view, search, column, data;
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

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

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	
}
