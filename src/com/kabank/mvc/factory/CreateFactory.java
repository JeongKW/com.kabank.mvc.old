package com.kabank.mvc.factory;

public class CreateFactory {
	public static String createCustomNum() {
		return String.valueOf((int)(Math.random() * 10000) + 1000);
	}
	public static String createAccountNum() {
		String resAccountNum = "";
		for(int i = 0; i < 3; i++) {
			int num = (int)(Math.random() * 10000) + 1000;
			resAccountNum += num;
			if(i != 2) {
				resAccountNum += "-";
			}
		}
		return resAccountNum;
	}
}
