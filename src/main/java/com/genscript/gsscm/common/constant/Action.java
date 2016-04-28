package com.genscript.gsscm.common.constant;

public enum Action {

    PRICE("price"), POINT("point");

    private final String value;

    Action(String s) {
        value = s;
    }

    public String value() {
        return value;
    }

    public static Action getAction(String s) {
        Action[] values = Action.values();
        for (Action action : values) {
            if (action.value.equals(s)) {
                return action;
            }
        }
        return null;
    }
}
