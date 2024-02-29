package com.arraywork.springshot.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.util.DigestUtils;

import com.arraywork.springshot.external.NanoIdUtils;

/**
 * Cryptography Digest
 *
 * @author AiChen
 * @copyright ArrayWork Inc.
 * @since 2024/01/25
 */
public class Digest {

    private static final char[] ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        .toCharArray();

    // NanoID
    public static String nanoId() {
        return nanoId(24);
    }

    // NanoID
    public static String nanoId(int length) {
        return NanoIdUtils.randomNanoId(NanoIdUtils.DEFAULT_NUMBER_GENERATOR, ALPHABET, length);
    }

    // Hash: MD5
    public static String md5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
    }

    // Hash: SHA256
    public static String sha256(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes(StandardCharsets.UTF_8));
        byte[] bs = md.digest();

        StringBuilder res = new StringBuilder();
        for (byte b : bs) res.append(String.format("%02x", b));
        return res.toString();
    }

    // UUID in 32 bytes
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}