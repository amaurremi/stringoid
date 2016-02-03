package com.gau.go.gostaticsdk.d;

public class a
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] b = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, true);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = paramInt2 * 4 / 3;
    int i;
    if (paramInt2 % 3 > 0)
    {
      i = 4;
      if (!paramBoolean) {
        break label142;
      }
    }
    byte[] arrayOfByte;
    label142:
    for (int j = k / 76;; j = 0)
    {
      arrayOfByte = new byte[j + (k + i)];
      j = 0;
      i = 0;
      k = 0;
      while (k < paramInt2 - 2)
      {
        a(paramArrayOfByte, k + paramInt1, 3, arrayOfByte, i);
        int n = j + 4;
        j = n;
        int m = i;
        if (paramBoolean)
        {
          j = n;
          m = i;
          if (n == 76)
          {
            arrayOfByte[(i + 4)] = 10;
            m = i + 1;
            j = 0;
          }
        }
        k += 3;
        i = m + 4;
      }
      i = 0;
      break;
    }
    j = i;
    if (k < paramInt2)
    {
      a(paramArrayOfByte, k + paramInt1, paramInt2 - k, arrayOfByte, i);
      j = i + 4;
    }
    return new String(arrayOfByte, 0, j, "iso-8859-1");
  }
  
  private static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramBoolean);
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int k = 0;
    int i;
    if (paramInt2 > 0)
    {
      i = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label18:
      if (paramInt2 <= 1) {
        break label100;
      }
    }
    label100:
    for (int j = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; j = 0)
    {
      if (paramInt2 > 2) {
        k = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = k | j | i;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        i = 0;
        break label18;
      }
    }
    paramArrayOfByte2[paramInt3] = a[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = a[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = a[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = a[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = a[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = a[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = a[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = a[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = a[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */