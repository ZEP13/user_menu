package com.zela.app.menu.actions;

import java.util.Scanner;

import com.zela.app.menu.MenuAction;
import com.zela.app.menu.ScannerInstance;
import com.zela.app.services.servicesImplementations.UserService;

public class DeleteUser extends MenuAction {
    private UserService serv;

    public DeleteUser() {
        super("Delete un utilisateur");
    }

    public DeleteUser(UserService serv) {
        super("Ajoute un utilisateur");
        this.serv = serv;
    }

    public void execute() {
        Scanner sc = ScannerInstance.getInstance();
        System.out.println("Entre l'Id de l'utilisateur que vous souhaite supprime");
        int id = Integer.parseInt(sc.nextLine());

        serv.deleteById(id);
    }
}
