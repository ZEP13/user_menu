package com.zela.app.menu.actions;

import com.zela.app.exceptions.UserException;
import com.zela.app.menu.MenuAction;
import com.zela.app.models.User;
import com.zela.app.services.servicesImplementations.UserService;

public class UpdateUser extends MenuAction {

    private UserService serv;

    public UpdateUser(UserService serv) {

        super("Update un utilisateur grace a son id");
        this.serv = serv;
    }

    public void execute() {

        User user = getIdUserDetails(serv, "mettre a jour");
        if (user == null)
            return;

        User updatedDetails = askUserDetails(user);
        updatedDetails.setId(user.getId());

        String confirm = ask(
                "Confirmer la mise a jour de l'utilisateur avec l'id " + user.getId() + " par "
                        + updatedDetails.getNom() + " "
                        + updatedDetails.getPrenom()
                        + " ? (o/n) : ");

        if (confirm.isBlank() || confirm.equalsIgnoreCase("o")) {
            try {

                User updatedUser = serv.update(updatedDetails);
                System.out.println("User mis a jour:" + updatedUser.getPrenom() + " " + updatedUser.getNom());
            } catch (UserException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        } else {
            System.out.println("Mise a jour de l'utilisateur annule.");
        }

    }
}
