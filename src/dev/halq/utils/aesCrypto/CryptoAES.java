package dev.halq.utils.aesCrypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class CryptoAES {

    private static final String algo = "AES";
    private static final String transformation = "AES";


    public static void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        System.out.println("[UiCryptor] AES " + "Loading key");
        Key secretKey = new SecretKeySpec(key.getBytes(), transformation);
        Cipher cipher = Cipher.getInstance(algo);

        System.out.println("[UiCryptor] AES " + "Loading cipher");

        System.out.println("[UiCryptor] AES " + "Initialize cipher!");


        cipher.init(cipherMode, secretKey);

        FileInputStream inputStream = new FileInputStream(inputFile);
        System.out.println("[UiCryptor] AES " + "Loading InputStream");

        byte[] inputBytes = new byte[(int) inputFile.length()];
        System.out.println("[UiCryptor] AES " + "Reading file");

        inputStream.read(inputBytes);
        System.out.println("[UiCryptor] AES " + "Reading Bytes");

        byte[] outputBytes = cipher.doFinal(inputBytes);
        System.out.println("[UiCryptor] AES " + "Reading inputBytes");


        FileOutputStream outputStream = new FileOutputStream(outputFile);
        System.out.println("[UiCryptor] AES " + "Loading output file");

        outputStream.write(outputBytes);
        System.out.println("[UiCryptor] AES " + "Writing bytes");


        inputStream.close();
        outputStream.close();
        System.out.println("[UiCryptor] AES " + "Success! outputing file!!");

    }
}
