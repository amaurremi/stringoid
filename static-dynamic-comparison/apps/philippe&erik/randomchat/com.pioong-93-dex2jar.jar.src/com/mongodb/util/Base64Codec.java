package com.mongodb.util;

public class Base64Codec
{
  private static final int BYTES_PER_ENCODED_BLOCK = 4;
  private static final int BYTES_PER_UNENCODED_BLOCK = 3;
  private static final int[] DecodeTable;
  private static final byte[] EncodeTable = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte PAD = 61;
  private static final int SixBitMask = 63;
  
  static
  {
    DecodeTable = new int[''];
    int i = 0;
    while (i < EncodeTable.length)
    {
      DecodeTable[EncodeTable[i]] = i;
      i += 1;
    }
  }
  
  public byte[] decode(String paramString)
  {
    int i;
    byte[] arrayOfByte;
    int j;
    if (paramString.endsWith("=="))
    {
      i = 2;
      arrayOfByte = new byte[paramString.length() * 3 / 4 - i];
      j = 0;
      i = 0;
    }
    for (;;)
    {
      int n;
      int k;
      int m;
      if (i < paramString.length())
      {
        n = DecodeTable[paramString.charAt(i)];
        k = DecodeTable[paramString.charAt(i + 1)];
        m = j + 1;
        arrayOfByte[j] = ((byte)((n << 2 | k >> 4) & 0xFF));
        if (m < arrayOfByte.length) {
          break label114;
        }
      }
      label114:
      do
      {
        return arrayOfByte;
        if (paramString.endsWith("="))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        n = DecodeTable[paramString.charAt(i + 2)];
        j = m + 1;
        arrayOfByte[m] = ((byte)((k << 4 | n >> 2) & 0xFF));
      } while (j >= arrayOfByte.length);
      arrayOfByte[j] = ((byte)((n << 6 | DecodeTable[paramString.charAt(i + 3)]) & 0xFF));
      i += 4;
      j += 1;
    }
  }
  
  public String encode(byte[] paramArrayOfByte)
  {
    int m = 0;
    int j = 0;
    int k = paramArrayOfByte.length / 3;
    if (paramArrayOfByte.length % 3 == 0) {}
    byte[] arrayOfByte;
    for (int i = 0;; i = 4)
    {
      arrayOfByte = new byte[k * 4 + i];
      int i2 = paramArrayOfByte.length;
      k = 0;
      i = 0;
      while (k < i2)
      {
        int i1 = paramArrayOfByte[k];
        int n = (m + 1) % 3;
        m = i1;
        if (i1 < 0) {
          m = i1 + 256;
        }
        m = (j << 8) + m;
        j = i;
        if (n == 0)
        {
          j = i + 1;
          arrayOfByte[i] = EncodeTable[(m >> 18 & 0x3F)];
          i = j + 1;
          arrayOfByte[j] = EncodeTable[(m >> 12 & 0x3F)];
          i1 = i + 1;
          arrayOfByte[i] = EncodeTable[(m >> 6 & 0x3F)];
          j = i1 + 1;
          arrayOfByte[i1] = EncodeTable[(m & 0x3F)];
        }
        k += 1;
        i = j;
        j = m;
        m = n;
      }
    }
    switch (m)
    {
    }
    for (;;)
    {
      return new String(arrayOfByte);
      k = i + 1;
      arrayOfByte[i] = EncodeTable[(j >> 2 & 0x3F)];
      i = k + 1;
      arrayOfByte[k] = EncodeTable[(j << 4 & 0x3F)];
      arrayOfByte[i] = 61;
      arrayOfByte[(i + 1)] = 61;
      continue;
      k = i + 1;
      arrayOfByte[i] = EncodeTable[(j >> 10 & 0x3F)];
      i = k + 1;
      arrayOfByte[k] = EncodeTable[(j >> 4 & 0x3F)];
      arrayOfByte[i] = EncodeTable[(j << 2 & 0x3F)];
      arrayOfByte[(i + 1)] = 61;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/Base64Codec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */