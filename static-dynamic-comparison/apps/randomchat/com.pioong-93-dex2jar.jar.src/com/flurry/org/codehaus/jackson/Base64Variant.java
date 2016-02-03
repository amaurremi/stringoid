package com.flurry.org.codehaus.jackson;

import java.util.Arrays;

public final class Base64Variant
{
  public static final int BASE64_VALUE_INVALID = -1;
  public static final int BASE64_VALUE_PADDING = -2;
  static final char PADDING_CHAR_NONE = '\000';
  private final int[] _asciiToBase64 = new int[''];
  private final byte[] _base64ToAsciiB = new byte[64];
  private final char[] _base64ToAsciiC = new char[64];
  final int _maxLineLength;
  final String _name;
  final char _paddingChar;
  final boolean _usesPadding;
  
  public Base64Variant(Base64Variant paramBase64Variant, String paramString, int paramInt)
  {
    this(paramBase64Variant, paramString, paramBase64Variant._usesPadding, paramBase64Variant._paddingChar, paramInt);
  }
  
  public Base64Variant(Base64Variant paramBase64Variant, String paramString, boolean paramBoolean, char paramChar, int paramInt)
  {
    this._name = paramString;
    paramString = paramBase64Variant._base64ToAsciiB;
    System.arraycopy(paramString, 0, this._base64ToAsciiB, 0, paramString.length);
    paramString = paramBase64Variant._base64ToAsciiC;
    System.arraycopy(paramString, 0, this._base64ToAsciiC, 0, paramString.length);
    paramBase64Variant = paramBase64Variant._asciiToBase64;
    System.arraycopy(paramBase64Variant, 0, this._asciiToBase64, 0, paramBase64Variant.length);
    this._usesPadding = paramBoolean;
    this._paddingChar = paramChar;
    this._maxLineLength = paramInt;
  }
  
