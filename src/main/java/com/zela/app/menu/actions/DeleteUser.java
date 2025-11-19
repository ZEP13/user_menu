package com.zela.app.menu.actions;

import java.util.Scanner;

import com.zela.app.menu.MenuAction;
import com.zela.app.menu.ScannerInstance;
import com.zela.app.models.User;
import com.zela.app.services.servicesImplementations.UserService;

public class DeleteUser extends MenuAction {
    private UserService serv;

    public DeleteUser(UserService serv) {
        super("Delete un utilisateur");
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

        String comfirm = ask("Confirmer la suppression de l'utilisateur avec l'id " + id + " ? (o/n) : ");
        if (comfirm.isBlank() || comfirm.equalsIgnoreCase("o")) {
            try {

                serv.deleteById(id);
                System.out.println("Utilisateur avec l'id " + id + " supprime avec succes !");
            } catch (Exception e) {
                System.out.println("Erreur lors de la suppression de l'utilisateur: " + e.getMessage());
            }
        } else {
            System.out.println("Suppression de l'utilisateur annule.");
        }
    }
}
