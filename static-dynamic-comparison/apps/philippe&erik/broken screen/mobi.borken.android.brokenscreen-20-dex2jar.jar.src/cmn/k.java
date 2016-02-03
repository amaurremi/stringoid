package cmn;

import java.text.ParseException;

public class k
{
  public static final byte[] a;
  public static final byte[] b;
  private static final byte[] d;
  private static final byte[] e;
  
  static
  {
    if (!k.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      a = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      b = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      d = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9 };
      e = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9 };
      return;
    }
  }
  
  private static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3)
  {
    if (paramArrayOfByte1[2] == 61)
    {
      paramArrayOfByte2[paramInt] = ((byte)((paramArrayOfByte3[paramArrayOfByte1[0]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[1]] << 24 >>> 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[3] == 61)
    {
      i = paramArrayOfByte3[paramArrayOfByte1[0]];
      i = paramArrayOfByte3[paramArrayOfByte1[1]] << 24 >>> 12 | i << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[2]] << 24 >>> 18;
      paramArrayOfByte2[paramInt] = ((byte)(i >>> 16));
      paramArrayOfByte2[(paramInt + 1)] = ((byte)(i >>> 8));
      return 2;
    }
    int i = paramArrayOfByte3[paramArrayOfByte1[0]];
    i = paramArrayOfByte3[paramArrayOfByte1[1]] << 24 >>> 12 | i << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[2]] << 24 >>> 18 | paramArrayOfByte3[paramArrayOfByte1[3]] << 24 >>> 24;
    paramArrayOfByte2[paramInt] = ((byte)(i >> 16));
    paramArrayOfByte2[(paramInt + 1)] = ((byte)(i >> 8));
    paramArrayOfByte2[(paramInt + 2)] = ((byte)i);
    return 3;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length, a, true);
  }
  
  private static String a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    int i = (paramInt + 2) / 3 * 4;
    byte[] arrayOfByte = new byte[i + i / Integer.MAX_VALUE];
    int j = 0;
    i = 0;
    int k = 0;
    int n;
    while (k < paramInt - 2)
    {
      m = paramArrayOfByte1[k] << 24 >>> 8 | paramArrayOfByte1[(k + 1)] << 24 >>> 16 | paramArrayOfByte1[(k + 2)] << 24 >>> 24;
      arrayOfByte[i] = paramArrayOfByte2[(m >>> 18)];
      arrayOfByte[(i + 1)] = paramArrayOfByte2[(m >>> 12 & 0x3F)];
      arrayOfByte[(i + 2)] = paramArrayOfByte2[(m >>> 6 & 0x3F)];
      arrayOfByte[(i + 3)] = paramArrayOfByte2[(m & 0x3F)];
      n = j + 4;
      j = n;
      m = i;
      if (n == Integer.MAX_VALUE)
      {
        arrayOfByte[(i + 4)] = 10;
        m = i + 1;
        j = 0;
      }
      i = m + 4;
      k += 3;
    }
    int m = i;
    if (k < paramInt)
    {
      n = paramInt - k;
      if (n <= 0) {
        break label353;
      }
      paramInt = paramArrayOfByte1[k] << 24 >>> 8;
      if (n <= 1) {
        break label358;
      }
      m = paramArrayOfByte1[(k + 1)] << 24 >>> 16;
      label242:
      if (n <= 2) {
        break label364;
      }
      k = paramArrayOfByte1[(k + 2)] << 24 >>> 24;
      label262:
      paramInt = k | paramInt | m;
      switch (n)
      {
      }
    }
    for (;;)
    {
      paramInt = i;
      if (j + 4 == Integer.MAX_VALUE)
      {
        arrayOfByte[(i + 4)] = 10;
        paramInt = i + 1;
      }
      m = paramInt + 4;
      if ((c) || (m == arrayOfByte.length)) {
        break label532;
      }
      throw new AssertionError();
      label353:
      paramInt = 0;
      break;
      label358:
      m = 0;
      break label242;
      label364:
      k = 0;
      break label262;
      arrayOfByte[i] = paramArrayOfByte2[(paramInt >>> 18)];
      arrayOfByte[(i + 1)] = paramArrayOfByte2[(paramInt >>> 12 & 0x3F)];
      arrayOfByte[(i + 2)] = paramArrayOfByte2[(paramInt >>> 6 & 0x3F)];
      arrayOfByte[(i + 3)] = paramArrayOfByte2[(paramInt & 0x3F)];
      continue;
      arrayOfByte[i] = paramArrayOfByte2[(paramInt >>> 18)];
      arrayOfByte[(i + 1)] = paramArrayOfByte2[(paramInt >>> 12 & 0x3F)];
      arrayOfByte[(i + 2)] = paramArrayOfByte2[(paramInt >>> 6 & 0x3F)];
      arrayOfByte[(i + 3)] = 61;
      continue;
      arrayOfByte[i] = paramArrayOfByte2[(paramInt >>> 18)];
      arrayOfByte[(i + 1)] = paramArrayOfByte2[(paramInt >>> 12 & 0x3F)];
      arrayOfByte[(i + 2)] = 61;
      arrayOfByte[(i + 3)] = 61;
    }
    label532:
    paramInt = arrayOfByte.length;
    while ((!paramBoolean) && (paramInt > 0) && (arrayOfByte[(paramInt - 1)] == 61)) {
      paramInt -= 1;
    }
    return new String(arrayOfByte, 0, paramInt);
  }
  
  public static byte[] a(String paramString)
  {
    paramString = paramString.getBytes();
    return a(paramString, paramString.length, d);
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte1 = new byte[paramInt * 3 / 4 + 2];
    byte[] arrayOfByte2 = new byte[4];
    int m = 0;
    int k = 0;
    int j = 0;
    int n;
    if (m < paramInt)
    {
      int i = (byte)(paramArrayOfByte1[m] & 0x7F);
      n = paramArrayOfByte2[i];
      if (n >= -5)
      {
        if (n < -1) {
          break label394;
        }
        if (i == 61)
        {
          n = paramInt - m;
          int i1 = (byte)(paramArrayOfByte1[(paramInt - 1)] & 0x7F);
          if ((k == 0) || (k == 1)) {
            throw new ParseException("invalid padding byte '=' at byte offset " + m, m);
          }
          if (((k == 3) && (n > 2)) || ((k == 4) && (n > 1))) {
            throw new ParseException("padding byte '=' falsely signals end of encoded value at offset " + m, m);
          }
          if ((i1 == 61) || (i1 == 10)) {
            break label300;
          }
          throw new ParseException("encoded value has invalid trailing byte", -1);
        }
        n = k + 1;
        arrayOfByte2[k] = i;
        if (n != 4) {
          break label383;
        }
        k = a(arrayOfByte2, arrayOfByte1, j, paramArrayOfByte2) + j;
        j = 0;
      }
    }
    for (;;)
    {
      n = m + 1;
      m = k;
      k = j;
      j = m;
      m = n;
      break;
      throw new ParseException("Bad Base64 input character at " + m + ": " + paramArrayOfByte1[m] + "(decimal)", m);
      label300:
      m = j;
      if (k != 0)
      {
        if (k == 1) {
          throw new ParseException("single trailing character at offset " + (paramInt - 1), paramInt - 1);
        }
        arrayOfByte2[k] = 61;
        m = j + a(arrayOfByte2, arrayOfByte1, j, paramArrayOfByte2);
      }
      paramArrayOfByte1 = new byte[m];
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte1, 0, m);
      return paramArrayOfByte1;
      label383:
      k = j;
      j = n;
      continue;
      label394:
      n = j;
      j = k;
      k = n;
    }
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length, b, false);
  }
  
  public static byte[] b(String paramString)
  {
    paramString = paramString.getBytes();
    return a(paramString, paramString.length, e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */