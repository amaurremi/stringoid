package com.google.tagmanager.protobuf;

final class u
{
  private static int C(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1;
  }
  
  public static int b(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    int m;
    int j;
    int k;
    if (paramInt1 != 0)
    {
      if (paramInt2 >= paramInt3) {
        return paramInt1;
      }
      m = (byte)paramInt1;
      if (m < -32)
      {
        if ((m < -62) || (paramArrayOfByte[paramInt2] > -65)) {
          return -1;
        }
      }
      else
      {
        if (m < -16)
        {
          i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
          if (i == 0)
          {
            i = paramInt2 + 1;
            j = paramArrayOfByte[paramInt2];
            paramInt2 = j;
            paramInt1 = i;
            if (i >= paramInt3) {
              return C(m, j);
            }
          }
          else
          {
            paramInt1 = paramInt2;
            paramInt2 = i;
          }
          if ((paramInt2 <= -65) && ((m != -32) || (paramInt2 >= -96)) && ((m != -19) || (paramInt2 < -96)))
          {
            i = paramInt1 + 1;
            if (paramArrayOfByte[paramInt1] <= -65) {
              break label278;
            }
          }
          return -1;
        }
        i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
        j = 0;
        if (i == 0)
        {
          k = paramInt2 + 1;
          i = paramArrayOfByte[paramInt2];
          if (k < paramInt3) {
            break label286;
          }
          return C(m, i);
        }
        paramInt1 = (byte)(paramInt1 >> 16);
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        j = paramInt2 + 1;
        k = paramArrayOfByte[paramInt2];
        paramInt1 = k;
        paramInt2 = j;
        if (j >= paramInt3) {
          return i(m, i, k);
        }
      }
      if ((i <= -65) && ((m << 28) + (i + 112) >> 30 == 0) && (paramInt1 <= -65))
      {
        i = paramInt2 + 1;
        if (paramArrayOfByte[paramInt2] <= -65) {}
      }
      else
      {
        return -1;
        i = paramInt2 + 1;
      }
      label278:
      return k(paramArrayOfByte, i, paramInt3);
      label286:
      paramInt1 = j;
      paramInt2 = k;
    }
  }
  
  private static int fy(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  private static int i(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65) || (paramInt3 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1 ^ paramInt3 << 16;
  }
  
  public static boolean j(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return k(paramArrayOfByte, paramInt1, paramInt2) == 0;
  }
  
  public static int k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (paramArrayOfByte[paramInt1] >= 0)) {
      paramInt1 += 1;
    }
    if (paramInt1 >= paramInt2) {
      return 0;
    }
    return l(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static int l(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        paramInt1 = 0;
      }
      int i;
      int j;
      do
      {
        return paramInt1;
        i = paramInt1 + 1;
        j = paramArrayOfByte[paramInt1];
        if (j >= 0) {
          break label210;
        }
        if (j >= -32) {
          break;
        }
        paramInt1 = j;
      } while (i >= paramInt2);
      if (j >= -62)
      {
        paramInt1 = i + 1;
        if (paramArrayOfByte[i] <= -65) {}
      }
      else
      {
        return -1;
        if (j < -16)
        {
          if (i >= paramInt2 - 1) {
            return m(paramArrayOfByte, i, paramInt2);
          }
          int k = i + 1;
          paramInt1 = paramArrayOfByte[i];
          if ((paramInt1 <= -65) && ((j != -32) || (paramInt1 >= -96)) && ((j != -19) || (paramInt1 < -96)))
          {
            paramInt1 = k + 1;
            if (paramArrayOfByte[k] <= -65) {}
          }
          else
          {
            return -1;
          }
        }
        else
        {
          if (i >= paramInt2 - 2) {
            return m(paramArrayOfByte, i, paramInt2);
          }
          paramInt1 = i + 1;
          i = paramArrayOfByte[i];
          if ((i <= -65) && ((j << 28) + (i + 112) >> 30 == 0))
          {
            i = paramInt1 + 1;
            if (paramArrayOfByte[paramInt1] <= -65)
            {
              paramInt1 = i + 1;
              if (paramArrayOfByte[i] <= -65) {
                break label207;
              }
            }
          }
          return -1;
        }
      }
      label207:
      continue;
      label210:
      paramInt1 = i;
    }
  }
  
  private static int m(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    switch (paramInt2 - paramInt1)
    {
    default: 
      throw new AssertionError();
    case 0: 
      return fy(i);
    case 1: 
      return C(i, paramArrayOfByte[paramInt1]);
    }
    return i(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
  }
  
  public static boolean q(byte[] paramArrayOfByte)
  {
    return j(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */