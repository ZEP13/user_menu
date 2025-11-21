package com.zela.app.menu.actions;

import java.util.Scanner;

import com.zela.app.exceptions.UserException;
import com.zela.app.menu.MenuAction;
import com.zela.app.menu.ScannerInstance;
import com.zela.app.models.User;
import com.zela.app.services.servicesImplementations.UserService;

public class AddUser extends MenuAction {

    private UserService serv;

    public AddUser(UserService serv) {
        super("Ajoute un utilisateur");
        this.serv = serv;
    }

    @Override
    public void execute() {
        User user = askUserDetails(null);

        String comfirm = ask(
                "Confirmer l'ajout de l'utilisateur " + user.getNom() + " " + user.getPrenom() + " ? (o/n) : ");

        if (comfirm.isBlank() || comfirm.equalsIgnoreCase("o")) {
            try {
                serv.save(new User(user.getNom(), user.getPrenom()));
                System.out.println("Utilisateur " + user.getNom() + " " + user.getPrenom() + " ajoute avec succes !");
            } catch (UserException e) {
                System.out.println("Erreur : " + e.getMessage());
            }

        } else

        {
            System.out.println("Ajout de l'utilisateur annule.");
        }
    }

}
