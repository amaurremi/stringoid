package com.google.ads;

public final class aq
{
  private static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  private static final char[] b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
  private static final byte[] c = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9 };
  private static final byte[] d = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9 };
  
  private static int a(char[] paramArrayOfChar, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfChar[(paramInt1 + 2)] == '=')
    {
      paramArrayOfByte1[paramInt2] = ((byte)((paramArrayOfByte2[paramArrayOfChar[paramInt1]] << 24 >>> 6 | paramArrayOfByte2[paramArrayOfChar[(paramInt1 + 1)]] << 24 >>> 12) >>> 16));
      return 1;
    }
    if (paramArrayOfChar[(paramInt1 + 3)] == '=')
    {
      paramInt1 = paramArrayOfByte2[paramArrayOfChar[paramInt1]] << 24 >>> 6 | paramArrayOfByte2[paramArrayOfChar[(paramInt1 + 1)]] << 24 >>> 12 | paramArrayOfByte2[paramArrayOfChar[(paramInt1 + 2)]] << 24 >>> 18;
      paramArrayOfByte1[paramInt2] = ((byte)(paramInt1 >>> 16));
      paramArrayOfByte1[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
      return 2;
    }
    paramInt1 = paramArrayOfByte2[paramArrayOfChar[paramInt1]] << 24 >>> 6 | paramArrayOfByte2[paramArrayOfChar[(paramInt1 + 1)]] << 24 >>> 12 | paramArrayOfByte2[paramArrayOfChar[(paramInt1 + 2)]] << 24 >>> 18 | paramArrayOfByte2[paramArrayOfChar[(paramInt1 + 3)]] << 24 >>> 24;
    paramArrayOfByte1[paramInt2] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte1[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte1[(paramInt2 + 2)] = ((byte)paramInt1);
    return 3;
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, char[] paramArrayOfChar, boolean paramBoolean)
  {
    paramArrayOfByte = a(paramArrayOfByte, paramInt1, paramInt2, paramArrayOfChar, Integer.MAX_VALUE);
    paramInt1 = paramArrayOfByte.length;
    for (;;)
    {
      if ((paramBoolean) || (paramInt1 <= 0) || (paramArrayOfByte[(paramInt1 - 1)] != '=')) {
        return new String(paramArrayOfByte, 0, paramInt1);
      }
      paramInt1 -= 1;
    }
  }
  
  public static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, b, paramBoolean);
  }
  
  public static byte[] a(String paramString)
    throws ap
  {
    paramString = paramString.toCharArray();
    return a(paramString, 0, paramString.length);
  }
  
  public static byte[] a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws ap
  {
    return a(paramArrayOfChar, paramInt1, paramInt2, c);
  }
  
  public static byte[] a(char[] paramArrayOfChar, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws ap
  {
    byte[] arrayOfByte = new byte[paramInt2 * 3 / 4 + 2];
    int j = 0;
    char[] arrayOfChar = new char[4];
    int n = 0;
    int m = 0;
    int k = 0;
    int i1;
    int i;
    if (m < paramInt2)
    {
      i1 = paramArrayOfChar[(m + paramInt1)];
      i = (char)(i1 & 0x7F);
      int i2 = paramArrayOfByte[i];
      if ((i == i1) && (i2 < -5)) {
        throw new ap("Bad Base64 input character at " + m + ": " + paramArrayOfChar[(m + paramInt1)] + "(decimal)");
      }
      if (i2 < -1) {
        break label382;
      }
      if (i == 61) {
        if (n == 0) {}
      }
    }
    label382:
    for (;;)
    {
      m += 1;
      break;
      if (m < 2) {
        throw new ap("Invalid padding char found in position " + m);
      }
      n = 1;
      i1 = (char)(paramArrayOfChar[(paramInt2 - 1 + paramInt1)] & 0x7F);
      if ((i1 != 61) && (i1 != 10)) {
        throw new ap("encoded value has invalid trailing char");
      }
      continue;
      if (n != 0) {
        throw new ap("Data found after trailing padding char at index " + m);
      }
      i1 = k + 1;
      arrayOfChar[k] = i;
      if (i1 == 4)
      {
        j += a(arrayOfChar, 0, arrayOfByte, j, paramArrayOfByte);
        k = 0;
        continue;
        paramInt1 = j;
        if (k != 0)
        {
          if (k == 1) {
            throw new ap("single trailing character at offset " + (paramInt2 - 1));
          }
          arrayOfChar[k] = '=';
          paramInt1 = j + a(arrayOfChar, 0, arrayOfByte, j, paramArrayOfByte);
        }
        paramArrayOfChar = new byte[paramInt1];
        System.arraycopy(arrayOfByte, 0, paramArrayOfChar, 0, paramInt1);
        return paramArrayOfChar;
      }
      else
      {
        k = i1;
      }
    }
  }
  
  public static char[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int i = (paramInt2 + 2) / 3 * 4;
    char[] arrayOfChar = new char[i + i / paramInt3];
    int j = 0;
    i = 0;
    int k = 0;
    while (k < paramInt2 - 2)
    {
      int m = paramArrayOfByte[(k + paramInt1)] << 24 >>> 8 | paramArrayOfByte[(k + 1 + paramInt1)] << 24 >>> 16 | paramArrayOfByte[(k + 2 + paramInt1)] << 24 >>> 24;
      arrayOfChar[i] = paramArrayOfChar[(m >>> 18)];
      arrayOfChar[(i + 1)] = paramArrayOfChar[(m >>> 12 & 0x3F)];
      arrayOfChar[(i + 2)] = paramArrayOfChar[(m >>> 6 & 0x3F)];
      arrayOfChar[(i + 3)] = paramArrayOfChar[(m & 0x3F)];
      int n = j + 4;
      j = n;
      m = i;
      if (n == paramInt3)
      {
        arrayOfChar[(i + 4)] = '\n';
        m = i + 1;
        j = 0;
      }
      k += 3;
      i = m + 4;
    }
    if (k < paramInt2)
    {
      a(paramArrayOfByte, k + paramInt1, paramInt2 - k, arrayOfChar, i, paramArrayOfChar);
      paramInt1 = i;
      if (j + 4 == paramInt3)
      {
        arrayOfChar[(i + 4)] = '\n';
        paramInt1 = i + 1;
      }
    }
    return arrayOfChar;
  }
  
  private static char[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, char[] paramArrayOfChar1, int paramInt3, char[] paramArrayOfChar2)
  {
    int k = 0;
    int i;
    if (paramInt2 > 0)
    {
      i = paramArrayOfByte[paramInt1] << 24 >>> 8;
      label18:
      if (paramInt2 <= 1) {
        break label100;
      }
    }
    label100:
    for (int j = paramArrayOfByte[(paramInt1 + 1)] << 24 >>> 16;; j = 0)
    {
      if (paramInt2 > 2) {
        k = paramArrayOfByte[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = k | j | i;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfChar1;
        i = 0;
        break label18;
      }
    }
    paramArrayOfChar1[paramInt3] = paramArrayOfChar2[(paramInt1 >>> 18)];
    paramArrayOfChar1[(paramInt3 + 1)] = paramArrayOfChar2[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfChar1[(paramInt3 + 2)] = paramArrayOfChar2[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfChar1[(paramInt3 + 3)] = paramArrayOfChar2[(paramInt1 & 0x3F)];
    return paramArrayOfChar1;
    paramArrayOfChar1[paramInt3] = paramArrayOfChar2[(paramInt1 >>> 18)];
    paramArrayOfChar1[(paramInt3 + 1)] = paramArrayOfChar2[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfChar1[(paramInt3 + 2)] = paramArrayOfChar2[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfChar1[(paramInt3 + 3)] = '=';
    return paramArrayOfChar1;
    paramArrayOfChar1[paramInt3] = paramArrayOfChar2[(paramInt1 >>> 18)];
    paramArrayOfChar1[(paramInt3 + 1)] = paramArrayOfChar2[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfChar1[(paramInt3 + 2)] = '=';
    paramArrayOfChar1[(paramInt3 + 3)] = '=';
    return paramArrayOfChar1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */