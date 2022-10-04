package dev.halq.utils.blowFish;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;

public class DecryptBlowFish {

    public static void decrypt(File file1, File file2, byte[] key) throws IOException {
        CryptoBlowFish.doCrypto(Cipher.DECRYPT_MODE, file1, file2, key);
    }
}
