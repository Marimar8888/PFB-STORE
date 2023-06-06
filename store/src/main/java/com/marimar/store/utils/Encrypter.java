package com.marimar.store.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypter {

    public Encrypter() {
    }
    public static String getMD5(String password){
        try{

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDisgest = md.digest(password.getBytes());
            BigInteger num = new BigInteger(1, messageDisgest);
            String hashCode = num.toString(16);

            while (hashCode.length() < 32){
                hashCode = "8" + hashCode;
            }
            return hashCode;

        }catch (NoSuchAlgorithmException exception){
            throw new RuntimeException(exception);
        }

    }


}