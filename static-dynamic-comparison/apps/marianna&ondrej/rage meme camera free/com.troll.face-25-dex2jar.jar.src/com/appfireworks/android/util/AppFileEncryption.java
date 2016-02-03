package com.appfireworks.android.util;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AppFileEncryption
{
  private static final String HEX = "0123456789ABCDEF";
  
  private static void appendHex(StringBuffer paramStringBuffer, byte paramByte)
  {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF)).append("0123456789ABCDEF".charAt(paramByte & 0xF));
  }
  
  public static String decrypt(String paramString1, String paramString2)
    throws Exception
  {
    return new String(decrypt(getRawKey(paramString1.getBytes()), toByte(paramString2)));
  }
  
  private static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(2, paramArrayOfByte1);
    return localCipher.doFinal(paramArrayOfByte2);
  }
  
  public static String encrypt(String paramString1, String paramString2)
    throws Exception
  {
    return toHex(encrypt(getRawKey(paramString1.getBytes()), paramString2.getBytes()));
  }
  
  private static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(1, paramArrayOfByte1);
    return localCipher.doFinal(paramArrayOfByte2);
  }
  
  private static byte[] getRawKey(byte[] paramArrayOfByte)
    throws Exception
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG");
    localSecureRandom.setSeed(paramArrayOfByte);
    localKeyGenerator.init(128, localSecureRandom);
    return localKeyGenerator.generateKey().getEncoded();
  }
  
  private static byte[] toByte(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return arrayOfByte;
      }
      arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
      i += 1;
    }
  }
  
  private static String toHex(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return localStringBuffer.toString();
      }
      appendHex(localStringBuffer, paramArrayOfByte[i]);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/util/AppFileEncryption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */