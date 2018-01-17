package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		Action action = null;
		if(x == null) { x = "move"; }
		switch(x) {
		case "move": action = Action.MOVE; break;
		case "login": action = Action.LOGIN; break;
		case "change": action = Action.CHANGE; break;
		case "delete": action = Action.DELETE; break;
		case "join": action = Action.JOIN; break;
		case "test": action = Action.TEST; break;
		case "create": action = Action.CREATE; break;
		default:
			action = Action.MOVE;
			break;
		}
		return action;
	}
}
