package com.kabank.mvc.util;

import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.MemberProps;
import com.kabank.mvc.factory.PropertiesFactory;

public class MainTest {
	public static void main(String[] args) {
		System.out.println(DML.SELECT + " "
				+ PropertiesFactory.create(MemberProps.values()) + " "
				+ DML.FROM + " MEMBER "
				+ DML.WHERE
				+ " id LIKE '?' "
				+ DML.AND + " pw LIKE '?'");
	}
}
