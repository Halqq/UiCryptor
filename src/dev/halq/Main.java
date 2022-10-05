package dev.halq;

import dev.halq.ui.UiMain;
import dev.halq.utils.base64.Base64Encode;

import java.io.File;
import java.io.IOException;

/**
 * @author Halqq
 * @since 02/10/2022
 */

public class Main {

    public static String version = "0.0.6";

    public static void main(String[] args) throws IOException {
        //UiMain.main();
        System.out.println("[UiCryptor] " + "Welcome to UiCryptor! crypto tool for files with algorithms AES, DES, RC2, BLOWFISH, Base64 encryption!");
        System.out.println("[UiCryptor] " + "Made by Halq");
        System.out.println("[UiCryptor] AES " + "Use Encrypt 216-key");
    }
}
