package dev.halq;

import dev.halq.ui.UiMain;

/**
 * @author Halqq
 * @since 02/10/2022
 */

public class Main {

    public static String version = "0.0.3";

    public static void main(String[] args) {
        //UiMain.main();
        UiMain.main();
        System.out.println("[UiCryptor] " + "Welcome to UiCryptor!, this encrypt files with AES, DES encryption!");
        System.out.println("[UiCryptor] " + "Made by Halq");
        System.out.println("[UiCryptor] AES " + "Use Encrypt 216-key");
    }
}
