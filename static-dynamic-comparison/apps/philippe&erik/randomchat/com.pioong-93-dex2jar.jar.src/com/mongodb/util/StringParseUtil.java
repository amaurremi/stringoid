package com.mongodb.util;

public final class StringParseUtil
{
  public static boolean parseBoolean(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    int i;
    do
    {
      do
      {
        return paramBoolean;
        paramString = paramString.trim();
      } while (paramString.length() == 0);
      i = paramString.charAt(0);
      if ((i == 116) || (i == 84) || (i == 121) || (i == 89)) {
        return true;
      }
    } while ((i != 102) && (i != 70) && (i != 110) && (i != 78));
    return false;
  }
  
  public static int parseIfInt(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramInt;
    }
    paramString = paramString.trim();
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label46;
      }
      if (!Character.isDigit(paramString.charAt(i))) {
        break;
      }
      i += 1;
    }
    label46:
    return Integer.parseInt(paramString);
  }
  
  public static int parseInt(String paramString, int paramInt)
  {
    return parseInt(paramString, paramInt, null, true);
  }
  
  public static int parseInt(String paramString, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int k;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      k = 1;
      if (k != 0) {
        paramArrayOfInt[0] = -1;
      }
      if (paramString != null) {
        break label33;
      }
    }
    label33:
    do
    {
      return paramInt;
      k = 0;
      break;
      paramString = paramString.trim();
    } while (paramString.length() == 0);
    int m = -1;
    int j = 0;
    int i;
    for (;;)
    {
      i = m;
      if (j < paramString.length())
      {
        if (Character.isDigit(paramString.charAt(j))) {
          i = j;
        }
      }
      else
      {
        if (i < 0) {
          break;
        }
        paramInt = i + 1;
        while ((paramInt < paramString.length()) && (Character.isDigit(paramString.charAt(paramInt)))) {
          paramInt += 1;
        }
      }
      j += 1;
    }
    j = i;
    if (paramBoolean)
    {
      j = i;
      if (i > 0)
      {
        j = i;
        if (paramString.charAt(i - 1) == '-') {
          j = i - 1;
        }
      }
    }
    if (k != 0) {
      paramArrayOfInt[0] = paramInt;
    }
    return Integer.parseInt(paramString.substring(j, paramInt));
  }
  
  public static Number parseIntRadix(String paramString, int paramInt)
  {
    if (paramString == null) {
      return Double.valueOf(NaN.0D);
    }
    paramString = paramString.trim();
    if (paramString.length() == 0) {
      return Double.valueOf(NaN.0D);
    }
    int i = 0;
    if (paramString.charAt(0) == '-') {
      i = 1;
    }
    for (;;)
    {
      if ((i >= paramString.length()) || (Character.digit(paramString.charAt(i), paramInt) == -1)) {}
      try
      {
        paramString = Long.valueOf(paramString.substring(0, i), paramInt);
        return paramString;
      }
      catch (Exception paramString) {}
      i += 1;
    }
    return Double.valueOf(NaN.0D);
  }
  
  public static Number parseNumber(String paramString, Number paramNumber)
  {
    if (paramString == null) {}
    do
    {
      return paramNumber;
      paramString = paramString.trim();
    } while (paramString.length() == 0);
    int j = -1;
    int i = 0;
    for (;;)
    {
      k = j;
      if (i < paramString.length())
      {
        if (Character.isDigit(paramString.charAt(i))) {
          k = i;
        }
      }
      else
      {
        if (k < 0) {
          break;
        }
        i = k + 1;
        while ((i < paramString.length()) && (Character.isDigit(paramString.charAt(i)))) {
          i += 1;
        }
      }
      i += 1;
    }
    int n = 0;
    int m = k;
    j = n;
    if (k > 0)
    {
      m = k;
      j = n;
      if (paramString.charAt(k - 1) == '.')
      {
        m = k - 1;
        j = 1;
      }
    }
    n = m;
    if (m > 0)
    {
      n = m;
      if (paramString.charAt(m - 1) == '-') {
        n = m - 1;
      }
    }
    m = j;
    int k = i;
    if (i < paramString.length())
    {
      m = j;
      k = i;
      if (paramString.charAt(i) == '.')
      {
        k = i + 1;
        while ((k < paramString.length()) && (Character.isDigit(paramString.charAt(k)))) {
          k += 1;
        }
        m = 1;
      }
    }
    j = m;
    i = k;
    if (k < paramString.length())
    {
      j = m;
      i = k;
      if (paramString.charAt(k) == 'E')
      {
        i = k + 1;
        while ((i < paramString.length()) && (Character.isDigit(paramString.charAt(i)))) {
          i += 1;
        }
        j = 1;
      }
    }
    paramString = paramString.substring(n, i);
    if ((j != 0) || (paramString.length() > 17)) {
      return Double.valueOf(paramString);
    }
    if (paramString.length() > 10) {
      return Long.valueOf(paramString);
    }
    return Integer.valueOf(paramString);
  }
  
  public static Number parseStrict(String paramString)
  {
    int i = -1;
    if (paramString.length() == 0) {
      return Integer.valueOf(0);
    }
    String str = paramString;
    if (paramString.charAt(0) == '+') {
      str = paramString.substring(1);
    }
    if (str.matches("(\\+|-)?Infinity"))
    {
      if (str.startsWith("-")) {
        return Double.valueOf(Double.NEGATIVE_INFINITY);
      }
      return Double.valueOf(Double.POSITIVE_INFINITY);
    }
    if ((str.indexOf('.') != -1) || (str.equals("-0"))) {
      return Double.valueOf(str);
    }
    if (str.toLowerCase().indexOf("0x") > -1)
    {
      if (str.charAt(0) == '-') {}
      while (str.length() > 17)
      {
        throw new RuntimeException("Can't handle a number this big: " + str);
        i = 1;
      }
      if (str.length() > 9) {
        return Long.valueOf(i * Long.valueOf(str.substring((int)(i * -0.5D + 2.5D)), 16).longValue());
      }
      return Integer.valueOf(Integer.valueOf(str.substring((int)(i * -0.5D + 2.5D)), 16).intValue() * i);
    }
    i = str.toLowerCase().indexOf('e');
    if (i > 0)
    {
      double d = Double.parseDouble(str.substring(0, i));
      return Double.valueOf(Math.pow(10.0D, Integer.parseInt(str.substring(i + 1))) * d);
    }
    if (str.length() > 17) {
      return Double.valueOf(str);
    }
    if (str.length() > 9) {
      return Long.valueOf(str);
    }
    return Integer.valueOf(str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/StringParseUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */