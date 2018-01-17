package com.kabank.mvc.factory;

public class PropertiesFactory {
	public static String create(Object[] o) {
		String properties = "";
		for(int i = 0; i < o.length; i++) {
			properties += (i==(o.length-1)) ? o[i] : o[i] + ",";
		}
		System.out.println("properties : " + properties);
		return properties;
	}
}
