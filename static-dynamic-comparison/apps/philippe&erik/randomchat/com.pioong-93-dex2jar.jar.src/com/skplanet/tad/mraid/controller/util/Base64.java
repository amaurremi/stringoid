package com.skplanet.tad.mraid.controller.util;

public class Base64
{
  private static char[] a;
  private static byte[] b;
  
  static
  {
    int k = 0;
    a = new char[64];
    int i = 65;
    int j = 0;
    if (i > 90)
    {
      i = 97;
      label23:
      if (i <= 122) {
        break label105;
      }
      i = 48;
      label32:
      if (i <= 57) {
        break label123;
      }
      char[] arrayOfChar = a;
      int m = j + 1;
      arrayOfChar[j] = '+';
      a[m] = '/';
      b = new byte[''];
      j = 0;
      label70:
      if (j < b.length) {
        break label141;
      }
      j = k;
    }
    for (;;)
    {
      if (j >= 64)
      {
        return;
        a[j] = i;
        i = (char)(i + 1);
        j += 1;
        break;
        label105:
        a[j] = i;
        i = (char)(i + 1);
        j += 1;
        break label23;
        label123:
        a[j] = i;
        i = (char)(i + 1);
        j += 1;
        break label32;
        label141:
        b[j] = -1;
        j += 1;
        break label70;
      }
      b[a[j]] = ((byte)j);
      j += 1;
    }
  }
  
  public static byte[] decode(String paramString)
  {
    return decode(paramString.toCharArray());
  }
  
  public static byte[] decode(char[] paramArrayOfChar)
  {
    int k = paramArrayOfChar.length;
    if (k % 4 != 0) {
      throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }
    for (;;)
    {
      k -= 1;
      while ((k <= 0) || (paramArrayOfChar[(k - 1)] != '='))
      {
        int i1 = k * 3 / 4;
        byte[] arrayOfByte = new byte[i1];
        int i = 0;
        int j = 0;
        if (j >= k) {
          return arrayOfByte;
        }
        int m = j + 1;
        int i2 = paramArrayOfChar[j];
        j = m + 1;
        int i3 = paramArrayOfChar[m];
        if (j < k)
        {
          m = paramArrayOfChar[j];
          j += 1;
          if (j >= k) {
            break label156;
          }
          n = paramArrayOfChar[j];
          j += 1;
        }
        for (;;)
        {
          if ((i2 <= 127) && (i3 <= 127) && (m <= 127) && (n <= 127)) {
            break label163;
          }
          throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
          m = 65;
          break;
          label156:
          n = 65;
        }
        label163:
        int i4 = b[i2];
        int i5 = b[i3];
        i3 = b[m];
        int n = b[n];
        if ((i4 < 0) || (i5 < 0) || (i3 < 0) || (n < 0)) {
          throw new IllegalArgumentException("Illegal character in Base64 encoded data. " + i2);
        }
        m = i + 1;
        arrayOfByte[i] = ((byte)(i5 >>> 4 | i4 << 2));
        if (m < i1)
        {
          i = m + 1;
          arrayOfByte[m] = ((byte)(i3 >>> 2 | (i5 & 0xF) << 4));
        }
        for (;;)
        {
          if (i < i1)
          {
            arrayOfByte[i] = ((byte)((i3 & 0x3) << 6 | n));
            i += 1;
            break;
          }
          break;
          i = m;
        }
      }
    }
  }
  
  public static String decodeString(String paramString)
  {
    return new String(decode(paramString));
  }
  
  public static char[] encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static char[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    int i2 = (paramInt * 4 + 2) / 3;
    char[] arrayOfChar = new char[(paramInt + 2) / 3 * 4];
    int k = 0;
    int j = 0;
    if (j >= paramInt) {
      return arrayOfChar;
    }
    int m = j + 1;
    int i3 = paramArrayOfByte[j] & 0xFF;
    int n;
    if (m < paramInt)
    {
      j = paramArrayOfByte[m] & 0xFF;
      n = m + 1;
      m = j;
      j = n;
      label74:
      if (j >= paramInt) {
        break label227;
      }
      n = j + 1;
      int i1 = paramArrayOfByte[j] & 0xFF;
      j = n;
      n = i1;
      label100:
      i1 = k + 1;
      arrayOfChar[k] = a[(i3 >>> 2)];
      k = i1 + 1;
      arrayOfChar[i1] = a[((i3 & 0x3) << 4 | m >>> 4)];
      if (k >= i2) {
        break label233;
      }
      i = a[((m & 0xF) << 2 | n >>> 6)];
      label170:
      arrayOfChar[k] = i;
      k += 1;
      if (k >= i2) {
        break label239;
      }
    }
    label227:
    label233:
    label239:
    for (int i = a[(n & 0x3F)];; i = 61)
    {
      arrayOfChar[k] = i;
      k += 1;
      break;
      n = 0;
      j = m;
      m = n;
      break label74;
      n = 0;
      break label100;
      i = 61;
      break label170;
    }
  }
  
  public static String encodeString(String paramString)
  {
    return new String(encode(paramString.getBytes()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/mraid/controller/util/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */