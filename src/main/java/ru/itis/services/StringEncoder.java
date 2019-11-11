package ru.itis.services;

public class StringEncoder {
    public static synchronized String getEncryptedString(String s) throws Exception {
        HashingPassword encoder = new HashingPassword();
        return encoder.getSaltedHash(s);
    }
}
