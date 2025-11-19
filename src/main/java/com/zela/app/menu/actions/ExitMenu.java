package com.zela.app.menu.actions;

import com.zela.app.menu.MenuAction;
import com.zela.app.menu.ScannerInstance;

public class ExitMenu extends MenuAction {

    public ExitMenu() {
        super("Quite le menu");
    }

    @Override
    public void execute() {
        String confirm = ask("Es-tu sur de vouloir quitter ? (o/n) : ");

        if (confirm.isBlank() || confirm.equalsIgnoreCase("o")) {
            ScannerInstance.getInstance().close();
            System.exit(0);
        } else {
            System.out.println("Fermeture du menu...");
        }
    }
}
