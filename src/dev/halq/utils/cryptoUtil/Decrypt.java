package dev.halq.utils.cryptoUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * @author Halq
 * @since 02/10/2022
 */

public class Decrypt {

    public static void encrypt(String key, File inputFile, File outputFile) throws IOException, InterruptedException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        TimeUnit.SECONDS.sleep(2);
        System.out.println("[UiCryptor] " + "Loading Decryptor");
        Crypto.doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
        System.out.println("[UiCryptor] " + "Cipher set mode DECRYPT_MODE");

    }
}
