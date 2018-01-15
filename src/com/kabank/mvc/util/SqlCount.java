package com.kabank.mvc.util;

import com.kabank.mvc.command.InitCommand;

public class SqlCount {
	public String columnCount(String[] info) {
		String res = "";
		char strAscii = 33;
		String[] column = InitCommand.cmd.getColumn().split("/");
		for(int i = 0; i < info.length; i = i + 2) {
			if(!(info[i].equals("null"))) {
				res += column[i].split("_")[1] + "=" + "'" + (strAscii++) + "'";
				if(i < info.length - 1) {
					res += ",";
				}
			}
		}
		return res;
	}
}
