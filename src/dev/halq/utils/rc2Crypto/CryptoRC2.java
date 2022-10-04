package dev.halq.utils.rc2Crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class CryptoRC2 {

    private static int effectiveKeySize;

    public CryptoRC2() {

        this.effectiveKeySize = effectiveKeySize;
    }

    public static void doCrypto(int mode, File inputFile, File outputFile) {
        try {

            byte[] key = new byte[8];

            SecretKeySpec newKey = new SecretKeySpec(key, "RC2");

            RC2ParameterSpec rc2Spec = new RC2ParameterSpec(effectiveKeySize);

            Cipher ecipher = Cipher.getInstance("RC2");

            ecipher.init(mode, newKey, rc2Spec);

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
        }  catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}
