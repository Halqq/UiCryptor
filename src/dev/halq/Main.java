package dev.halq;

import dev.halq.ui.UiMain;

import java.io.IOException;

/**
 * @author Halqq
 * @since 02/10/2022
 */

public class Main {

    public static String version = "0.0.5";

    public static void main(String[] args) throws IOException {
        UiMain.main();
        System.out.println("[UiCryptor] " + "Welcome to UiCryptor! crypto tool for files with algorithms AES, DES, RC2, BLOWFISH encryption!");
        System.out.println("[UiCryptor] " + "Made by Halq");
        System.out.println("[UiCryptor] AES " + "Use Encrypt 216-key");
    }
}
