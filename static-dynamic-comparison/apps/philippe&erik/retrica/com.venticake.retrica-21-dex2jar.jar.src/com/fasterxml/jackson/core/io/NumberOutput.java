package com.fasterxml.jackson.core.io;

public final class NumberOutput
{
  private static int BILLION;
  static final char[] FULL_TRIPLETS;
  static final byte[] FULL_TRIPLETS_B;
  static final char[] LEADING_TRIPLETS;
  private static long MAX_INT_AS_LONG;
  private static int MILLION = 1000000;
  private static long MIN_INT_AS_LONG;
  static final String SMALLEST_LONG;
  private static long TEN_BILLION_L;
  private static long THOUSAND_L;
  static final String[] sSmallIntStrs = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
  static final String[] sSmallIntStrs2 = { "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10" };
  
  static
  {
    BILLION = 1000000000;
    TEN_BILLION_L = 10000000000L;
    THOUSAND_L = 1000L;
    MIN_INT_AS_LONG = -2147483648L;
    MAX_INT_AS_LONG = 2147483647L;
    SMALLEST_LONG = String.valueOf(Long.MIN_VALUE);
    LEADING_TRIPLETS = new char['ྠ'];
    FULL_TRIPLETS = new char['ྠ'];
    int i2 = 0;
    int i1 = 0;
    while (i2 < 10)
    {
      int k = (char)(i2 + 48);
      int i;
      int i3;
      if (i2 == 0)
      {
        i = 0;
        i3 = 0;
      }
      for (;;)
      {
        if (i3 >= 10) {
          break label219;
        }
        int m = (char)(i3 + 48);
        if ((i2 == 0) && (i3 == 0)) {}
        for (int j = 0;; j = m)
        {
          int i4 = 0;
          while (i4 < 10)
          {
            int n = (char)(i4 + 48);
            LEADING_TRIPLETS[i1] = i;
            LEADING_TRIPLETS[(i1 + 1)] = j;
            LEADING_TRIPLETS[(i1 + 2)] = n;
            FULL_TRIPLETS[i1] = k;
            FULL_TRIPLETS[(i1 + 1)] = m;
            FULL_TRIPLETS[(i1 + 2)] = n;
            i1 += 4;
            i4 += 1;
          }
          i = k;
          break;
        }
        i3 += 1;
      }
      label219:
      i2 += 1;
    }
    FULL_TRIPLETS_B = new byte['ྠ'];
    i1 = 0;
    while (i1 < 4000)
    {
      FULL_TRIPLETS_B[i1] = ((byte)FULL_TRIPLETS[i1]);
      i1 += 1;
    }
  }
  
  public static String toString(double paramDouble)
  {
    return Double.toString(paramDouble);
  }
  
  public static String toString(int paramInt)
  {
    if (paramInt < sSmallIntStrs.length)
    {
      if (paramInt >= 0) {
        return sSmallIntStrs[paramInt];
      }
      int i = -paramInt - 1;
      if (i < sSmallIntStrs2.length) {
        return sSmallIntStrs2[i];
      }
    }
    return Integer.toString(paramInt);
  }
  
  public static String toString(long paramLong)
  {
    if ((paramLong <= 2147483647L) && (paramLong >= -2147483648L)) {
      return toString((int)paramLong);
    }
    return Long.toString(paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/io/NumberOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */