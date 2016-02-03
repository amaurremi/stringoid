package com.gau.go.launcherex.gowidget.statistics;

public class c
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = b.a(a(paramString1.getBytes("utf-8"), paramString2.getBytes("utf-8")));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, byte paramByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ paramByte));
      i += 1;
    }
    return arrayOfByte;
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */