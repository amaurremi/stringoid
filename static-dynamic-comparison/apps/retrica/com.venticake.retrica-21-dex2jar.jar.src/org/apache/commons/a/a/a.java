package org.apache.commons.a.a;

public class a
{
  static final byte[] a;
  private static byte[] b;
  private static byte[] c;
  
  static
  {
    int k = 0;
    a = "\r\n".getBytes();
    b = new byte['ÿ'];
    c = new byte[64];
    int i = 0;
    while (i < 255)
    {
      b[i] = -1;
      i += 1;
    }
    i = 90;
    while (i >= 65)
    {
      b[i] = ((byte)(i - 65));
      i -= 1;
    }
    i = 122;
    while (i >= 97)
    {
      b[i] = ((byte)(i - 97 + 26));
      i -= 1;
    }
    i = 57;
    while (i >= 48)
    {
      b[i] = ((byte)(i - 48 + 52));
      i -= 1;
    }
    b[43] = 62;
    b[47] = 63;
    i = 0;
    while (i <= 25)
    {
      c[i] = ((byte)(i + 65));
      i += 1;
    }
    int j = 26;
    i = 0;
    while (j <= 51)
    {
      c[j] = ((byte)(i + 97));
      j += 1;
      i += 1;
    }
    j = 52;
    i = k;
    while (j <= 61)
    {
      c[j] = ((byte)(i + 48));
      j += 1;
      i += 1;
    }
    c[62] = 43;
    c[63] = 47;
  }
  
