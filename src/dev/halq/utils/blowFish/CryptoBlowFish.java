package dev.halq.utils.blowFish;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CryptoBlowFish {

    public static void doCrypto(int mode, File inputFile, File outputFile, byte[] key) {
        try {

            SecretKeySpec newKey = new SecretKeySpec(key, "Blowfish");

            Cipher ecipher = Cipher.getInstance("Blowfish");

            ecipher.init(mode, newKey);

            FileInputStream inputStream = new FileInputStream(inputFile);

            byte[] inputBytes = new byte[(int) inputFile.length()];

            inputStream.read(inputBytes);

            byte[] outputBytes = ecipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);

            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();

        }
    }}
