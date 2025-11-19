package com.zela.app.menu.actions;

import java.util.List;

import com.zela.app.menu.MenuAction;
import com.zela.app.models.User;
import com.zela.app.services.servicesImplementations.UserService;

public class AllUser extends MenuAction {

    private UserService serv;

    public AllUser(UserService serv) {
        super("Voir tout les utilisateurs");
        this.serv = serv;
    }

    @Override
    public void execute() {

        try {
            List<User> users = serv.allUser();
            for (User user : users) {
                System.out.println("ID: " + user.getId() + " | " + " NOM: " + user.getNom() + " | " + " PRENOM: "
                        + user.getPrenom());
            }

        } catch (Exception e) {
            System.out.println("Erreur lors de la recuperation des utilisateurs: " + e.getMessage());
        }

    }
}
