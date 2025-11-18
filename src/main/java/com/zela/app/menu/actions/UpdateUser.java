package com.zela.app.menu.actions;

import java.util.Scanner;

import com.zela.app.menu.MenuAction;
import com.zela.app.menu.ScannerInstance;
import com.zela.app.models.User;
import com.zela.app.services.servicesImplementations.UserService;

public class UpdateUser extends MenuAction {

    private UserService serv;
    private User user;

    public UpdateUser() {
        super("Update un utilisateur grace a son id");
    }

    public UpdateUser(UserService serv, User user) {

        super("Update un utilisateur grace a son id");
        this.serv = serv;
        this.user = user;
    }

    public void execute() {
        Scanner sc = ScannerInstance.getInstance();
        System.out.println("Entre l'Id de l'utilisateur que vous souhaite supprime");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Entre le nom modifier");
        String nom_edit = sc.nextLine();
        System.out.println("Entre le prenom modifier");
        String prenom_edit = sc.nextLine();

        user.setPrenom(prenom_edit);
        user.setNom(nom_edit);
        User updatedUser = serv.update(user);

        System.out.println("User mis a jour:" + updatedUser.getPrenom() + " " + updatedUser.getNom());
    }
}
