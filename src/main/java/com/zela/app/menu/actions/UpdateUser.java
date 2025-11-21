package com.zela.app.menu.actions;

import java.util.Scanner;

import com.zela.app.exceptions.UserException;
import com.zela.app.menu.MenuAction;
import com.zela.app.menu.ScannerInstance;
import com.zela.app.models.User;
import com.zela.app.services.servicesImplementations.UserService;

public class UpdateUser extends MenuAction {

    private UserService serv;

    public UpdateUser(UserService serv) {

        super("Update un utilisateur grace a son id");
        this.serv = serv;
    }

    public void execute() {
        Scanner sc = ScannerInstance.getInstance();
        System.out.println("Entre l'Id de l'utilisateur que vous souhaite supprime");
        int id = Integer.parseInt(sc.nextLine());

        User user = serv.findById(id);
        if (user == null) {
            System.out.println("Utilisateur avec l'id " + id + " non trouve !");
            return;
        }
        System.out.println("Utilisateur trouve: " + user.getPrenom() + " " + user.getNom());

        System.out.println("Entre le nom modifier");
        String nom_edit = sc.nextLine();
        System.out.println("Entre le prenom modifier");
        String prenom_edit = sc.nextLine();

        if (nom_edit.isEmpty()) {
            nom_edit = user.getNom();
        }
        user.setNom(nom_edit);

        if (prenom_edit.isEmpty()) {
            prenom_edit = user.getPrenom();
        }
        user.setPrenom(prenom_edit);

        String confirm = ask(
                "Confirmer la mise a jour de l'utilisateur avec l'id " + id + " par " + nom_edit + " " + prenom_edit
                        + " ? (o/n) : ");

        if (confirm.isBlank() || confirm.equalsIgnoreCase("o")) {
            try {

                User updatedUser = serv.update(user);
                System.out.println("User mis a jour:" + updatedUser.getPrenom() + " " + updatedUser.getNom());
            } catch (UserException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        } else {
            System.out.println("Mise a jour de l'utilisateur annule.");
        }

    }
}
