package com.jtpgodorncrqoeurl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AdEncryption
{
  private static String a()
  {
    int i = 16;
    String str1 = "";
    while (i > 0)
    {
      int j = (int)(Math.random() * 62.0D);
      String str2 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(j, j + 1);
      str1 = str1 + str2;
      i -= 1;
    }
    return str1;
  }
  
  private static String a(char paramChar, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramChar = '\000';
    while (paramChar < paramInt)
    {
      localStringBuilder.append('\000');
      paramChar += '\001';
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    do
    {
      return paramString1;
      String str = paramString3;
      if (paramString3 == null) {
        str = "";
      }
      int m = str.length();
      int n = paramString1.length();
      paramString3 = new StringBuffer(n);
      int i = 0;
      if (i < n)
      {
        char c = paramString1.charAt(i);
        int i1 = paramString2.indexOf(c);
        if (i1 >= 0)
        {
          int k = 1;
          j = k;
          if (i1 < m)
          {
            paramString3.append(str.charAt(i1));
            j = k;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          paramString3.append(c);
        }
      }
    } while (j == 0);
    return paramString3.toString();
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    localObject1 = null;
    for (;;)
    {
      try
      {
        localObject2 = MessageDigest.getInstance("SHA-1");
        localObject1 = localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        Object localObject2;
        int i;
        continue;
      }
      try
      {
        localObject2 = ((MessageDigest)localObject1).digest(paramArrayOfByte);
        paramArrayOfByte = "";
        i = 0;
        localObject1 = paramArrayOfByte;
        if (i < localObject2.length)
        {
          paramArrayOfByte = paramArrayOfByte + Integer.toString((localObject2[i] & 0xFF) + 256, 16).substring(1);
          i += 1;
          continue;
        }
        return (String)localObject1;
      }
      catch (Exception paramArrayOfByte)
      {
        localObject1 = "";
      }
    }
  }
  
  private static byte[] a(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[1];
    int i = 0;
    for (;;)
    {
      if (i < Math.ceil(j / 2)) {
        try
        {
          String str1 = paramString.substring(i << 1, (i << 1) + 2);
          arrayOfByte[i] = ((byte)Integer.parseInt(str1, 16));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            String str2 = paramString.substring(i << 1, (i << 1) + 1) + "0";
          }
        }
      }
    }
    return arrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(i % paramArrayOfByte2.length)]));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String base64encode(byte[] paramArrayOfByte)
  {
    int j = (3 - paramArrayOfByte.length % 3) % 3;
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + j];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = "";
    int i = 0;
    while (i < arrayOfByte.length)
    {
      int k = ((arrayOfByte[i] & 0xFF) << 16) + ((arrayOfByte[(i + 1)] & 0xFF) << 8) + (arrayOfByte[(i + 2)] & 0xFF);
      paramArrayOfByte = paramArrayOfByte + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(k >> 18 & 0x3F) + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(k >> 12 & 0x3F) + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(k >> 6 & 0x3F) + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(k & 0x3F);
      i += 3;
    }
    return paramArrayOfByte.substring(0, paramArrayOfByte.length() - j) + "==".substring(0, j);
  }
  
  public static String encrypt(String paramString)
  {
    paramString = paramString + '\023';
    int k = paramString.length();
    String str1 = paramString;
    if (k % 16 != 0) {
      str1 = paramString + a('\000', 16 - k % 16);
    }
    paramString = a().getBytes();
    Object localObject2 = a("ciF6e+7Fd^21sd|0".getBytes(), paramString);
    Object localObject1;
    int i;
    if (localObject2.length > 512)
    {
      localObject1 = new byte['Ȁ'];
      i = 0;
      while (i < 512)
      {
        localObject1[i] = localObject2[i];
        i += 1;
      }
      i = 0;
    }
    for (;;)
    {
      String str2;
      if (i < k)
      {
        byte[] arrayOfByte1 = a(a((byte[])localObject1));
        try
        {
          localObject2 = str1.substring(i, i + 16);
          arrayOfByte2 = a(((String)localObject2).getBytes(), arrayOfByte1);
          localObject2 = new byte[paramString.length + arrayOfByte2.length];
          j = 0;
          while (j < paramString.length)
          {
            localObject2[j] = paramString[j];
            j += 1;
          }
        }
        catch (Exception localException)
        {
          byte[] arrayOfByte2;
          for (;;)
          {
            str2 = str1.substring(i);
          }
          int j = 0;
          while (j < arrayOfByte2.length)
          {
            str2[(paramString.length + j)] = arrayOfByte2[j];
            j += 1;
          }
          arrayOfByte1 = new byte[arrayOfByte2.length + localObject1.length];
          j = 0;
          while (j < arrayOfByte2.length)
          {
            arrayOfByte1[j] = arrayOfByte2[j];
            j += 1;
          }
          j = 0;
          while (j < localObject1.length)
          {
            arrayOfByte1[(arrayOfByte2.length + j)] = localObject1[j];
            j += 1;
          }
          if (arrayOfByte1.length > 512)
          {
            localObject1 = new byte['Ȁ'];
            j = 0;
            for (;;)
            {
              paramString = (String)localObject1;
              if (j >= 512) {
                break;
              }
              localObject1[j] = arrayOfByte1[j];
              j += 1;
            }
          }
          paramString = arrayOfByte1;
          localObject1 = a("ciF6e+7Fd^21sd|0".getBytes(), paramString);
          i += 16;
          paramString = str2;
        }
      }
      else
      {
        return a(base64encode(paramString), "+/=", "-_~");
        i = 0;
        localObject1 = str2;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdEncryption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */