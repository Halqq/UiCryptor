package dev.halq;

import dev.halq.ui.UiMain;

/**
 * @author Halq
 * @since 02/10/2022
 */

public class Main {

    public static String version = "0.0.1";

    public static void main(String[] args){
        UiMain.renderGui();
        System.out.println("[UiCryptor] " + "Welcome to UiCryptor!, this encrypt files with AES encryption");
        System.out.println("[UiCryptor] " + "Made by Halq");
        System.out.println("[UiCryptor] " + "Use Encrypt 216-key");
    }
}
