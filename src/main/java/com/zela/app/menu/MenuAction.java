package com.zela.app.menu;

import com.zela.app.models.User;
import com.zela.app.services.servicesImplementations.UserService;

import java.util.Scanner;

public abstract class MenuAction {
    private final String name;

    public MenuAction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String ask(String question) {
        System.out.print(question);
        return ScannerInstance.getInstance().nextLine();
    }

    public User askUserDetails(User current) {
        Scanner sc = ScannerInstance.getInstance();

        System.out.print("Prénom (" + current.getPrenom() + ") : ");
        String prenom = sc.nextLine();
        if (prenom.isBlank())
            prenom = current.getPrenom();

        System.out.print("Nom (" + current.getNom() + ") : ");
        String nom = sc.nextLine();
        if (nom.isBlank())
            nom = current.getNom();

        return new User(nom, prenom);
    }

    public User getIdUserDetails(UserService serv, String action) {

        Scanner sc = ScannerInstance.getInstance();
        System.out.println("Entre l'Id de l'utilisateur que vous souhaite " + action);

        int id;

        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Id invalide !");
            return null;
        }

        User user = serv.findById(id);
        if (user == null) {
            System.out.println("Utilisateur avec l'id " + id + " non trouve !");
        } else {
            System.out.println("Utilisateur trouve: " + user.getPrenom() + " " + user.getNom());

        }
        return user;
    }

    public abstract void execute();
}
