package com.millennialmedia.android;

import java.util.Arrays;

class Base64
{
  private static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  private static final int[] IA = new int['Ā'];
  
  static
  {
    Arrays.fill(IA, -1);
    int i = 0;
    int j = CA.length;
    while (i < j)
    {
      IA[CA[i]] = i;
      i += 1;
    }
    IA[61] = 0;
  }
  
  public static final byte[] decode(String paramString)
  {
    Object localObject;
    if (paramString != null)
    {
      i = paramString.length();
      if (i != 0) {
        break label26;
      }
      localObject = new byte[0];
    }
    label26:
    int k;
    int i1;
    byte[] arrayOfByte;
    do
    {
      return (byte[])localObject;
      i = 0;
      break;
      j = 0;
      k = 0;
      while (k < i)
      {
        m = j;
        if (IA[paramString.charAt(k)] < 0) {
          m = j + 1;
        }
        k += 1;
        j = m;
      }
      if ((i - j) % 4 != 0) {
        return null;
      }
      m = 0;
      k = i;
      while (k > 1)
      {
        localObject = IA;
        n = k - 1;
        if (localObject[paramString.charAt(n)] > 0) {
          break;
        }
        k = n;
        if (paramString.charAt(n) == '=')
        {
          m += 1;
          k = n;
        }
      }
      i1 = ((i - j) * 6 >> 3) - m;
      arrayOfByte = new byte[i1];
      i = 0;
      k = 0;
      localObject = arrayOfByte;
    } while (k >= i1);
    int m = 0;
    int n = 0;
    int j = i;
    int i = n;
    if (i < 4)
    {
      n = IA[paramString.charAt(j)];
      if (n >= 0) {
        m |= n << 18 - i * 6;
      }
      for (;;)
      {
        i += 1;
        j += 1;
        break;
        i -= 1;
      }
    }
    n = k + 1;
    arrayOfByte[k] = ((byte)(m >> 16));
    i = n;
    if (n < i1)
    {
      i = n + 1;
      arrayOfByte[n] = ((byte)(m >> 8));
      if (i >= i1) {
        break label298;
      }
      k = i + 1;
      arrayOfByte[i] = ((byte)m);
      i = k;
    }
    label298:
    for (;;)
    {
      k = i;
      i = j;
      break;
    }
  }
  
  public static final byte[] decode(byte[] paramArrayOfByte)
  {
    int m = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    int k;
    while (j < m)
    {
      k = i;
      if (IA[(paramArrayOfByte[j] & 0xFF)] < 0) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    Object localObject;
    if ((m - i) % 4 != 0) {
      localObject = null;
    }
    int i1;
    byte[] arrayOfByte;
    do
    {
      return (byte[])localObject;
      k = 0;
      j = m;
      while (j > 1)
      {
        localObject = IA;
        n = j - 1;
        if (localObject[(paramArrayOfByte[n] & 0xFF)] > 0) {
          break;
        }
        j = n;
        if (paramArrayOfByte[n] == 61)
        {
          k += 1;
          j = n;
        }
      }
      i1 = ((m - i) * 6 >> 3) - k;
      arrayOfByte = new byte[i1];
      i = 0;
      k = 0;
      localObject = arrayOfByte;
    } while (k >= i1);
    m = 0;
    int n = 0;
    j = i;
    i = n;
    if (i < 4)
    {
      n = IA[(paramArrayOfByte[j] & 0xFF)];
      if (n >= 0) {
        m |= n << 18 - i * 6;
      }
      for (;;)
      {
        i += 1;
        j += 1;
        break;
        i -= 1;
      }
    }
    n = k + 1;
    arrayOfByte[k] = ((byte)(m >> 16));
    i = n;
    if (n < i1)
    {
      i = n + 1;
      arrayOfByte[n] = ((byte)(m >> 8));
      if (i >= i1) {
        break label281;
      }
      k = i + 1;
      arrayOfByte[i] = ((byte)m);
      i = k;
    }
    label281:
    for (;;)
    {
      k = i;
      i = j;
      break;
    }
  }
  
  public static final char[] encodeToChar(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte != null) {}
    Object localObject;
    for (int m = paramArrayOfByte.length; m == 0; m = 0)
    {
      localObject = new char[0];
      return (char[])localObject;
    }
    int i2 = m / 3 * 3;
    int k = (m - 1) / 3 + 1 << 2;
    int j;
    label61:
    int i1;
    char[] arrayOfChar;
    int n;
    label81:
    int i3;
    if (paramBoolean)
    {
      j = (k - 1) / 76 << 1;
      i1 = k + j;
      arrayOfChar = new char[i1];
      j = 0;
      k = 0;
      n = 0;
      if (n >= i2) {
        break label301;
      }
      int i4 = n + 1;
      n = paramArrayOfByte[n];
      i3 = i4 + 1;
      i4 = (n & 0xFF) << 16 | (paramArrayOfByte[i4] & 0xFF) << 8 | paramArrayOfByte[i3] & 0xFF;
      n = k + 1;
      arrayOfChar[k] = CA[(i4 >>> 18 & 0x3F)];
      k = n + 1;
      arrayOfChar[n] = CA[(i4 >>> 12 & 0x3F)];
      int i5 = k + 1;
      arrayOfChar[k] = CA[(i4 >>> 6 & 0x3F)];
      n = i5 + 1;
      arrayOfChar[i5] = CA[(i4 & 0x3F)];
      k = j;
      if (!paramBoolean) {
        break label433;
      }
      j += 1;
      k = j;
      if (j != 19) {
        break label433;
      }
      k = j;
      if (n >= i1 - 2) {
        break label433;
      }
      k = n + 1;
      arrayOfChar[n] = '\r';
      arrayOfChar[k] = '\n';
      j = 0;
      k += 1;
    }
    for (;;)
    {
      n = i3 + 1;
      break label81;
      j = 0;
      break label61;
      label301:
      k = m - i2;
      localObject = arrayOfChar;
      if (k <= 0) {
        break;
      }
      n = paramArrayOfByte[i2];
      if (k == 2)
      {
        j = (paramArrayOfByte[(m - 1)] & 0xFF) << 2;
        j = (n & 0xFF) << 10 | j;
        arrayOfChar[(i1 - 4)] = CA[(j >> 12)];
        arrayOfChar[(i1 - 3)] = CA[(j >>> 6 & 0x3F)];
        if (k != 2) {
          break label427;
        }
      }
      label427:
      for (int i = CA[(j & 0x3F)];; i = 61)
      {
        arrayOfChar[(i1 - 2)] = i;
        arrayOfChar[(i1 - 1)] = '=';
        return arrayOfChar;
        j = 0;
        break;
      }
      label433:
      j = k;
      k = n;
    }
  }
  
  public static final String encodeToString(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return new String(encodeToChar(paramArrayOfByte, paramBoolean));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */