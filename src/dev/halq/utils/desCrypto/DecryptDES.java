package dev.halq.utils.desCrypto;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;

public class DecryptDES {

    public static void decrypt(File file1, File file2) throws IOException {
        CryptoDES.doCrypto(Cipher.DECRYPT_MODE, file1, file2);
    }
}
