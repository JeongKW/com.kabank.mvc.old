package com.kabank.mvc.util;

import com.kabank.mvc.util.Enums.MembersColumn;

public class MainTest {
	public static void main(String[] args) {
		MembersColumn[] values = Enums.MembersColumn.values();
		System.out.println(values[1]);
		for(Enums.MembersColumn c : Enums.MembersColumn.values()) {
			if(c.ordinal() == 1) {
				System.out.println(c);
			}
		}
	}
}
