package com.mobileapptracker;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {
    private IvParameterSpec a;
    private SecretKeySpec b;
    private Cipher c;

    public a(String paramString1, String paramString2) {
        this.a = new IvParameterSpec(paramString2.getBytes());
        this.b = new SecretKeySpec(paramString1.getBytes(), "AES");
        try {
            this.c = Cipher.getInstance("AES/CBC/NoPadding");
            return;
        } catch (NoSuchAlgorithmException paramString1) {
            paramString1.printStackTrace();
            return;
        } catch (NoSuchPaddingException paramString1) {
            paramString1.printStackTrace();
        }
    }

    public static String a(byte[] paramArrayOfByte) {
        Object localObject;
        if (paramArrayOfByte == null) {
            localObject = null;
        }
        int j;
        int i;
        do {
            return (String) localObject;
            j = paramArrayOfByte.length;
            str = "";
            i = 0;
            localObject = str;
        } while (i >= j);
        if ((paramArrayOfByte[i] & 0xFF) < 16) {
        }
        for (String str = str + "0" + Integer.toHexString(paramArrayOfByte[i] & 0xFF); ; str = str + Integer.toHexString(paramArrayOfByte[i] & 0xFF)) {
            i += 1;
            break;
        }
    }

    private static String b(String paramString) {
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= 16 - j % 16) {
                return paramString;
            }
            paramString = paramString + ' ';
            i += 1;
        }
    }

    public byte[] a(String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
            throw new Exception("Empty string");
        }
        try {
            this.c.init(1, this.b, this.a);
            paramString = this.c.doFinal(b(paramString).getBytes());
            return paramString;
        } catch (Exception paramString) {
            throw new Exception("[encrypt] " + paramString.getMessage());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mobileapptracker/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */