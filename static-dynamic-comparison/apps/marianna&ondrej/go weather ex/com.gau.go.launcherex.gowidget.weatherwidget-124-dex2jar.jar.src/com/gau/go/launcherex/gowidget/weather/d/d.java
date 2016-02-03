package com.gau.go.launcherex.gowidget.weather.d;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class d
{
  public static final byte[] a = { 1, 3, 5, 7, 2, 4, 6, 8 };
  
  public static String a(String paramString1, String paramString2)
  {
    int k = 0;
    int[] arrayOfInt = new int[4];
    paramString2 = paramString2.getBytes("utf-8");
    int i = 0;
    int j = 0;
    if (i < paramString2.length)
    {
      if (i % 4 == 3)
      {
        arrayOfInt[j] += paramString2[i];
        arrayOfInt[j] = (arrayOfInt[j] % 17 + 49);
        j += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfInt[j] += paramString2[i];
      }
    }
    paramString1 = paramString1.getBytes("utf-8");
    i = k;
    while (i < paramString1.length)
    {
      paramString1[i] = ((byte)(paramString1[i] + arrayOfInt[i]));
      i += 1;
    }
    return new String(paramString1);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = b(MessageDigest.getInstance("MD5").digest(paramArrayOfByte)).replace("-", "").substring(8, 24);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toString(paramArrayOfByte[i] & 0xFF, 16);
      Object localObject1 = localObject2;
      if (((String)localObject2).length() == 1) {
        localObject1 = "0" + (String)localObject2;
      }
      localObject2 = localObject1;
      if (((String)localObject1).length() == 0) {
        localObject2 = "00";
      }
      str = str + (String)localObject2;
      i += 1;
    }
    return str;
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec("guangzhou_huizhiwccpcomm".getBytes("ASCII"), "DESede");
    Cipher localCipher = Cipher.getInstance("DESede");
    localCipher.init(1, localSecretKeySpec);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] d(byte[] paramArrayOfByte)
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec("guangzhou_huizhiwccpcomm".getBytes("ASCII"), "DESede");
    Cipher localCipher = Cipher.getInstance("DESede");
    localCipher.init(2, localSecretKeySpec);
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */