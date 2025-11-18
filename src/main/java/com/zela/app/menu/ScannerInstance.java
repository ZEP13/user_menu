package com.zela.app.menu;

import java.util.Scanner;

public final class ScannerInstance {

    private static Scanner INSTANCE;

    private ScannerInstance() {
    }

    public static Scanner getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Scanner(System.in);
        }
        return INSTANCE;
    }
}
