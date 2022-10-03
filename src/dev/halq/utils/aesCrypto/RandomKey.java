package dev.halq.utils.aesCrypto;

import sun.misc.BASE64Encoder;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class RandomKey {

    static List<String> stringList = new ArrayList<>();

    public static List<String> getRandomKeys() {

        stringList.add(")J@NcRfTjWnZr4u7");
        stringList.add("B&E)H@McQfThWmZq");
        stringList.add("8y/B?E(H+MbQeThV");
        stringList.add("r5u8x/A?D(G+KbPe");
        stringList.add("WnZr4u7x!A%D*G-K");
        stringList.add("eThWmZq4t7w!z%C*");
        stringList.add("MbQeShVmYq3t6w9z");

        return stringList;
    }

}
