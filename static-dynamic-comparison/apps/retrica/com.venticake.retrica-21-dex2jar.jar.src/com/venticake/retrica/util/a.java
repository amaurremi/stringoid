package com.venticake.retrica.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, new SecretKeySpec(a(), "AES"), new IvParameterSpec(b()));
      paramArrayOfByte = new String(localCipher.doFinal(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return "";
  }
  
  private static byte[] a()
  {
    return new byte[] { 94, -6, 61, -44, -47, -31, 123, -84, -80, -104, -25, 16, 110, -20, -35, 45 };
  }
  
  private static byte[] b()
  {
    return new byte[] { 6, 27, 69, 89, -24, 38, -119, 109, -122, 78, 115, -5, Byte.MIN_VALUE, 44, 21, -117 };
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, new SecretKeySpec(a(), "AES"), new IvParameterSpec(b()));
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */