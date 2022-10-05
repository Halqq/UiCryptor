package dev.halq.utils.watermark;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Watermark {

    public static void addWattermark(File input) throws IOException {

        String wattermark = " Encrypted for UiCryptor https://github.com/Halqq/UiCryptor";
        System.out.println("[UiCryptor] WaterMark " + "loading wattermark");

        Files.write(input.toPath(), wattermark.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        System.out.println("[UiCryptor] WaterMark " + "putting wattermark");
    }

    public static void remove(File file) throws IOException {
        String text = " Encrypted for UiCryptor https://github.com/Halqq/UiCryptor";
        try (RandomAccessFile rafile = new RandomAccessFile(file, "rw");) {
            long scanForString = Util.search(text, file);
            if (scanForString == -1) {
                System.out.println("[UiCryptor] WaterMark " + "Not found watermark in file " + file);
                return;
            }
            long remainderStartPos = scanForString + text.getBytes().length;
            rafile.seek(remainderStartPos);
            int remainderSize = (int) (rafile.length() - rafile.getFilePointer());
            byte[] bytes = new byte[remainderSize];
            rafile.read(bytes);
            System.out.println("[UiCryptor] WaterMark " + "reading bytes");
            System.out.println("[UiCryptor] WaterMark " + "Removing bytes");
            rafile.seek(scanForString);

            rafile.write(bytes);
            rafile.setLength(rafile.length() - (text.length()));
        }
    }
}
