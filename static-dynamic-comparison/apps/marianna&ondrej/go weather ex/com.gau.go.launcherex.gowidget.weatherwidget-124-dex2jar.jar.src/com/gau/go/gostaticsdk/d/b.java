package com.gau.go.gostaticsdk.d;

import java.io.UnsupportedEncodingException;

public class b
{
  public static final byte[] a = { 65, 66, 69, 78, 50, 48, 49, 50, 48, 57, 51, 48, 49, 56, 51, 48 };
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a(paramString1.getBytes("utf-8"), paramString2);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramArrayOfByte = a.a(a(paramArrayOfByte, paramString.getBytes("utf-8")));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, a);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, byte paramByte)
  {
    try
    {
      byte[] arrayOfByte2 = new byte[paramArrayOfByte.length];
      int i = 0;
      byte[] arrayOfByte1;
      for (;;)
      {
        arrayOfByte1 = arrayOfByte2;
        if (i >= paramArrayOfByte.length) {
          break;
        }
        arrayOfByte2[i] = ((byte)(paramArrayOfByte[i] ^ paramByte));
        i += 1;
      }
      return arrayOfByte1;
    }
    catch (Exception paramArrayOfByte)
    {
      arrayOfByte1 = null;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    while (i < paramArrayOfByte2.length)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2[i]);
      i += 1;
    }
    return paramArrayOfByte1;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */