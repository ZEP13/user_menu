package com.zela.app;

import com.zela.app.menu.Menu;
import com.zela.app.menu.actions.AddUser;

public class App {
    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.addAction(new AddUser());

        menu.displayMenu();
        menu.handleUserChoice();
    }
}
