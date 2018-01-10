package com.kabank.mvc.util;

import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.enums.MemberEnum;

public class MainTest {
	public static void main(String[] args) {
		StringBuffer res = new StringBuffer(DmlEnum.SELECT.toString());
		System.out.println("기본 버프 : " + res);
		//"SELECT FROM "
		//"01234567891011
		res.insert(12, "Member");
		res.insert(6, MemberEnum.PROPERTIES.toString());
		System.out.println("바뀐 버프 : " + res);
	}
}
