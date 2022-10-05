package dev.halq.utils.base64;

import org.apache.commons.codec.binary.Base64;

import java.io.*;

public class Base64Encode {

    public static void encode(File inputFile, File outputFile) throws IOException {

        FileInputStream inputStream = new FileInputStream(inputFile);

        byte[] inputBytes = new byte[(int) inputFile.length()];

        inputStream.read(inputBytes);

        byte[] bytesEncoded = Base64.decodeBase64(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(outputFile);

        outputStream.write(bytesEncoded);

        inputStream.close();
        outputStream.close();

    }
}
