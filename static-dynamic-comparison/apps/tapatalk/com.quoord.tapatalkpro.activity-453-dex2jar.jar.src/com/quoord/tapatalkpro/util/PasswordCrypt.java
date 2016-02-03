package com.quoord.tapatalkpro.util;

import android.util.Log;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class PasswordCrypt {
    public static final int EncryptionMedium = 1;
    public static final int EncryptionStrong = 2;
    private static String TAG = "CryptoHelper";
    protected static String algorithmMedium = "PBEWithMD5And128BitAES-CBC-OpenSSL";
    protected static String algorithmStrong = "PBEWithSHA1And256BitAES-CBC-BC";
    private static final int count = 20;
    protected static String desAlgorithm = "DES";
    protected static SecretKeyFactory keyFac;
    protected static String password = null;
    protected static Cipher pbeCipher;
    protected static SecretKey pbeKey;
    protected static PBEKeySpec pbeKeySpec;
    protected static PBEParameterSpec pbeParamSpec;
    private static final byte[] salt = {-4, 118, -128, -82, -3, -126, -66, -18};
    private String algorithm = "";
    private boolean status = false;

    public PasswordCrypt() {
        initialize(1);
    }

    PasswordCrypt(int paramInt) {
        initialize(paramInt);
    }

    public static String generateMasterKey() {
        try {
            Object localObject = KeyGenerator.getInstance("AES");
            ((KeyGenerator) localObject).init(256);
            localObject = toHexString(((KeyGenerator) localObject).generateKey().getEncoded());
            return (String) localObject;
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
        }
        return null;
    }

    public static byte[] hexStringToBytes(String paramString) {
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        int i = 0;
        int j = 0;
        for (; ; ) {
            if (j >= paramString.length()) {
                return arrayOfByte;
            }
            try {
                String str = paramString.substring(j, j + 2);
                new Integer(0);
                k = Integer.decode("0x" + str).intValue();
            } catch (NumberFormatException paramString) {
                try {
                    int k;
                    arrayOfByte[i] = new Integer(k).byteValue();
                    j += 2;
                    i += 1;
                } catch (StringIndexOutOfBoundsException paramString) {
                    for (; ; ) {
                    }
                } catch (NumberFormatException paramString) {
                    for (; ; ) {
                    }
                }
                paramString = paramString;
                Log.i(TAG, paramString.getLocalizedMessage());
                return arrayOfByte;
            } catch (StringIndexOutOfBoundsException paramString) {
                Log.i(TAG, "StringIndexOutOfBoundsException");
                return arrayOfByte;
            }
        }
    }

    private void initialize(int paramInt) {
        switch (paramInt) {
        }
        for (; ; ) {
            pbeParamSpec = new PBEParameterSpec(salt, 20);
            try {
                keyFac = SecretKeyFactory.getInstance(this.algorithm, "BC");
                return;
            } catch (NoSuchProviderException localNoSuchProviderException) {
                return;
            } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            }
            this.algorithm = algorithmMedium;
            continue;
            this.algorithm = algorithmStrong;
        }
    }

    /* Error */
    public static byte[] md5String(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 185	java/lang/String:getBytes	()[B
        //   4: astore 4
        //   6: aconst_null
        //   7: astore_3
        //   8: ldc -69
        //   10: invokestatic 192	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
        //   13: astore_0
        //   14: new 194	java/io/ByteArrayInputStream
        //   17: dup
        //   18: aload 4
        //   20: invokespecial 197	java/io/ByteArrayInputStream:<init>	([B)V
        //   23: astore 5
        //   25: new 199	java/security/DigestInputStream
        //   28: dup
        //   29: aload 5
        //   31: aload_0
        //   32: invokespecial 202	java/security/DigestInputStream:<init>	(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
        //   35: astore_0
        //   36: iconst_0
        //   37: istore_1
        //   38: aload 4
        //   40: arraylength
        //   41: istore_2
        //   42: iload_1
        //   43: iload_2
        //   44: if_icmplt +11 -> 55
        //   47: aload_0
        //   48: invokevirtual 206	java/security/DigestInputStream:getMessageDigest	()Ljava/security/MessageDigest;
        //   51: invokevirtual 209	java/security/MessageDigest:digest	()[B
        //   54: areturn
        //   55: aload_0
        //   56: invokevirtual 212	java/security/DigestInputStream:read	()I
        //   59: pop
        //   60: iload_1
        //   61: iconst_1
        //   62: iadd
        //   63: istore_1
        //   64: goto -26 -> 38
        //   67: astore_0
        //   68: aload_3
        //   69: astore_0
        //   70: goto -23 -> 47
        //   73: astore_0
        //   74: aload_3
        //   75: astore_0
        //   76: goto -29 -> 47
        //   79: astore_3
        //   80: goto -33 -> 47
        //   83: astore_0
        //   84: aload_3
        //   85: astore_0
        //   86: goto -39 -> 47
        //   89: astore_0
        //   90: aload_3
        //   91: astore_0
        //   92: goto -45 -> 47
        //   95: astore_3
        //   96: goto -49 -> 47
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	99	0	paramString	String
        //   37	27	1	i	int
        //   41	4	2	j	int
        //   7	68	3	localObject	Object
        //   79	12	3	localIOException	java.io.IOException
        //   95	1	3	localNoSuchAlgorithmException	NoSuchAlgorithmException
        //   4	35	4	arrayOfByte	byte[]
        //   23	7	5	localByteArrayInputStream	java.io.ByteArrayInputStream
        // Exception table:
        //   from	to	target	type
        //   8	25	67	java/io/IOException
        //   25	36	73	java/io/IOException
        //   38	42	79	java/io/IOException
        //   55	60	79	java/io/IOException
        //   8	25	83	java/security/NoSuchAlgorithmException
        //   25	36	89	java/security/NoSuchAlgorithmException
        //   38	42	95	java/security/NoSuchAlgorithmException
        //   55	60	95	java/security/NoSuchAlgorithmException
    }

    public static String toHexString(byte[] paramArrayOfByte) {
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayOfByte.length) {
                return localStringBuffer.toString();
            }
            localStringBuffer.append(Integer.toHexString((paramArrayOfByte[i] & 0xFF) + 256).substring(1));
            i += 1;
        }
    }

    public String decrypt(String paramString) {
        this.status = false;
        if ((paramString == null) || (paramString == "")) {
            return "";
        }
        byte[] arrayOfByte = hexStringToBytes(paramString);
        paramString = new byte[0];
        str1 = paramString;
        str2 = paramString;
        str3 = paramString;
        str4 = paramString;
        str5 = paramString;
        try {
            pbeCipher.init(2, pbeKey, pbeParamSpec);
            str1 = paramString;
            str2 = paramString;
            str3 = paramString;
            str4 = paramString;
            str5 = paramString;
            paramString = pbeCipher.doFinal(arrayOfByte);
            str1 = paramString;
            str2 = paramString;
            str3 = paramString;
            str4 = paramString;
            str5 = paramString;
            this.status = true;
        } catch (Exception paramString) {
            for (; ; ) {
                paramString = str1;
            }
        } catch (InvalidAlgorithmParameterException paramString) {
            for (; ; ) {
                paramString = str2;
            }
        } catch (InvalidKeyException paramString) {
            for (; ; ) {
                paramString = str3;
            }
        } catch (BadPaddingException paramString) {
            for (; ; ) {
                paramString = str4;
            }
        } catch (IllegalBlockSizeException paramString) {
            for (; ; ) {
                paramString = str5;
            }
        }
        return new String(paramString);
    }

    public String encrypt(String paramString) {
        this.status = false;
        byte[] arrayOfByte = new byte[0];
        localObject1 = arrayOfByte;
        localObject2 = arrayOfByte;
        localObject3 = arrayOfByte;
        localObject4 = arrayOfByte;
        localObject5 = arrayOfByte;
        try {
            pbeCipher.init(1, pbeKey, pbeParamSpec);
            localObject1 = arrayOfByte;
            localObject2 = arrayOfByte;
            localObject3 = arrayOfByte;
            localObject4 = arrayOfByte;
            localObject5 = arrayOfByte;
            paramString = pbeCipher.doFinal(paramString.getBytes());
            localObject1 = paramString;
            localObject2 = paramString;
            localObject3 = paramString;
            localObject4 = paramString;
            localObject5 = paramString;
            this.status = true;
        } catch (Exception paramString) {
            for (; ; ) {
                paramString = (String) localObject1;
            }
        } catch (InvalidAlgorithmParameterException paramString) {
            for (; ; ) {
                paramString = (String) localObject2;
            }
        } catch (InvalidKeyException paramString) {
            for (; ; ) {
                paramString = (String) localObject3;
            }
        } catch (BadPaddingException paramString) {
            for (; ; ) {
                paramString = (String) localObject4;
            }
        } catch (IllegalBlockSizeException paramString) {
            for (; ; ) {
                paramString = (String) localObject5;
            }
        }
        return toHexString(paramString);
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setPassword(String paramString) {
        password = paramString;
        if (password == null) {
            password = "a4b5";
        }
        pbeKeySpec = new PBEKeySpec(password.toCharArray());
        try {
            pbeKey = keyFac.generateSecret(pbeKeySpec);
            pbeCipher = Cipher.getInstance(this.algorithm, "BC");
            return;
        } catch (NoSuchPaddingException paramString) {
        } catch (NoSuchProviderException paramString) {
        } catch (NoSuchAlgorithmException paramString) {
        } catch (InvalidKeySpecException paramString) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/PasswordCrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */