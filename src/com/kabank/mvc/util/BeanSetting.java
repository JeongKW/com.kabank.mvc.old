package com.kabank.mvc.util;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.domain.MemberBean;

public class BeanSetting {
	public static MemberBean setting(MemberBean m) {
		MemberBean res = m;
		String[] columns = InitCommand.cmd.getColumn().split("/");
		for(int i = 0; i < columns.length; i++) {
			if(!(columns[i].equals("id") || columns[i].equals("pwch"))) {
				
			}
		}
		return res;
		
	}
}
