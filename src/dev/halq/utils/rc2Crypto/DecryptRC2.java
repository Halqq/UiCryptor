package dev.halq.utils.rc2Crypto;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;

public class DecryptRC2 {

    public static void decrypt(File file1, File file2) throws IOException {
        CryptoRC2.doCrypto(Cipher.DECRYPT_MODE, file1, file2);
    }
}
