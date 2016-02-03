package com.everimaging.fotorsdk.uil.cache.disc.naming;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c
        implements a {
    private byte[] a(byte[] paramArrayOfByte) {
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramArrayOfByte);
            paramArrayOfByte = localMessageDigest.digest();
            return paramArrayOfByte;
        } catch (NoSuchAlgorithmException paramArrayOfByte) {
            com.everimaging.fotorsdk.uil.utils.c.a(paramArrayOfByte);
        }
        return null;
    }

    public String a(String paramString) {
        return new BigInteger(a(paramString.getBytes())).abs().toString(36);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/cache/disc/naming/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */