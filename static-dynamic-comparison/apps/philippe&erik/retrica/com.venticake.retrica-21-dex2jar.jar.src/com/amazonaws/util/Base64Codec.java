package com.amazonaws.util;

class Base64Codec
{
  private final byte[] ALPAHBETS = CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    int k = 0;
    int i = 0;
    int j = paramArrayOfByte.length / 3;
    int m = paramArrayOfByte.length % 3;
    if (m == 0)
    {
      arrayOfByte = new byte[j * 4];
      j = 0;
      while (j < paramArrayOfByte.length)
      {
        encode3bytes(paramArrayOfByte, j, arrayOfByte, i);
        j += 3;
        i += 4;
      }
      return arrayOfByte;
    }
    byte[] arrayOfByte = new byte[(j + 1) * 4];
    j = 0;
    i = k;
    while (j < paramArrayOfByte.length - m)
    {
      encode3bytes(paramArrayOfByte, j, arrayOfByte, i);
      j += 3;
      i += 4;
    }
    switch (m)
    {
    }
    for (;;)
    {
      return arrayOfByte;
      encode1byte(paramArrayOfByte, j, arrayOfByte, i);
      continue;
      encode2bytes(paramArrayOfByte, j, arrayOfByte, i);
    }
  }
  
  void encode1byte(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = paramInt2 + 1;
    byte[] arrayOfByte = this.ALPAHBETS;
    paramInt1 = paramArrayOfByte1[paramInt1];
    paramArrayOfByte2[paramInt2] = arrayOfByte[(paramInt1 >>> 2 & 0x3F)];
    paramInt2 = i + 1;
    paramArrayOfByte2[i] = this.ALPAHBETS[((paramInt1 & 0x3) << 4)];
    paramArrayOfByte2[paramInt2] = 61;
    paramArrayOfByte2[(paramInt2 + 1)] = 61;
  }
  
  void encode2bytes(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = paramInt2 + 1;
    byte[] arrayOfByte = this.ALPAHBETS;
    int j = paramArrayOfByte1[paramInt1];
    paramArrayOfByte2[paramInt2] = arrayOfByte[(j >>> 2 & 0x3F)];
    paramInt2 = i + 1;
    arrayOfByte = this.ALPAHBETS;
    paramInt1 = paramArrayOfByte1[(paramInt1 + 1)];
    paramArrayOfByte2[i] = arrayOfByte[((j & 0x3) << 4 | paramInt1 >>> 4 & 0xF)];
    paramArrayOfByte2[paramInt2] = this.ALPAHBETS[((paramInt1 & 0xF) << 2)];
    paramArrayOfByte2[(paramInt2 + 1)] = 61;
  }
  
  void encode3bytes(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = paramInt2 + 1;
    byte[] arrayOfByte = this.ALPAHBETS;
    int j = paramInt1 + 1;
    paramInt1 = paramArrayOfByte1[paramInt1];
    paramArrayOfByte2[paramInt2] = arrayOfByte[(paramInt1 >>> 2 & 0x3F)];
    paramInt2 = i + 1;
    arrayOfByte = this.ALPAHBETS;
    int k = paramArrayOfByte1[j];
    paramArrayOfByte2[i] = arrayOfByte[((paramInt1 & 0x3) << 4 | k >>> 4 & 0xF)];
    arrayOfByte = this.ALPAHBETS;
    paramInt1 = paramArrayOfByte1[(j + 1)];
    paramArrayOfByte2[paramInt2] = arrayOfByte[((k & 0xF) << 2 | paramInt1 >>> 6 & 0x3)];
    paramArrayOfByte2[(paramInt2 + 1)] = this.ALPAHBETS[(paramInt1 & 0x3F)];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/Base64Codec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */