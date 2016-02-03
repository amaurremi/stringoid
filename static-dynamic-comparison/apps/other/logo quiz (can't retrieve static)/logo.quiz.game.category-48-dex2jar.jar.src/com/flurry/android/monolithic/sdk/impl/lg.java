package com.flurry.android.monolithic.sdk.impl;

public class lg
{
  private static final ThreadLocal<lj> a = new lh();
  private static final ThreadLocal<lk> b = new li();
  
  public static int a(double paramDouble, byte[] paramArrayOfByte, int paramInt)
  {
    long l = Double.doubleToRawLongBits(paramDouble);
    int i = (int)(l & 0xFFFFFFFFFFFFFFFF);
    int j = (int)(l >>> 32 & 0xFFFFFFFFFFFFFFFF);
    paramArrayOfByte[paramInt] = ((byte)(i & 0xFF));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(j & 0xFF));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(j >>> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(i >>> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(i >>> 16 & 0xFF));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(j >>> 16 & 0xFF));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(j >>> 24 & 0xFF));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(i >>> 24 & 0xFF));
    return 8;
  }
  
  public static int a(float paramFloat, byte[] paramArrayOfByte, int paramInt)
  {
    int i = Float.floatToRawIntBits(paramFloat);
    paramArrayOfByte[paramInt] = ((byte)(i & 0xFF));
    paramArrayOfByte[(1 + paramInt)] = ((byte)(i >>> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(i >>> 16 & 0xFF));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(i >>> 24 & 0xFF));
    return 4;
  }
  
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt1 << 1 ^ paramInt1 >> 31;
    int j;
    if ((i & 0xFFFFFF80) != 0)
    {
      j = paramInt2 + 1;
      paramArrayOfByte[paramInt2] = ((byte)((i | 0x80) & 0xFF));
      int k = i >>> 7;
      i = j;
      paramInt1 = k;
      if (k > 127)
      {
        paramInt1 = j + 1;
        paramArrayOfByte[j] = ((byte)((k | 0x80) & 0xFF));
        i = k >>> 7;
        if (i <= 127) {
          break label170;
        }
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)((i | 0x80) & 0xFF));
        k = i >>> 7;
        i = j;
        paramInt1 = k;
        if (k > 127)
        {
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)((k | 0x80) & 0xFF));
          i = k >>> 7;
        }
      }
    }
    for (;;)
    {
      paramArrayOfByte[paramInt1] = ((byte)i);
      return paramInt1 + 1 - paramInt2;
      j = paramInt1;
      paramInt1 = i;
      i = j;
      continue;
      label170:
      continue;
      paramInt1 = paramInt2;
    }
  }
  
  public static int a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramLong = paramLong << 1 ^ paramLong >> 63;
    int i;
    if ((0xFFFFFFFFFFFFFF80 & paramLong) != 0L)
    {
      int k = paramInt + 1;
      paramArrayOfByte[paramInt] = ((byte)(int)((0x80 | paramLong) & 0xFF));
      long l = paramLong >>> 7;
      i = k;
      paramLong = l;
      if (l > 127L)
      {
        int j = k + 1;
        paramArrayOfByte[k] = ((byte)(int)((0x80 | l) & 0xFF));
        l >>>= 7;
        i = j;
        paramLong = l;
        if (l > 127L)
        {
          k = j + 1;
          paramArrayOfByte[j] = ((byte)(int)((0x80 | l) & 0xFF));
          l >>>= 7;
          i = k;
          paramLong = l;
          if (l <= 127L) {
            break label420;
          }
          j = k + 1;
          paramArrayOfByte[k] = ((byte)(int)((0x80 | l) & 0xFF));
          l >>>= 7;
          i = j;
          paramLong = l;
          if (l > 127L)
          {
            k = j + 1;
            paramArrayOfByte[j] = ((byte)(int)((0x80 | l) & 0xFF));
            l >>>= 7;
            i = k;
            paramLong = l;
            if (l <= 127L) {
              break label420;
            }
            j = k + 1;
            paramArrayOfByte[k] = ((byte)(int)((0x80 | l) & 0xFF));
            l >>>= 7;
            i = j;
            paramLong = l;
            if (l > 127L)
            {
              k = j + 1;
              paramArrayOfByte[j] = ((byte)(int)((0x80 | l) & 0xFF));
              l >>>= 7;
              i = k;
              paramLong = l;
              if (l <= 127L) {
                break label420;
              }
              j = k + 1;
              paramArrayOfByte[k] = ((byte)(int)((0x80 | l) & 0xFF));
              l >>>= 7;
              i = j;
              paramLong = l;
              if (l > 127L)
              {
                i = j + 1;
                paramArrayOfByte[j] = ((byte)(int)((0x80 | l) & 0xFF));
                paramLong = l >>> 7;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramArrayOfByte[i] = ((byte)(int)paramLong);
      return i + 1 - paramInt;
      continue;
      label420:
      continue;
      i = paramInt;
    }
  }
  
  public static int a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramArrayOfByte[paramInt] = i;
      return 1;
    }
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    int j = paramInt3;
    int i = paramInt1;
    while ((i < paramInt1 + paramInt2) && (j < paramInt3 + paramInt4))
    {
      int k = paramArrayOfByte1[i] & 0xFF;
      int m = paramArrayOfByte2[j] & 0xFF;
      if (k != m) {
        return k - m;
      }
      i += 1;
      j += 1;
    }
    return paramInt2 - paramInt4;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/lg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */