package com.amazonaws.org.apache.http.util;

import com.amazonaws.org.apache.http.Consts;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class EncodingUtils
{
  public static byte[] getAsciiBytes(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Parameter may not be null");
    }
    try
    {
      paramString = paramString.getBytes(Consts.ASCII.name());
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new Error("HttpClient requires ASCII support");
    }
  }
  
  public static String getAsciiString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Parameter may not be null");
    }
    return getAsciiString(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String getAsciiString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Parameter may not be null");
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramInt1, paramInt2, Consts.ASCII.name());
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new Error("HttpClient requires ASCII support");
    }
  }
  
  public static byte[] getBytes(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("data may not be null");
    }
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      throw new IllegalArgumentException("charset may not be null or empty");
    }
    try
    {
      paramString2 = paramString1.getBytes(paramString2);
      return paramString2;
    }
    catch (UnsupportedEncodingException paramString2) {}
    return paramString1.getBytes();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/util/EncodingUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */