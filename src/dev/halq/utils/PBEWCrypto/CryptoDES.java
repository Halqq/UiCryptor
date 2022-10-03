package dev.halq.utils.PBEWCrypto;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;

public class CryptoDES {
    Cipher ecipher;
    Cipher dcipher;
    // 8-byte Salt


    public static void doCrypto(int mode, File inputFile, File outputFile) {
        try {

            byte[] key = new byte[8];
            SecretKeySpec newKey = new SecretKeySpec(key, "DES");


            Cipher ecipher = Cipher.getInstance("DES");

            ecipher.init(mode,newKey);

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
    }
}
