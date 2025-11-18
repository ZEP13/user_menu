package com.zela.app.menu.actions;

import com.zela.app.menu.MenuAction;
import com.zela.app.menu.ScannerInstance;

public class ExitMenu extends MenuAction {

    public ExitMenu() {
        super("Quite le menu");
    }

    @Override
    public void execute() {
        ScannerInstance.getInstance().close();
        System.exit(0);
    }
}
