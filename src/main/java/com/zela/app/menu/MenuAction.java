package com.zela.app.menu;

public abstract class MenuAction {
    private final String name;

    public MenuAction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute();
}
