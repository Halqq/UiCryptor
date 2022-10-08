package dev.halq;

import dev.halq.ui.UiMain;
import dev.halq.utils.textEncrypt.EncryptRCZ;

/**
 * @author Halqq
 * @since 02/10/2022
 */

public class Main {

    public static String version = "0.0.7";

    public static void main(String[] args) throws Exception {

        byte[] bytes = "a".getBytes();

        UiMain.main();
        System.out.println("[UiCryptor] " + "Welcome to UiCryptor! crypto tool for files with algorithms AES, DES, RC2, BLOWFISH, Base64, RCZ encryption!");
        System.out.println("[UiCryptor] " + "Made by Halq");
        System.out.println("[UiCryptor] AES " + "Use Encrypt 216-key");
    }
}
