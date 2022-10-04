package dev.halq.utils.aesCrypto;

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

public class DecryptAES {

    public static void decrypt(String key, File inputFile, File outputFile) throws IOException, InterruptedException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        TimeUnit.SECONDS.sleep(2);
        System.out.println("[UiCryptor] AES " + "Loading Decryptor");
        CryptoAES.doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
        System.out.println("[UiCryptor] AES " + "Cipher set mode DECRYPT_MODE");
        System.out.println("[UiCryptor] AES " + "Decrypt key : " + key);
        TimeUnit.SECONDS.sleep(2);

    }
}
