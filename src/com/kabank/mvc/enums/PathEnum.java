package com.kabank.mvc.enums;

public enum PathEnum {
	VIEW("/WEB-INF/view/"),
	SEPARATOR("/"),
	EXTENSION(".jsp"),
	DOT("\\.")
	;
	private final String value;
	private PathEnum(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}	
}
