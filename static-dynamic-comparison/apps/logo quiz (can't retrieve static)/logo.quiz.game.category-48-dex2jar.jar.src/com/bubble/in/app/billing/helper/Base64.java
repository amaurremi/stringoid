package com.bubble.in.app.billing.helper;

public class Base64
{
  private static final byte[] ALPHABET;
  private static final byte[] DECODABET;
  public static final boolean DECODE = false;
  public static final boolean ENCODE = true;
  private static final byte EQUALS_SIGN = 61;
  private static final byte EQUALS_SIGN_ENC = -1;
  private static final byte NEW_LINE = 10;
  private static final byte[] WEBSAFE_ALPHABET;
  private static final byte[] WEBSAFE_DECODABET;
  private static final byte WHITE_SPACE_ENC = -5;
  
  static
  {
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      WEBSAFE_ALPHABET = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9 };
      WEBSAFE_DECODABET = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9 };
      return;
    }
  }
  
  public static byte[] decode(String paramString)
    throws Base64DecoderException
  {
    paramString = paramString.getBytes();
    return decode(paramString, 0, paramString.length);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
    throws Base64DecoderException
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws Base64DecoderException
  {
    return decode(paramArrayOfByte, paramInt1, paramInt2, DECODABET);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
    throws Base64DecoderException
  {
    byte[] arrayOfByte1 = new byte[paramInt2 * 3 / 4 + 2];
    int k = 0;
    byte[] arrayOfByte2 = new byte[4];
    int m = 0;
    int j = 0;
    int n;
    if (m < paramInt2)
    {
      int i = (byte)(paramArrayOfByte1[(m + paramInt1)] & 0x7F);
      n = paramArrayOfByte2[i];
      if (n >= -5)
      {
        if (n < -1) {
          break label389;
        }
        if (i == 61)
        {
          n = paramInt2 - m;
          paramInt1 = (byte)(paramArrayOfByte1[(paramInt2 - 1 + paramInt1)] & 0x7F);
          if ((j == 0) || (j == 1)) {
            throw new Base64DecoderException("invalid padding byte '=' at byte offset " + m);
          }
          if (((j == 3) && (n > 2)) || ((j == 4) && (n > 1))) {
            throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + m);
          }
          if ((paramInt1 == 61) || (paramInt1 == 10)) {
            break label306;
          }
          throw new Base64DecoderException("encoded value has invalid trailing byte");
        }
        int i1 = j + 1;
        arrayOfByte2[j] = i;
        j = i1;
        n = k;
        if (i1 == 4)
        {
          n = k + decode4to3(arrayOfByte2, 0, arrayOfByte1, k, paramArrayOfByte2);
          j = 0;
        }
      }
    }
    for (;;)
    {
      m += 1;
      k = n;
      break;
      throw new Base64DecoderException("Bad Base64 input character at " + m + ": " + paramArrayOfByte1[(m + paramInt1)] + "(decimal)");
      label306:
      if (j != 0)
      {
        if (j == 1) {
          throw new Base64DecoderException("single trailing character at offset " + (paramInt2 - 1));
        }
        arrayOfByte2[j] = 61;
        k += decode4to3(arrayOfByte2, 0, arrayOfByte1, k, paramArrayOfByte2);
      }
      for (;;)
      {
        paramArrayOfByte1 = new byte[k];
        System.arraycopy(arrayOfByte1, 0, paramArrayOfByte1, 0, k);
        return paramArrayOfByte1;
      }
      label389:
      n = k;
    }
  }
  
  private static int decode4to3(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3)
  {
    if (paramArrayOfByte1[(paramInt1 + 2)] == 61)
    {
      paramArrayOfByte2[paramInt2] = ((byte)((paramArrayOfByte3[paramArrayOfByte1[paramInt1]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 1)]] << 24 >>> 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[(paramInt1 + 3)] == 61)
    {
      paramInt1 = paramArrayOfByte3[paramArrayOfByte1[paramInt1]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 1)]] << 24 >>> 12 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 2)]] << 24 >>> 18;
      paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >>> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
      return 2;
    }
    paramInt1 = paramArrayOfByte3[paramArrayOfByte1[paramInt1]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 1)]] << 24 >>> 12 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 2)]] << 24 >>> 18 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 3)]] << 24 >>> 24;
    paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)paramInt1);
    return 3;
  }
  
  public static byte[] decodeWebSafe(String paramString)
    throws Base64DecoderException
  {
    paramString = paramString.getBytes();
    return decodeWebSafe(paramString, 0, paramString.length);
  }
  
  public static byte[] decodeWebSafe(byte[] paramArrayOfByte)
    throws Base64DecoderException
  {
    return decodeWebSafe(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] decodeWebSafe(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws Base64DecoderException
  {
    return decode(paramArrayOfByte, paramInt1, paramInt2, WEBSAFE_DECODABET);
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, ALPHABET, true);
  }
  
  public static String encode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    paramArrayOfByte1 = encode(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, Integer.MAX_VALUE);
    paramInt1 = paramArrayOfByte1.length;
    for (;;)
    {
      if ((paramBoolean) || (paramInt1 <= 0) || (paramArrayOfByte1[(paramInt1 - 1)] != 61)) {
        return new String(paramArrayOfByte1, 0, paramInt1);
      }
      paramInt1 -= 1;
    }
  }
  
  public static byte[] encode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = (paramInt2 + 2) / 3 * 4;
    byte[] arrayOfByte = new byte[i / paramInt3 + i];
    int k = 0;
    i = 0;
    int j = 0;
    while (k < paramInt2 - 2)
    {
      m = paramArrayOfByte1[(k + paramInt1)] << 24 >>> 8 | paramArrayOfByte1[(k + 1 + paramInt1)] << 24 >>> 16 | paramArrayOfByte1[(k + 2 + paramInt1)] << 24 >>> 24;
      arrayOfByte[i] = paramArrayOfByte2[(m >>> 18)];
      arrayOfByte[(i + 1)] = paramArrayOfByte2[(m >>> 12 & 0x3F)];
      arrayOfByte[(i + 2)] = paramArrayOfByte2[(m >>> 6 & 0x3F)];
      arrayOfByte[(i + 3)] = paramArrayOfByte2[(m & 0x3F)];
      int n = j + 4;
      m = i;
      j = n;
      if (n == paramInt3)
      {
        arrayOfByte[(i + 4)] = 10;
        m = i + 1;
        j = 0;
      }
      k += 3;
      i = m + 4;
    }
    int m = i;
    if (k < paramInt2)
    {
      encode3to4(paramArrayOfByte1, k + paramInt1, paramInt2 - k, arrayOfByte, i, paramArrayOfByte2);
      paramInt1 = i;
      if (j + 4 == paramInt3)
      {
        arrayOfByte[(i + 4)] = 10;
        paramInt1 = i + 1;
      }
      m = paramInt1 + 4;
    }
    assert (m == arrayOfByte.length);
    return arrayOfByte;
  }
  
  private static byte[] encode3to4(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, byte[] paramArrayOfByte3)
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
      paramInt1 = j | i | k;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        i = 0;
        break label18;
      }
    }
    paramArrayOfByte2[paramInt3] = paramArrayOfByte3[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = paramArrayOfByte3[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = paramArrayOfByte3[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = paramArrayOfByte3[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = paramArrayOfByte3[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = paramArrayOfByte3[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = paramArrayOfByte3[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = paramArrayOfByte3[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = paramArrayOfByte3[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  public static String encodeWebSafe(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, WEBSAFE_ALPHABET, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/in/app/billing/helper/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */