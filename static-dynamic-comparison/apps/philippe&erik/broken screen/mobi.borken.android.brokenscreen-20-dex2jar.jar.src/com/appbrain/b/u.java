package com.appbrain.b;

final class u
{
  private static int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65) || (paramInt3 > -65)) {
      return -1;
    }
    return paramInt2 << 8 ^ paramInt1 ^ paramInt3 << 16;
  }
  
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
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
              return a(m, j);
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
          return a(m, i);
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
          return a(m, i, k);
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
      return a(paramArrayOfByte, i, paramInt3);
      label286:
      paramInt1 = j;
      paramInt2 = k;
    }
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while ((i < paramInt2) && (paramArrayOfByte[i] >= 0)) {
      i += 1;
    }
    paramInt1 = i;
    if (i >= paramInt2)
    {
      paramInt1 = 0;
      return paramInt1;
      label31:
      paramInt1 = i;
    }
    label88:
    label90:
    label166:
    label168:
    do
    {
      int j;
      int k;
      do
      {
        do
        {
          if (paramInt1 >= paramInt2) {
            return 0;
          }
          i = paramInt1 + 1;
          j = paramArrayOfByte[paramInt1];
          if (j >= 0) {
            break label31;
          }
          if (j >= -32) {
            break label90;
          }
          paramInt1 = j;
          if (i >= paramInt2) {
            break;
          }
          if (j < -62) {
            break label88;
          }
          paramInt1 = i + 1;
        } while (paramArrayOfByte[i] <= -65);
        return -1;
        if (j >= -16) {
          break label168;
        }
        if (i >= paramInt2 - 1) {
          return b(paramArrayOfByte, i, paramInt2);
        }
        k = i + 1;
        paramInt1 = paramArrayOfByte[i];
        if ((paramInt1 > -65) || ((j == -32) && (paramInt1 < -96)) || ((j == -19) && (paramInt1 >= -96))) {
          break label166;
        }
        paramInt1 = k + 1;
      } while (paramArrayOfByte[k] <= -65);
      return -1;
      if (i >= paramInt2 - 2) {
        return b(paramArrayOfByte, i, paramInt2);
      }
      paramInt1 = i + 1;
      i = paramArrayOfByte[i];
      if ((i > -65) || ((j << 28) + (i + 112) >> 30 != 0)) {
        break label236;
      }
      i = paramInt1 + 1;
      if (paramArrayOfByte[paramInt1] > -65) {
        break label236;
      }
      paramInt1 = i + 1;
    } while (paramArrayOfByte[i] <= -65);
    label236:
    return -1;
  }
  
  private static int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    switch (paramInt2 - paramInt1)
    {
    default: 
      throw new AssertionError();
    case 0: 
      paramInt1 = i;
      if (i > -12) {
        paramInt1 = -1;
      }
      return paramInt1;
    case 1: 
      return a(i, paramArrayOfByte[paramInt1]);
    }
    return a(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */