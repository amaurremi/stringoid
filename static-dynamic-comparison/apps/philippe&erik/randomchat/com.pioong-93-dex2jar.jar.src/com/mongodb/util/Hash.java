package com.mongodb.util;

public final class Hash
{
  static final long _longHashConstant = 4095L;
  
  public static final int hashBackward(String paramString)
  {
    int j = 0;
    int i = paramString.length() - 1;
    while (i >= 0)
    {
      j = j * 31 + paramString.charAt(i);
      i -= 1;
    }
    return j;
  }
  
  public static final long hashBackwardLong(String paramString)
  {
    long l = 0L;
    int i = paramString.length() - 1;
    while (i >= 0)
    {
      l = 63L * l + paramString.charAt(i);
      i -= 1;
    }
    return l;
  }
  
  public static final int hashCode(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramCharSequence.length();
    while ((paramInt1 < j) && (paramInt1 < paramInt2))
    {
      i = i * 31 + paramCharSequence.charAt(paramInt1);
      paramInt1 += 1;
    }
    return i;
  }
  
  public static final int hashCode(String... paramVarArgs)
  {
    int j = 0;
    int m = paramVarArgs.length;
    int i = 0;
    while (i < m)
    {
      String str = paramVarArgs[i];
      int n = str.length();
      int k = 0;
      while (k < n)
      {
        j = j * 31 + str.charAt(k);
        k += 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static final long longHash(String paramString)
  {
    return longHash(paramString, 0, paramString.length());
  }
  
  public static final long longHash(String paramString, int paramInt1, int paramInt2)
  {
    long l = 0L;
    while (paramInt1 < paramInt2)
    {
      l = 4095L * l + paramString.charAt(paramInt1);
      paramInt1 += 1;
    }
    return l;
  }
  
  public static final long longHashAppend(long paramLong, char paramChar)
  {
    return 4095L * paramLong + paramChar;
  }
  
  public static final long longLowerHash(String paramString)
  {
    return longLowerHash(paramString, 0, paramString.length());
  }
  
  public static final long longLowerHash(String paramString, int paramInt1, int paramInt2)
  {
    long l = 0L;
    while (paramInt1 < paramInt2)
    {
      l = 4095L * l + Character.toLowerCase(paramString.charAt(paramInt1));
      paramInt1 += 1;
    }
    return l;
  }
  
  public static final long longLowerHash(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    while (paramInt1 < paramInt2)
    {
      paramLong = 4095L * paramLong + Character.toLowerCase(paramString.charAt(paramInt1));
      paramInt1 += 1;
    }
    return paramLong;
  }
  
  public static final long longLowerHashAppend(long paramLong, char paramChar)
  {
    return 4095L * paramLong + Character.toLowerCase(paramChar);
  }
  
  public static final int lowerCaseHash(String paramString)
  {
    int j = 0;
    int k = paramString.length();
    int i = 0;
    while (i < k)
    {
      j = j * 31 + Character.toLowerCase(paramString.charAt(i));
      i += 1;
    }
    return j;
  }
  
  public static final int lowerCaseHash(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramString.length();
    while ((paramInt1 < j) && (paramInt1 < paramInt2))
    {
      i = i * 31 + Character.toLowerCase(paramString.charAt(paramInt1));
      paramInt1 += 1;
    }
    return i;
  }
  
  public static final int lowerCaseSpaceTrimHash(String paramString)
  {
    int k = 0;
    int i = paramString.length();
    while ((i > 1) && (Character.isWhitespace(paramString.charAt(i - 1)))) {
      i -= 1;
    }
    int m = 1;
    int j = 0;
    if (j < i)
    {
      boolean bool = Character.isWhitespace(paramString.charAt(j));
      if ((bool) && (m != 0)) {}
      for (;;)
      {
        j += 1;
        break;
        m = bool;
        k = k * 31 + Character.toLowerCase(paramString.charAt(j));
      }
    }
    return k;
  }
  
  public static final int lowerCaseSpaceTrimHash(String paramString, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramString.length();
    while ((i > 1) && (Character.isWhitespace(paramString.charAt(i - 1)))) {
      i -= 1;
    }
    int k = 1;
    if ((paramInt1 < i) && (paramInt1 < paramInt2))
    {
      boolean bool = Character.isWhitespace(paramString.charAt(paramInt1));
      if ((bool) && (k != 0)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        k = bool;
        j = j * 31 + Character.toLowerCase(paramString.charAt(paramInt1));
      }
    }
    return j;
  }
  
  public static final int nospaceLowerHash(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramString.length();
    if ((paramInt1 < j) && (paramInt1 < paramInt2))
    {
      char c = paramString.charAt(paramInt1);
      if (Character.isWhitespace(c)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        i = i * 31 + Character.toLowerCase(c);
      }
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/Hash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */