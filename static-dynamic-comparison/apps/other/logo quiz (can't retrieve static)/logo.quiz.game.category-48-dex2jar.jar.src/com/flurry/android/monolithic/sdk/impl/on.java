package com.flurry.android.monolithic.sdk.impl;

import java.util.Arrays;

public final class on
{
  final String a;
  final boolean b;
  final char c;
  final int d;
  private final int[] e = new int[''];
  private final char[] f = new char[64];
  private final byte[] g = new byte[64];
  
  public on(on paramon, String paramString, int paramInt)
  {
    this(paramon, paramString, paramon.b, paramon.c, paramInt);
  }
  
  public on(on paramon, String paramString, boolean paramBoolean, char paramChar, int paramInt)
  {
    this.a = paramString;
    paramString = paramon.g;
    System.arraycopy(paramString, 0, this.g, 0, paramString.length);
    paramString = paramon.f;
    System.arraycopy(paramString, 0, this.f, 0, paramString.length);
    paramon = paramon.e;
    System.arraycopy(paramon, 0, this.e, 0, paramon.length);
    this.b = paramBoolean;
    this.c = paramChar;
    this.d = paramInt;
  }
  
  public on(String paramString1, String paramString2, boolean paramBoolean, char paramChar, int paramInt)
  {
    this.a = paramString1;
    this.b = paramBoolean;
    this.c = paramChar;
    this.d = paramInt;
    int j = paramString2.length();
    if (j != 64) {
      throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + j + ")");
    }
    paramString2.getChars(0, j, this.f, 0);
    Arrays.fill(this.e, -1);
    paramInt = i;
    while (paramInt < j)
    {
      i = this.f[paramInt];
      this.g[paramInt] = ((byte)i);
      this.e[i] = paramInt;
      paramInt += 1;
    }
    if (paramBoolean) {
      this.e[paramChar] = -2;
    }
  }
  
  public int a(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int j = paramInt3 + 1;
    paramArrayOfChar[paramInt3] = this.f[(paramInt1 >> 18 & 0x3F)];
    paramInt3 = j + 1;
    paramArrayOfChar[j] = this.f[(paramInt1 >> 12 & 0x3F)];
    if (this.b)
    {
      j = paramInt3 + 1;
      if (paramInt2 == 2) {}
      for (int i = this.f[(paramInt1 >> 6 & 0x3F)];; i = this.c)
      {
        paramArrayOfChar[paramInt3] = i;
        paramArrayOfChar[j] = this.c;
        return j + 1;
      }
    }
    if (paramInt2 == 2)
    {
      paramArrayOfChar[paramInt3] = this.f[(paramInt1 >> 6 & 0x3F)];
      return paramInt3 + 1;
    }
    return paramInt3;
  }
  
  public int a(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfChar[paramInt2] = this.f[(paramInt1 >> 18 & 0x3F)];
    paramInt2 = i + 1;
    paramArrayOfChar[i] = this.f[(paramInt1 >> 12 & 0x3F)];
    i = paramInt2 + 1;
    paramArrayOfChar[paramInt2] = this.f[(paramInt1 >> 6 & 0x3F)];
    paramArrayOfChar[i] = this.f[(paramInt1 & 0x3F)];
    return i + 1;
  }
  
  public String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int k = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder((k >> 2) + k + (k >> 3));
    if (paramBoolean) {
      localStringBuilder.append('"');
    }
    int j = c();
    int i = 0;
    j >>= 2;
    int m;
    while (i <= k - 3)
    {
      int n = i + 1;
      i = paramArrayOfByte[i];
      m = n + 1;
      a(localStringBuilder, (i << 8 | paramArrayOfByte[n] & 0xFF) << 8 | paramArrayOfByte[m] & 0xFF);
      j -= 1;
      i = j;
      if (j <= 0)
      {
        localStringBuilder.append('\\');
        localStringBuilder.append('n');
        i = c() >> 2;
      }
      j = i;
      i = m + 1;
    }
    k -= i;
    if (k > 0)
    {
      m = i + 1;
      j = paramArrayOfByte[i] << 16;
      i = j;
      if (k == 2) {
        i = j | (paramArrayOfByte[m] & 0xFF) << 8;
      }
      a(localStringBuilder, i, k);
    }
    if (paramBoolean) {
      localStringBuilder.append('"');
    }
    return localStringBuilder.toString();
  }
  
  public void a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append(this.f[(paramInt >> 18 & 0x3F)]);
    paramStringBuilder.append(this.f[(paramInt >> 12 & 0x3F)]);
    paramStringBuilder.append(this.f[(paramInt >> 6 & 0x3F)]);
    paramStringBuilder.append(this.f[(paramInt & 0x3F)]);
  }
  
  public void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append(this.f[(paramInt1 >> 18 & 0x3F)]);
    paramStringBuilder.append(this.f[(paramInt1 >> 12 & 0x3F)]);
    if (this.b) {
      if (paramInt2 == 2)
      {
        c1 = this.f[(paramInt1 >> 6 & 0x3F)];
        paramStringBuilder.append(c1);
        paramStringBuilder.append(this.c);
      }
    }
    while (paramInt2 != 2) {
      for (;;)
      {
        return;
        char c1 = this.c;
      }
    }
    paramStringBuilder.append(this.f[(paramInt1 >> 6 & 0x3F)]);
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(char paramChar)
  {
    return paramChar == this.c;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == this.c;
  }
  
  public char b()
  {
    return this.c;
  }
  
  public int b(char paramChar)
  {
    if (paramChar <= '') {
      return this.e[paramChar];
    }
    return -1;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/on.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */