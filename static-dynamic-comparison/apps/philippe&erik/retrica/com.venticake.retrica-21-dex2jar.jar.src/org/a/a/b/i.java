package org.a.a.b;

import org.a.a.a;

abstract class i
  extends d
{
  private static final int[] a;
  private static final int[] b;
  private static final long[] c;
  private static final long[] d;
  
  static
  {
    long l1 = 0L;
    a = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    b = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    c = new long[12];
    d = new long[12];
    int i = 0;
    long l2 = 0L;
    while (i < 11)
    {
      l2 += a[i] * 86400000L;
      c[(i + 1)] = l2;
      l1 += b[i] * 86400000L;
      d[(i + 1)] = l1;
      i += 1;
    }
  }
  
  i(a parama, Object paramObject, int paramInt)
  {
    super(parama, paramObject, paramInt);
  }
  
  int a(long paramLong, int paramInt)
  {
    int i = (int)(paramLong - d(paramInt) >> 10);
    if (e(paramInt)) {
      if (i < 15356250) {
        if (i < 7678125) {
          if (i >= 2615625) {}
        }
      }
    }
    do
    {
      return 1;
      if (i < 5062500) {
        return 2;
      }
      return 3;
      if (i < 10209375) {
        return 4;
      }
      if (i < 12825000) {
        return 5;
      }
      return 6;
      if (i < 23118750)
      {
        if (i < 17971875) {
          return 7;
        }
        if (i < 20587500) {
          return 8;
        }
        return 9;
      }
      if (i < 25734375) {
        return 10;
      }
      if (i < 28265625) {
        return 11;
      }
      return 12;
      if (i >= 15271875) {
        break label182;
      }
      if (i >= 7593750) {
        break;
      }
    } while (i < 2615625);
    if (i < 4978125) {
      return 2;
    }
    return 3;
    if (i < 10125000) {
      return 4;
    }
    if (i < 12740625) {
      return 5;
    }
    return 6;
    label182:
    if (i < 23034375)
    {
      if (i < 17887500) {
        return 7;
      }
      if (i < 20503125) {
        return 8;
      }
      return 9;
    }
    if (i < 25650000) {
      return 10;
    }
    if (i < 28181250) {
      return 11;
    }
    return 12;
  }
  
  int b(int paramInt1, int paramInt2)
  {
    if (e(paramInt1)) {
      return b[(paramInt2 - 1)];
    }
    return a[(paramInt2 - 1)];
  }
  
  long c(int paramInt1, int paramInt2)
  {
    if (e(paramInt1)) {
      return d[(paramInt2 - 1)];
    }
    return c[(paramInt2 - 1)];
  }
  
  int e(long paramLong, int paramInt)
  {
    int i = 28;
    if ((paramInt > 28) || (paramInt < 1)) {
      i = i(paramLong);
    }
    return i;
  }
  
  long f(long paramLong, int paramInt)
  {
    int m = a(paramLong);
    int j = c(paramLong, m);
    int k = h(paramLong);
    int i = j;
    if (j > 59)
    {
      if (!e(m)) {
        break label74;
      }
      i = j;
      if (!e(paramInt)) {
        i = j - 1;
      }
    }
    for (;;)
    {
      return a(paramInt, 1, i) + k;
      label74:
      i = j;
      if (e(paramInt)) {
        i = j + 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */