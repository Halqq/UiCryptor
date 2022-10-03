package dev.halq.utils.PBEWCrypto;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;

public class EncryptDES {

    public static void encrypt(File file1, File file2) throws IOException{
        CryptoDES.doCrypto(Cipher.ENCRYPT_MODE, file1, file2);
    }
}
