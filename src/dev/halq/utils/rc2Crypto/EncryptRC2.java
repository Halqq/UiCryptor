package dev.halq.utils.rc2Crypto;

import dev.halq.utils.desCrypto.CryptoDES;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;

public class EncryptRC2 {

    public static void encrypt(File file1, File file2) throws IOException {
        CryptoRC2.doCrypto(Cipher.ENCRYPT_MODE, file1, file2);
    }
}
