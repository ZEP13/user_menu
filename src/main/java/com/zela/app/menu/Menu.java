package com.zela.app.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    List<MenuAction> actions = new ArrayList<>();

    public void addAction(MenuAction action) {
        actions.add(action);
    }

    public void displayMenu() {
        System.out.println("==MENU USER==");
        int i = 1;
        for (MenuAction action : actions) {
            System.out.println(i + ". " + action.getName());
            i++;
        }
    }

    public void handleUserChoice() {
        Scanner scanner = ScannerInstance.getInstance();

        while (true) {
            System.out.println("Faites votre choix :");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice <= 0 || choice > actions.size()) {
                System.out.println("Vous n'avez pas fait votre choix");
            } else {
                MenuAction action = actions.get(choice - 1);
                action.execute();
            }
        }
    }

}
