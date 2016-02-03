package com.parse.codec.binary;

import java.io.UnsupportedEncodingException;

public class StringUtils
{
  public static byte[] getBytesIso8859_1(String paramString)
  {
    return getBytesUnchecked(paramString, "ISO-8859-1");
  }
  
  public static byte[] getBytesUnchecked(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw newIllegalStateException(paramString2, paramString1);
    }
  }
  
  public static byte[] getBytesUsAscii(String paramString)
  {
    return getBytesUnchecked(paramString, "US-ASCII");
  }
  
  public static byte[] getBytesUtf16(String paramString)
  {
    return getBytesUnchecked(paramString, "UTF-16");
  }
  
  public static byte[] getBytesUtf16Be(String paramString)
  {
    return getBytesUnchecked(paramString, "UTF-16BE");
  }
  
  public static byte[] getBytesUtf16Le(String paramString)
  {
    return getBytesUnchecked(paramString, "UTF-16LE");
  }
  
  public static byte[] getBytesUtf8(String paramString)
  {
    return getBytesUnchecked(paramString, "UTF-8");
  }
  
  private static IllegalStateException newIllegalStateException(String paramString, UnsupportedEncodingException paramUnsupportedEncodingException)
  {
    return new IllegalStateException(paramString + ": " + paramUnsupportedEncodingException);
  }
  
  public static String newString(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramString);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw newIllegalStateException(paramString, paramArrayOfByte);
    }
  }
  
  public static String newStringIso8859_1(byte[] paramArrayOfByte)
  {
    return newString(paramArrayOfByte, "ISO-8859-1");
  }
  
  public static String newStringUsAscii(byte[] paramArrayOfByte)
  {
    return newString(paramArrayOfByte, "US-ASCII");
  }
  
  public static String newStringUtf16(byte[] paramArrayOfByte)
  {
    return newString(paramArrayOfByte, "UTF-16");
  }
  
  public static String newStringUtf16Be(byte[] paramArrayOfByte)
  {
    return newString(paramArrayOfByte, "UTF-16BE");
  }
  
  public static String newStringUtf16Le(byte[] paramArrayOfByte)
  {
    return newString(paramArrayOfByte, "UTF-16LE");
  }
  
  public static String newStringUtf8(byte[] paramArrayOfByte)
  {
    return newString(paramArrayOfByte, "UTF-8");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/binary/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */