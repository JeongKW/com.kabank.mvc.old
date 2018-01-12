package com.kabank.mvc.util;

import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.enums.TnameEnum;

public class MainTest {
	public static void main(String[] args) {
		System.out.println(DmlEnum.SELECT.toString() + TnameEnum.MEMBER.name() + DmlEnum.MEMBER_LOGIN.toString());
	}
}
