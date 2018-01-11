package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		Action action = null;
		if(x == null) { x = "move"; }
		switch(x) {
		case "move": action = Action.MOVE; break;
		case "login": action = Action.SEARCH; break;
		default:
			break;
		}
		return action;
	}
}