  private static boolean a(byte paramByte)
  {
    if (paramByte == 61) {}
    while (b[paramByte] != -1) {
      return true;
    }
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, false);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length * 8;
    int i5 = i % 24;
    int i6 = i / 24;
    int n = 0;
    int m;
    int j;
    label49:
    byte[] arrayOfByte;
    int i1;
    int k;
    label79:
    int i4;
    int i2;
    int i3;
    int i7;
    if (i5 != 0)
    {
      i = (i6 + 1) * 4;
      m = i;
      if (paramBoolean)
      {
        if (a.length != 0) {
          break label313;
        }
        j = 0;
        m = i + a.length * j;
        n = j;
      }
      arrayOfByte = new byte[m];
      j = 76;
      i = 0;
      i1 = 0;
      k = 0;
      if (i1 >= i6) {
        break label370;
      }
      i4 = i1 * 3;
      i2 = paramArrayOfByte[i4];
      i3 = paramArrayOfByte[(i4 + 1)];
      i7 = paramArrayOfByte[(i4 + 2)];
      int i8 = (byte)(i3 & 0xF);
      int i9 = (byte)(i2 & 0x3);
      if ((i2 & 0xFFFFFF80) != 0) {
        break label327;
      }
      i2 = (byte)(i2 >> 2);
      label144:
      if ((i3 & 0xFFFFFF80) != 0) {
        break label341;
      }
      i3 = (byte)(i3 >> 4);
      label159:
      if ((i7 & 0xFFFFFF80) != 0) {
        break label355;
      }
      i4 = (byte)(i7 >> 6);
      label175:
      arrayOfByte[k] = c[i2];
      arrayOfByte[(k + 1)] = c[(i3 | i9 << 4)];
      arrayOfByte[(k + 2)] = c[(i4 | i8 << 2)];
      arrayOfByte[(k + 3)] = c[(i7 & 0x3F)];
      k += 4;
      if ((!paramBoolean) || (k != j)) {
        break label636;
      }
      System.arraycopy(a, 0, arrayOfByte, k, a.length);
      i += 1;
      j = (i + 1) * 76 + a.length * i;
      k = a.length + k;
    }
    label313:
    label327:
    label341:
    label355:
    label370:
    label540:
    label622:
    label636:
    for (;;)
    {
      i1 += 1;
      break label79;
      i = i6 * 4;
      break;
      j = (int)Math.ceil(i / 76.0F);
      break label49;
      i2 = (byte)(i2 >> 2 ^ 0xC0);
      break label144;
      i3 = (byte)(i3 >> 4 ^ 0xF0);
      break label159;
      i4 = (byte)(i7 >> 6 ^ 0xFC);
      break label175;
      i1 *= 3;
      if (i5 == 8)
      {
        j = paramArrayOfByte[i1];
        i1 = (byte)(j & 0x3);
        if ((j & 0xFFFFFF80) == 0)
        {
          j = (byte)(j >> 2);
          arrayOfByte[k] = c[j];
          arrayOfByte[(k + 1)] = c[(i1 << 4)];
          arrayOfByte[(k + 2)] = 61;
          arrayOfByte[(k + 3)] = 61;
        }
      }
      while (i5 != 16) {
        for (;;)
        {
          if ((paramBoolean) && (i < n)) {
            System.arraycopy(a, 0, arrayOfByte, m - a.length, a.length);
          }
          return arrayOfByte;
          j = (byte)(j >> 2 ^ 0xC0);
        }
      }
      j = paramArrayOfByte[i1];
      i1 = paramArrayOfByte[(i1 + 1)];
      i2 = (byte)(i1 & 0xF);
      i3 = (byte)(j & 0x3);
      if ((j & 0xFFFFFF80) == 0)
      {
        j = (byte)(j >> 2);
        if ((i1 & 0xFFFFFF80) != 0) {
          break label622;
        }
      }
      for (i1 = (byte)(i1 >> 4);; i1 = (byte)(i1 >> 4 ^ 0xF0))
      {
        arrayOfByte[k] = c[j];
        arrayOfByte[(k + 1)] = c[(i1 | i3 << 4)];
        arrayOfByte[(k + 2)] = c[(i2 << 2)];
        arrayOfByte[(k + 3)] = 61;
        break;
        j = (byte)(j >> 2 ^ 0xC0);
        break label540;
      }
    }
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    int k = 0;
    byte[] arrayOfByte2 = d(paramArrayOfByte);
    if (arrayOfByte2.length == 0) {
      paramArrayOfByte = new byte[0];
    }
    int m;
    int i;
    int j;
    byte[] arrayOfByte1;
    do
    {
      return paramArrayOfByte;
      m = arrayOfByte2.length / 4;
      i = arrayOfByte2.length;
      while (arrayOfByte2[(i - 1)] == 61)
      {
        j = i - 1;
        i = j;
        if (j == 0) {
          return new byte[0];
        }
      }
      arrayOfByte1 = new byte[i - m];
      j = 0;
      i = k;
      paramArrayOfByte = arrayOfByte1;
    } while (i >= m);
    int n = i * 4;
    int i2 = arrayOfByte2[(n + 2)];
    int i1 = arrayOfByte2[(n + 3)];
    k = b[arrayOfByte2[n]];
    n = b[arrayOfByte2[(n + 1)]];
    if ((i2 != 61) && (i1 != 61))
    {
      i2 = b[i2];
      i1 = b[i1];
      arrayOfByte1[j] = ((byte)(k << 2 | n >> 4));
      arrayOfByte1[(j + 1)] = ((byte)((n & 0xF) << 4 | i2 >> 2 & 0xF));
      arrayOfByte1[(j + 2)] = ((byte)(i2 << 6 | i1));
    }
    for (;;)
    {
      j += 3;
      i += 1;
      break;
      if (i2 == 61)
      {
        arrayOfByte1[j] = ((byte)(n >> 4 | k << 2));
      }
      else if (i1 == 61)
      {
        i1 = b[i2];
        arrayOfByte1[j] = ((byte)(k << 2 | n >> 4));
        arrayOfByte1[(j + 1)] = ((byte)((n & 0xF) << 4 | i1 >> 2 & 0xF));
      }
    }
  }
  
  static byte[] d(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfByte.length; j = k)
    {
      k = j;
      if (a(paramArrayOfByte[i]))
      {
        arrayOfByte[j] = paramArrayOfByte[i];
        k = j + 1;
      }
      i += 1;
    }
    paramArrayOfByte = new byte[j];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, j);
    return paramArrayOfByte;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    return c(paramArrayOfByte);
  }
  
  public byte[] e(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */