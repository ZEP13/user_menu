package com.zela.app.menu.actions;

import java.util.Scanner;

import com.zela.app.menu.MenuAction;
import com.zela.app.menu.ScannerInstance;
import com.zela.app.models.User;
import com.zela.app.services.servicesImplementations.UserService;

public class AddUser extends MenuAction {

    private UserService serv;

    public AddUser() {
        super("Ajoute un utilisateur");
    }

    public AddUser(UserService serv) {
        super("Ajoute un utilisateur");
        this.serv = serv;
    }

    @Override
    public void execute() {
        Scanner sc = ScannerInstance.getInstance();
        System.out.println("Entre le prenom");
        String prenom = sc.nextLine();
        System.out.println("Entre le nom");
        String nom = sc.nextLine();

        serv.save(new User(nom, prenom));
    }

}
