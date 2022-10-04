package dev.halq.utils.blowFish.utils;

import dev.halq.utils.aesCrypto.RandomKey;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ByteGenerator {

    static List<String> stringList64 = new ArrayList<>();
    static List<String> stringList128 = new ArrayList<>();
    static List<String> stringList256 = new ArrayList<>();

    public static String getByte64(){
        Random r = new Random();
        int randomitem = r.nextInt(randomKey64().size());
        String randomKey64v = randomKey64().get(randomitem);

        return randomKey64v;
    }

    public static String getByte128(){
        Random r = new Random();
        int randomitem = r.nextInt(randomKey128().size());
        String randomKey128v = randomKey128().get(randomitem);

        return randomKey128v;
    }

    public static String getByte256(){
        Random r = new Random();
        int randomitem = r.nextInt(randomKey256().size());
        String randomKey256v = randomKey256().get(randomitem);

        System.out.println("[UiCryptor] BlowFish keys:" + randomKey256());

        return randomKey256v;
    }

    public static List<String> randomKey256() {

        stringList256.add(")J@NcRfUjXn2r5u8x/A?D(G+KaPdSgVk");
        stringList256.add("C&F)H@McQfTjWnZr4u7x!A%D*G-KaNdR");
        stringList256.add("9y$B&E)H+MbQeThWmZq4t7w!z%C*F-Ja");
        stringList256.add("s5v8y/B?E(H+KbPeShVmYq3t6w9z$C&F");
        stringList256.add("Xn2r5u8x/A?D(G-KaPdSgVkYp3s6v9y$");
        stringList256.add("fTjWnZr4u7x!A%D*G-JaNdRgUkXp2s5v");
        stringList256.add("MbQeThWmZq4t7w!z%C*F-J@NcRfUjXn2");

        return stringList256;
    }

    public static List<String> randomKey128() {

        stringList128.add("z%C*F-JaNdRgUjXn");
        stringList128.add("6w9z$C&F)J@NcRfU");
        stringList128.add("p3s6v9y$B&E)H@Mc");
        stringList128.add("UkXp2s5v8y/B?E(H");
        stringList128.add("dRfUjXn2r5u8x/A?");
        stringList128.add("J@NcRfTjWnZr4u7x");
        stringList128.add("&E)H@McQfThWmZq4");

        System.out.println("[UiCryptor] BlowFish keys:" + stringList128.toString());

        return stringList128;
    }

    public static List<String> randomKey64() {

        stringList64.add("aNcRfUjX");
        stringList64.add("F)J@McQf");
        stringList64.add("$B&E)H@M");
        stringList64.add("v8y/B?E(");
        stringList64.add("2r5u8x/A");
        stringList64.add("jWnZr4u7");
        stringList64.add("QeThWmZq");

        System.out.println("[UiCryptor] BlowFish keys:" + stringList64.toString());


        return stringList64;
    }

}
