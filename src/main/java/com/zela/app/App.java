package com.zela.app;

import com.zela.app.menu.Menu;
import com.zela.app.menu.actions.AddUser;
import com.zela.app.menu.actions.AllUser;
import com.zela.app.menu.actions.DeleteUser;
import com.zela.app.menu.actions.UpdateUser;

public class App {
    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.addAction(new AddUser());
        menu.addAction(new AllUser());
        menu.addAction(new DeleteUser());
        menu.addAction(new UpdateUser());

        menu.displayMenu();
        menu.handleUserChoice();
    }
}
