package com.inmobi.commons.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;

public class EncryptionUtils {
    private static byte[] a = new byte[16];
    private static String b = "SHA1PRNG";
    private static String c = "Crypto";
    private static String d = "HmacSHA1";
    private static String e = "RSA";
    private static String f = "RSA/ECB/nopadding";
    private static String g = "aeskeygenerate";
    private static String h = "last_key_generate";
    private static String i = "AES/CBC/PKCS7Padding";
    private static String j = "AES";

    public static byte[] DeAe(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {
        return b(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    }

    public static String SeMeGe(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, String paramString2, String paramString3) {
        return a(paramString1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramString2, paramString3);
    }

    private static String a(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, String paramString2, String paramString3) {
        try {
            paramString1 = a(paramString1.getBytes("UTF-8"), paramArrayOfByte1, paramArrayOfByte2);
            byte[] arrayOfByte = a(paramString1, paramArrayOfByte3);
            paramString1 = a(paramString1);
            arrayOfByte = a(arrayOfByte);
            paramArrayOfByte2 = a(paramArrayOfByte2);
            paramString1 = new String(Base64.encode(b(a(a(b(b(a(paramArrayOfByte1), a(paramArrayOfByte3)), paramArrayOfByte2), paramString3, paramString2)), b(paramString1, arrayOfByte)), 8));
            return paramString1;
        } catch (Exception paramString1) {
            paramString1.printStackTrace();
        }
        return null;
    }

    private static byte[] a() {
        try {
            SecureRandom.getInstance(b, c).nextBytes(a);
            return a;
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            for (; ; ) {
                Log.internal("[InMobi]-4.5.1", "NoSuchAlgorithmException");
            }
        } catch (NoSuchProviderException localNoSuchProviderException) {
            for (; ; ) {
                Log.internal("[InMobi]-4.5.1", "NoSuchProviderException");
            }
        }
    }

    private static byte[] a(byte[] paramArrayOfByte) {
        long l = paramArrayOfByte.length;
        Object localObject = ByteBuffer.allocate(8);
        ((ByteBuffer) localObject).order(ByteOrder.LITTLE_ENDIAN);
        ((ByteBuffer) localObject).putLong(l);
        localObject = ((ByteBuffer) localObject).array();
        byte[] arrayOfByte = new byte[localObject.length + paramArrayOfByte.length];
        System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, localObject.length, paramArrayOfByte.length);
        return arrayOfByte;
    }

    private static byte[] a(byte[] paramArrayOfByte, String paramString1, String paramString2) {
        paramString2 = new BigInteger(paramString2, 16);
        paramString1 = new BigInteger(paramString1, 16);
        try {
            paramString1 = (RSAPublicKey) KeyFactory.getInstance(e).generatePublic(new EncryptionUtils.b(paramString2, paramString1));
            paramString2 = Cipher.getInstance(f);
            paramString2.init(1, paramString1);
            paramArrayOfByte = paramString2.doFinal(paramArrayOfByte);
            return paramArrayOfByte;
        } catch (NoSuchAlgorithmException paramArrayOfByte) {
            Log.internal("[InMobi]-4.5.1", "NoSuchAlgorithmException");
            return null;
        } catch (InvalidKeySpecException paramArrayOfByte) {
            Log.internal("[InMobi]-4.5.1", "InvalidKeySpecException");
            return null;
        } catch (NoSuchPaddingException paramArrayOfByte) {
            Log.internal("[InMobi]-4.5.1", "NoSuchPaddingException");
            return null;
        } catch (InvalidKeyException paramArrayOfByte) {
            Log.internal("[InMobi]-4.5.1", "InvalidKeyException");
            return null;
        } catch (IllegalBlockSizeException paramArrayOfByte) {
            Log.internal("[InMobi]-4.5.1", "IllegalBlockSizeException");
            return null;
        } catch (BadPaddingException paramArrayOfByte) {
            Log.internal("[InMobi]-4.5.1", "BadPaddingException");
        }
        return null;
    }

    private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        paramArrayOfByte2 = new EncryptionUtils.a(paramArrayOfByte2, 0, paramArrayOfByte2.length, d);
        try {
            Mac localMac = Mac.getInstance(d);
            localMac.init(paramArrayOfByte2);
            paramArrayOfByte1 = localMac.doFinal(paramArrayOfByte1);
            return paramArrayOfByte1;
        } catch (NoSuchAlgorithmException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "NoSuchAlgorithmException");
            return null;
        } catch (InvalidKeyException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "InvalidKeyException");
        }
        return null;
    }

    private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {
        paramArrayOfByte2 = new EncryptionUtils.a(paramArrayOfByte2, j);
        paramArrayOfByte3 = new EncryptionUtils.c(paramArrayOfByte3);
        try {
            Cipher localCipher = Cipher.getInstance(i);
            localCipher.init(1, paramArrayOfByte2, paramArrayOfByte3);
            paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
            return paramArrayOfByte1;
        } catch (NoSuchAlgorithmException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "NoSuchAlgorithmException");
            return null;
        } catch (NoSuchPaddingException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "NoSuchPaddingException");
            return null;
        } catch (InvalidKeyException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "InvalidKeyException");
            return null;
        } catch (IllegalBlockSizeException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "IllegalBlockSizeException");
            return null;
        } catch (BadPaddingException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "BadPaddingException");
            return null;
        } catch (InvalidAlgorithmParameterException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "InvalidAlgorithmParameterException");
        }
        return null;
    }

    private static byte[] b() {
        Object localObject = InternalSDKUtil.getContext().getSharedPreferences(g, 0);
        long l = ((SharedPreferences) localObject).getLong(h, 0L);
        if (0L == l) {
            Log.internal("[InMobi]-4.5.1", "Generating for first time");
            localObject = ((SharedPreferences) localObject).edit();
            ((SharedPreferences.Editor) localObject).putLong(h, System.currentTimeMillis());
            ((SharedPreferences.Editor) localObject).commit();
            return a();
        }
        if (l + 86400000L - System.currentTimeMillis() <= 0L) {
            Log.internal("[InMobi]-4.5.1", "generated again");
            localObject = ((SharedPreferences) localObject).edit();
            ((SharedPreferences.Editor) localObject).putLong(h, System.currentTimeMillis());
            ((SharedPreferences.Editor) localObject).commit();
            return a();
        }
        Log.internal("[InMobi]-4.5.1", "already generated");
        return a;
    }

    private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
        return arrayOfByte;
    }

    private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {
        paramArrayOfByte2 = new EncryptionUtils.a(paramArrayOfByte2, j);
        try {
            Cipher localCipher = Cipher.getInstance(i);
            localCipher.init(2, paramArrayOfByte2, new EncryptionUtils.c(paramArrayOfByte3));
            paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
            return paramArrayOfByte1;
        } catch (NoSuchAlgorithmException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "NoSuchAlgorithmException");
            return null;
        } catch (NoSuchPaddingException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "NoSuchPaddingException");
            return null;
        } catch (InvalidKeyException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "InvalidKeyException");
            return null;
        } catch (IllegalBlockSizeException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "IllegalBlockSizeException");
            return null;
        } catch (BadPaddingException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "BadPaddingException");
            return null;
        } catch (InvalidAlgorithmParameterException paramArrayOfByte1) {
            Log.internal("[InMobi]-4.5.1", "InvalidAlgorithmParameterException");
        }
        return null;
    }

    public static byte[] generateKey(int paramInt) {
        try {
            byte[] arrayOfByte = new byte[paramInt];
            new SecureRandom().nextBytes(arrayOfByte);
            return arrayOfByte;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return null;
    }

    public static byte[] keag() {
        return b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/EncryptionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */