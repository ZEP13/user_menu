package com.zela.app.menu.actions;

import java.util.Scanner;

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
        Scanner sc = ScannerInstance.getInstance();
        System.out.println("Entre le prenom");
        String prenom = sc.nextLine();
        System.out.println("Entre le nom");
        String nom = sc.nextLine();

        String comfirm = ask("Confirmer l'ajout de l'utilisateur " + nom + " " + prenom + " ? (o/n) : ");

        if (comfirm.isBlank() || comfirm.equalsIgnoreCase("o")) {
            try {
                serv.save(new User(nom, prenom));
                System.out.println("Utilisateur " + nom + " " + prenom + " ajoute avec succes !");
            } catch (Exception e) {
                System.out.println("Erreur lors de l'ajout de l'utilisateur: " + e.getMessage());
            }
        } else

        {
            System.out.println("Ajout de l'utilisateur annule.");
        }
    }

}
