package com.kabank.mvc.util;

public class MainTest {
	public static void main(String[] args) {
		for(Enums.MembersColumn c : Enums.MembersColumn.values()) {
			System.out.println(c + ", ");
		}
	}
}
