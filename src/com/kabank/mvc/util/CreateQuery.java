package com.kabank.mvc.util;

public class CreateQuery {
	public static String createAccountNum() {
		String resAccountNum = "";
		for(int i = 0; i < 3; i++) {
			int num = (int)(Math.random() * 9000) + 1000;
			resAccountNum += num;
			if(i != 2) {
				resAccountNum += "-";
			}
		}
		return resAccountNum;
	}
}
