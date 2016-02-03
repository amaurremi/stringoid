package com.mapbar.android.location;

import java.io.UnsupportedEncodingException;

public final class a
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  
  public static String a(byte[] paramArrayOfByte, String paramString)
    throws UnsupportedEncodingException
  {
    int i = (paramArrayOfByte.length << 2) / 3;
    byte[] arrayOfByte = new byte[i + (i / 76 + 3)];
    int n = paramArrayOfByte.length - paramArrayOfByte.length % 3;
    int k = 0;
    int j = 0;
    i = 0;
    if (j < n)
    {
      int m = i + 1;
      arrayOfByte[i] = a[((paramArrayOfByte[j] & 0xFF) >> 2)];
      i = m + 1;
      arrayOfByte[m] = a[((paramArrayOfByte[j] & 0x3) << 4 | (paramArrayOfByte[(j + 1)] & 0xFF) >> 4)];
      m = i + 1;
      arrayOfByte[i] = a[((paramArrayOfByte[(j + 1)] & 0xF) << 2 | (paramArrayOfByte[(j + 2)] & 0xFF) >> 6)];
      i = m + 1;
      arrayOfByte[m] = a[(paramArrayOfByte[(j + 2)] & 0x3F)];
      if (((i - k) % 76 != 0) || (i == 0)) {
        break label389;
      }
      m = i + 1;
      arrayOfByte[i] = 10;
      k += 1;
      i = m;
    }
    label389:
    for (;;)
    {
      j += 3;
      break;
      switch (paramArrayOfByte.length % 3)
      {
      }
      for (;;)
      {
        return new String(arrayOfByte, 0, i, paramString);
        j = i + 1;
        arrayOfByte[i] = a[((paramArrayOfByte[n] & 0xFF) >> 2)];
        i = j + 1;
        arrayOfByte[j] = a[((paramArrayOfByte[n] & 0x3) << 4)];
        j = i + 1;
        arrayOfByte[i] = 61;
        i = j + 1;
        arrayOfByte[j] = 61;
        continue;
        j = i + 1;
        arrayOfByte[i] = a[((paramArrayOfByte[n] & 0xFF) >> 2)];
        i = j + 1;
        arrayOfByte[j] = a[((paramArrayOfByte[n] & 0x3) << 4 | (paramArrayOfByte[(n + 1)] & 0xFF) >> 4)];
        j = i + 1;
        arrayOfByte[i] = a[((paramArrayOfByte[(n + 1)] & 0xF) << 2)];
        i = j + 1;
        arrayOfByte[j] = 61;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */