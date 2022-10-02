package dev.halq.utils.cryptoUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

public class Crypto {

    private static String algo = "AES";
    private static String transformation = "AES";


    public static void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
            System.out.println("[UiCryptor] " + "Loading key");
            Key secretKey = new SecretKeySpec(key.getBytes(), transformation);
            Cipher cipher = Cipher.getInstance(algo);

            System.out.println("[UiCryptor] " + "Loading cipher");

            System.out.println("[UiCryptor] " + "Initialize cipher!");


            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            System.out.println("[UiCryptor] " + "Loading InputStream");

            byte[] inputBytes = new byte[(int) inputFile.length()];
            System.out.println("[UiCryptor] " + "Reading file");

            inputStream.read(inputBytes);
            System.out.println("[UiCryptor] " + "Reading Bytes");

            byte[] outputBytes = cipher.doFinal(inputBytes);
            System.out.println("[UiCryptor] " + "Reading inputBytes");


            FileOutputStream outputStream = new FileOutputStream(outputFile);
            System.out.println("[UiCryptor] " + "Loading output file");

            outputStream.write(outputBytes);
            System.out.println("[UiCryptor] " + "Writing bytes");


            inputStream.close();
            outputStream.close();
            System.out.println("[UiCryptor] " + "Success! outputing file!!");

        }
    }
