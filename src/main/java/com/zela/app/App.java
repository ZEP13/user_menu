package com.zela.app;

import com.zela.app.connection_db.DbConfig;
import com.zela.app.menu.Menu;
import com.zela.app.menu.actions.AddUser;
import com.zela.app.menu.actions.AllUser;
import com.zela.app.menu.actions.DeleteUser;
import com.zela.app.menu.actions.ExitMenu;
import com.zela.app.menu.actions.UpdateUser;
import com.zela.app.repositories.JdbcImplementation.JdbcUserRepository;
import com.zela.app.services.servicesImplementations.UserService;

public class App {
    public static void main(String[] args) {

        try {

            DbConfig dbConfig = DbConfig.fromResource("db.properties");
            JdbcUserRepository repo = new JdbcUserRepository(dbConfig);
            UserService userService = new UserService(repo);

            Menu menu = new Menu();

            menu.addAction(new AddUser(userService));
            menu.addAction(new AllUser(userService));
            menu.addAction(new DeleteUser(userService));
            menu.addAction(new UpdateUser(userService));
            menu.addAction(new ExitMenu());

            menu.displayMenu();
            menu.handleUserChoice();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
