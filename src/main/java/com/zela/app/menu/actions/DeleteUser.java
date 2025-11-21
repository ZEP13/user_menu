package com.zela.app.menu.actions;

import com.zela.app.exceptions.UserException;
import com.zela.app.menu.MenuAction;
import com.zela.app.models.User;
import com.zela.app.services.servicesImplementations.UserService;

public class DeleteUser extends MenuAction {
    private UserService serv;

    public DeleteUser(UserService serv) {
        super("Delete un utilisateur");
        this.serv = serv;
    }

    public void execute() {
        User user = getIdUserDetails(serv, "supprimer");
        if (user == null)
            return;

        String comfirm = ask("Confirmer la suppression de l'utilisateur avec l'id " + user.getId() + " ? (o/n) : ");
        if (comfirm.isBlank() || comfirm.equalsIgnoreCase("o")) {
            try {

                serv.deleteById(user.getId());
                System.out.println("Utilisateur avec l'id " + user.getId() + " supprime avec succes !");
            } catch (UserException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        } else {
            System.out.println("Suppression de l'utilisateur annule.");
        }
    }
}
