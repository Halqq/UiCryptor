package dev.halq.utils.wattermark;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Util {

    public static long search(String text, File file) throws IOException {

        System.out.println("[UiCryptor] WatterMark" + " Searching string");
        if (text.isEmpty())
            return file.exists() ? 0 : -1;
        byte[] bytes = text.getBytes();

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {

            List<Integer> matches = new LinkedList<>();

            for (long pos = 0; pos < file.length(); pos++) {
                byte bite = dis.readByte();

                for (int i = 0; i < matches.size(); i++) {
                    Integer m = matches.get(i);
                    if (bytes[m] != bite)
                        matches.remove(i--);
                    else if (++m == bytes.length)
                        return pos - m + 1;
                    else
                        matches.set(i, m);
                }

                if (bytes[0] == bite)
                    matches.add(1);
            }
        }
        return -1;
    }

}