  public Base64Variant(String paramString1, String paramString2, boolean paramBoolean, char paramChar, int paramInt)
  {
    this._name = paramString1;
    this._usesPadding = paramBoolean;
    this._paddingChar = paramChar;
    this._maxLineLength = paramInt;
    int i = paramString2.length();
    if (i != 64) {
      throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + i + ")");
    }
    paramString2.getChars(0, i, this._base64ToAsciiC, 0);
    Arrays.fill(this._asciiToBase64, -1);
    paramInt = 0;
    while (paramInt < i)
    {
      int j = this._base64ToAsciiC[paramInt];
      this._base64ToAsciiB[paramInt] = ((byte)j);
      this._asciiToBase64[j] = paramInt;
      paramInt += 1;
    }
    if (paramBoolean) {
      this._asciiToBase64[paramChar] = -2;
    }
  }
  
  public int decodeBase64Byte(byte paramByte)
  {
    if (paramByte <= Byte.MAX_VALUE) {
      return this._asciiToBase64[paramByte];
    }
    return -1;
  }
  
  public int decodeBase64Char(char paramChar)
  {
    if (paramChar <= '') {
      return this._asciiToBase64[paramChar];
    }
    return -1;
  }
  
  public int decodeBase64Char(int paramInt)
  {
    if (paramInt <= 127) {
      return this._asciiToBase64[paramInt];
    }
    return -1;
  }
  
  public String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, false);
  }
  
  public String encode(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int k = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder((k >> 2) + k + (k >> 3));
    if (paramBoolean) {
      localStringBuilder.append('"');
    }
    int i = getMaxLineLength() >> 2;
    int m;
    for (int j = 0; j <= k - 3; j = m + 1)
    {
      int n = j + 1;
      j = paramArrayOfByte[j];
      m = n + 1;
      encodeBase64Chunk(localStringBuilder, (j << 8 | paramArrayOfByte[n] & 0xFF) << 8 | paramArrayOfByte[m] & 0xFF);
      j = i - 1;
      i = j;
      if (j <= 0)
      {
        localStringBuilder.append('\\');
        localStringBuilder.append('n');
        i = getMaxLineLength() >> 2;
      }
    }
    k -= j;
    if (k > 0)
    {
      m = j + 1;
      j = paramArrayOfByte[j] << 16;
      i = j;
      if (k == 2) {
        i = j | (paramArrayOfByte[m] & 0xFF) << 8;
      }
      encodeBase64Partial(localStringBuilder, i, k);
    }
    for (;;)
    {
      if (paramBoolean) {
        localStringBuilder.append('"');
      }
      return localStringBuilder.toString();
    }
  }
  
  public byte encodeBase64BitsAsByte(int paramInt)
  {
    return this._base64ToAsciiB[paramInt];
  }
  
  public char encodeBase64BitsAsChar(int paramInt)
  {
    return this._base64ToAsciiC[paramInt];
  }
  
  public int encodeBase64Chunk(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = this._base64ToAsciiB[(paramInt1 >> 18 & 0x3F)];
    paramInt2 = i + 1;
    paramArrayOfByte[i] = this._base64ToAsciiB[(paramInt1 >> 12 & 0x3F)];
    i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = this._base64ToAsciiB[(paramInt1 >> 6 & 0x3F)];
    paramArrayOfByte[i] = this._base64ToAsciiB[(paramInt1 & 0x3F)];
    return i + 1;
  }
  
  public int encodeBase64Chunk(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfChar[paramInt2] = this._base64ToAsciiC[(paramInt1 >> 18 & 0x3F)];
    paramInt2 = i + 1;
    paramArrayOfChar[i] = this._base64ToAsciiC[(paramInt1 >> 12 & 0x3F)];
    i = paramInt2 + 1;
    paramArrayOfChar[paramInt2] = this._base64ToAsciiC[(paramInt1 >> 6 & 0x3F)];
    paramArrayOfChar[i] = this._base64ToAsciiC[(paramInt1 & 0x3F)];
    return i + 1;
  }
  
  public void encodeBase64Chunk(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt >> 18 & 0x3F)]);
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt >> 12 & 0x3F)]);
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt >> 6 & 0x3F)]);
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt & 0x3F)]);
  }
  
  public int encodeBase64Partial(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    int m = paramInt3 + 1;
    paramArrayOfByte[paramInt3] = this._base64ToAsciiB[(paramInt1 >> 18 & 0x3F)];
    int k = m + 1;
    paramArrayOfByte[m] = this._base64ToAsciiB[(paramInt1 >> 12 & 0x3F)];
    int j;
    int i;
    if (this._usesPadding)
    {
      j = (byte)this._paddingChar;
      m = k + 1;
      if (paramInt2 == 2)
      {
        i = this._base64ToAsciiB[(paramInt1 >> 6 & 0x3F)];
        paramArrayOfByte[k] = i;
        paramInt3 = m + 1;
        paramArrayOfByte[m] = j;
      }
    }
    do
    {
      return paramInt3;
      i = j;
      break;
      paramInt3 = k;
    } while (paramInt2 != 2);
    paramArrayOfByte[k] = this._base64ToAsciiB[(paramInt1 >> 6 & 0x3F)];
    return k + 1;
  }
  
  public int encodeBase64Partial(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int k = paramInt3 + 1;
    paramArrayOfChar[paramInt3] = this._base64ToAsciiC[(paramInt1 >> 18 & 0x3F)];
    int j = k + 1;
    paramArrayOfChar[k] = this._base64ToAsciiC[(paramInt1 >> 12 & 0x3F)];
    int i;
    if (this._usesPadding)
    {
      k = j + 1;
      if (paramInt2 == 2)
      {
        i = this._base64ToAsciiC[(paramInt1 >> 6 & 0x3F)];
        paramArrayOfChar[j] = i;
        paramInt3 = k + 1;
        paramArrayOfChar[k] = this._paddingChar;
      }
    }
    do
    {
      return paramInt3;
      i = this._paddingChar;
      break;
      paramInt3 = j;
    } while (paramInt2 != 2);
    paramArrayOfChar[j] = this._base64ToAsciiC[(paramInt1 >> 6 & 0x3F)];
    return j + 1;
  }
  
  public void encodeBase64Partial(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt1 >> 18 & 0x3F)]);
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt1 >> 12 & 0x3F)]);
    if (this._usesPadding) {
      if (paramInt2 == 2)
      {
        c = this._base64ToAsciiC[(paramInt1 >> 6 & 0x3F)];
        paramStringBuilder.append(c);
        paramStringBuilder.append(this._paddingChar);
      }
    }
    while (paramInt2 != 2) {
      for (;;)
      {
        return;
        char c = this._paddingChar;
      }
    }
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt1 >> 6 & 0x3F)]);
  }
  
  public int getMaxLineLength()
  {
    return this._maxLineLength;
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public byte getPaddingByte()
  {
    return (byte)this._paddingChar;
  }
  
  public char getPaddingChar()
  {
    return this._paddingChar;
  }
  
  public String toString()
  {
    return this._name;
  }
  
  public boolean usesPadding()
  {
    return this._usesPadding;
  }
  
  public boolean usesPaddingChar(char paramChar)
  {
    return paramChar == this._paddingChar;
  }
  
  public boolean usesPaddingChar(int paramInt)
  {
    return paramInt == this._paddingChar;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/Base64Variant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */