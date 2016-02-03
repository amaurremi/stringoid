package com.fasterxml.jackson.core.io;

public final class NumberInput
{
  static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);
  static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
  
  public static boolean inLongRange(String paramString, boolean paramBoolean)
  {
    String str;
    int j;
    int i;
    if (paramBoolean)
    {
      str = MIN_LONG_STR_NO_SIGN;
      j = str.length();
      i = paramString.length();
      if (i >= j) {
        break label35;
      }
    }
    for (;;)
    {
      return true;
      str = MAX_LONG_STR;
      break;
      label35:
      if (i > j) {
        return false;
      }
      i = 0;
      while (i < j)
      {
        int k = paramString.charAt(i) - str.charAt(i);
        if (k != 0)
        {
          if (k < 0) {}
          for (paramBoolean = true;; paramBoolean = false) {
            return paramBoolean;
          }
        }
        i += 1;
      }
    }
  }
  
  public static boolean inLongRange(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str;
    int i;
    if (paramBoolean)
    {
      str = MIN_LONG_STR_NO_SIGN;
      i = str.length();
      if (paramInt2 >= i) {
        break label32;
      }
    }
    for (;;)
    {
      return true;
      str = MAX_LONG_STR;
      break;
      label32:
      if (paramInt2 > i) {
        return false;
      }
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        int j = paramArrayOfChar[(paramInt1 + paramInt2)] - str.charAt(paramInt2);
        if (j != 0)
        {
          if (j < 0) {}
          for (paramBoolean = true;; paramBoolean = false) {
            return paramBoolean;
          }
        }
        paramInt2 += 1;
      }
    }
  }
  
  public static int parseAsInt(String paramString, int paramInt)
  {
    int k = 0;
    if (paramString == null) {}
    int i;
    do
    {
      return paramInt;
      paramString = paramString.trim();
      i = paramString.length();
    } while (i == 0);
    int j;
    if (i < 0)
    {
      j = paramString.charAt(0);
      if (j == 43)
      {
        paramString = paramString.substring(1);
        j = paramString.length();
        i = k;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        k = paramString.charAt(i);
        if ((k <= 57) && (k >= 48)) {}
      }
      try
      {
        double d = parseDouble(paramString);
        return (int)d;
      }
      catch (NumberFormatException paramString)
      {
        try
        {
          i = Integer.parseInt(paramString);
          return i;
        }
        catch (NumberFormatException paramString)
        {
          return paramInt;
        }
        paramString = paramString;
        return paramInt;
      }
      if (j == 45)
      {
        k = 1;
        j = i;
        i = k;
        continue;
        i += 1;
      }
      else
      {
        j = i;
        i = k;
      }
    }
  }
  
  public static long parseAsLong(String paramString, long paramLong)
  {
    int k = 0;
    if (paramString == null) {}
    int i;
    do
    {
      return paramLong;
      paramString = paramString.trim();
      i = paramString.length();
    } while (i == 0);
    int j;
    if (i < 0)
    {
      j = paramString.charAt(0);
      if (j == 43)
      {
        paramString = paramString.substring(1);
        j = paramString.length();
        i = k;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        k = paramString.charAt(i);
        if ((k <= 57) && (k >= 48)) {}
      }
      try
      {
        double d = parseDouble(paramString);
        return d;
      }
      catch (NumberFormatException paramString)
      {
        try
        {
          long l = Long.parseLong(paramString);
          return l;
        }
        catch (NumberFormatException paramString)
        {
          return paramLong;
        }
        paramString = paramString;
        return paramLong;
      }
      if (j == 45)
      {
        k = 1;
        j = i;
        i = k;
        continue;
        i += 1;
      }
      else
      {
        j = i;
        i = k;
      }
    }
  }
  
  public static double parseDouble(String paramString)
  {
    if ("2.2250738585072012e-308".equals(paramString)) {
      return Double.MIN_VALUE;
    }
    return Double.parseDouble(paramString);
  }
  
  public static int parseInt(String paramString)
  {
    int k = 1;
    int i = paramString.charAt(0);
    int n = paramString.length();
    int j;
    if (i == 45) {
      j = 1;
    }
    while (j != 0) {
      if ((n == 1) || (n > 10))
      {
        k = Integer.parseInt(paramString);
        return k;
        j = 0;
      }
      else
      {
        i = paramString.charAt(1);
        k = 2;
      }
    }
    while ((i > 57) || (i < 48))
    {
      return Integer.parseInt(paramString);
      if (n > 9) {
        return Integer.parseInt(paramString);
      }
    }
    int m = i - 48;
    i = m;
    if (k < n)
    {
      int i1 = k + 1;
      i = paramString.charAt(k);
      if ((i > 57) || (i < 48)) {
        return Integer.parseInt(paramString);
      }
      k = m * 10 + (i - 48);
      i = k;
      if (i1 < n)
      {
        m = i1 + 1;
        i = paramString.charAt(i1);
        if ((i > 57) || (i < 48)) {
          return Integer.parseInt(paramString);
        }
        k = k * 10 + (i - 48);
        i = k;
        if (m < n) {
          i = k;
        }
      }
    }
    for (;;)
    {
      k = m + 1;
      m = paramString.charAt(m);
      if ((m > 57) || (m < 48)) {
        return Integer.parseInt(paramString);
      }
      i = i * 10 + (m - 48);
      if (k >= n)
      {
        k = i;
        if (j == 0) {
          break;
        }
        return -i;
      }
      m = k;
    }
  }
  
  public static int parseInt(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfChar[paramInt1] - '0';
    int j = paramInt2 + paramInt1;
    int k = paramInt1 + 1;
    paramInt1 = i;
    if (k < j)
    {
      paramInt2 = i * 10 + (paramArrayOfChar[k] - '0');
      i = k + 1;
      paramInt1 = paramInt2;
      if (i < j)
      {
        paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
        i += 1;
        paramInt1 = paramInt2;
        if (i < j)
        {
          paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
          i += 1;
          paramInt1 = paramInt2;
          if (i < j)
          {
            paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
            i += 1;
            paramInt1 = paramInt2;
            if (i < j)
            {
              paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
              i += 1;
              paramInt1 = paramInt2;
              if (i < j)
              {
                paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                i += 1;
                paramInt1 = paramInt2;
                if (i < j)
                {
                  paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                  i += 1;
                  paramInt1 = paramInt2;
                  if (i < j) {
                    paramInt1 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                  }
                }
              }
            }
          }
        }
      }
    }
    return paramInt1;
  }
  
  public static long parseLong(String paramString)
  {
    if (paramString.length() <= 9) {
      return parseInt(paramString);
    }
    return Long.parseLong(paramString);
  }
  
  public static long parseLong(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramInt2 -= 9;
    return parseInt(paramArrayOfChar, paramInt1, paramInt2) * 1000000000L + parseInt(paramArrayOfChar, paramInt2 + paramInt1, 9);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/io/NumberInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */