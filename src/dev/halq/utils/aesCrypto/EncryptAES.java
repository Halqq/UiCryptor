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

public class EncryptAES {

    public static void encrypt(String key, File inputFile, File outputFile) throws IOException, InterruptedException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        TimeUnit.SECONDS.sleep(1);
        System.out.println("[UiCryptor] AES " + "Loading encryptor");
        CryptoAES.doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
        System.out.println("[UiCryptor] AES " + "Cipher set mode ENCRYPT_MODE");
        System.out.println("[UiCryptor] AES " + "Encrypt key : " + key);
        TimeUnit.SECONDS.sleep(2);

    }
}
