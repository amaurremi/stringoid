package com.vladium.util;

public abstract class WCMatcher
{
  private static final WCMatcher ALL_MATCHER = new AllMatcher(null);
  private static final WCMatcher EMPTY_MATCHER = new EmptyMatcher(null);
  
  public static WCMatcher compile(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("null input: pattern");
    }
    paramString = paramString.toCharArray();
    int i3 = paramString.length;
    if (i3 == 0) {
      return EMPTY_MATCHER;
    }
    int i1 = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int j = 0;
    int i;
    int i2;
    if (n < i3)
    {
      i = paramString[n];
      if (i == 42)
      {
        if (m != 0) {
          break label203;
        }
        m = 1;
        i1 += 1;
        i2 = j + 1;
        paramString[j] = 42;
        j = i2;
      }
    }
    label203:
    for (;;)
    {
      n += 1;
      break;
      i2 = 0;
      m = k;
      if (i == 63) {
        m = k + 1;
      }
      k = j + 1;
      paramString[j] = i;
      j = k;
      k = m;
      m = i2;
      continue;
      if ((i1 == 1) && (k == 0))
      {
        if (j == 1) {
          return ALL_MATCHER;
        }
        if (paramString[0] == '*') {
          return new EndsWithMatcher(paramString, j);
        }
        if (paramString[(j - 1)] == '*') {
          return new StartsWithMatcher(paramString, j);
        }
      }
      return new PatternMatcher(paramString, j);
    }
  }
  
  public abstract boolean matches(String paramString);
  
  public abstract boolean matches(char[] paramArrayOfChar);
  
  private static final class AllMatcher
    extends WCMatcher
  {
    public final boolean matches(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: s");
      }
      return true;
    }
    
    public final boolean matches(char[] paramArrayOfChar)
    {
      if (paramArrayOfChar == null) {
        throw new IllegalArgumentException("null input: chars");
      }
      return true;
    }
  }
  
  private static final class EmptyMatcher
    extends WCMatcher
  {
    public final boolean matches(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: s");
      }
      return false;
    }
    
    public final boolean matches(char[] paramArrayOfChar)
    {
      if (paramArrayOfChar == null) {
        throw new IllegalArgumentException("null input: chars");
      }
      return paramArrayOfChar.length == 0;
    }
  }
  
  private static final class EndsWithMatcher
    extends WCMatcher
  {
    private final String m_suffix;
    private final char[] m_suffixChars;
    
    EndsWithMatcher(char[] paramArrayOfChar, int paramInt)
    {
      this.m_suffixChars = paramArrayOfChar;
      this.m_suffix = new String(paramArrayOfChar, 1, paramInt - 1);
    }
    
    public final boolean matches(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: s");
      }
      return paramString.endsWith(this.m_suffix);
    }
    
    public final boolean matches(char[] paramArrayOfChar)
    {
      if (paramArrayOfChar == null) {
        throw new IllegalArgumentException("null input: chars");
      }
      char[] arrayOfChar = this.m_suffixChars;
      int j = arrayOfChar.length - 1;
      int k = paramArrayOfChar.length;
      if (k < j) {
        return false;
      }
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label69;
        }
        if (paramArrayOfChar[(k - 1 - i)] != arrayOfChar[(j - i)]) {
          break;
        }
        i += 1;
      }
      label69:
      return true;
    }
  }
  
  private static final class PatternMatcher
    extends WCMatcher
  {
    private final char[] m_pattern;
    private final int m_patternLength;
    
    PatternMatcher(char[] paramArrayOfChar, int paramInt)
    {
      this.m_pattern = paramArrayOfChar;
      this.m_patternLength = paramInt;
    }
    
    public final boolean matches(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: s");
      }
      paramString = paramString.toCharArray();
      int n = paramString.length;
      char[] arrayOfChar = this.m_pattern;
      int i1 = this.m_patternLength;
      int i = 0;
      int j = 0;
      int k = 0;
      for (;;)
      {
        int m = 0;
        int i2;
        int i3;
        if (j + m < i1)
        {
          i2 = arrayOfChar[(j + m)];
          if (i2 == 42)
          {
            i += m;
            j += m + 1;
            k = 1;
            continue;
          }
          i3 = i + m;
          if (i3 != n) {}
        }
        do
        {
          do
          {
            return false;
            if ((i2 == paramString[i3]) || (i2 == 63))
            {
              m += 1;
              break;
            }
          } while (k == 0);
          i += 1;
          break;
          if (i + m == n) {
            return true;
          }
        } while (k == 0);
        i += 1;
      }
    }
    
    public final boolean matches(char[] paramArrayOfChar)
    {
      if (paramArrayOfChar == null) {
        throw new IllegalArgumentException("null input: string");
      }
      int n = paramArrayOfChar.length;
      char[] arrayOfChar = this.m_pattern;
      int i1 = this.m_patternLength;
      int i = 0;
      int j = 0;
      int k = 0;
      for (;;)
      {
        int m = 0;
        int i2;
        int i3;
        if (j + m < i1)
        {
          i2 = arrayOfChar[(j + m)];
          if (i2 == 42)
          {
            i += m;
            j += m + 1;
            k = 1;
            continue;
          }
          i3 = i + m;
          if (i3 != n) {}
        }
        do
        {
          do
          {
            return false;
            if ((i2 == paramArrayOfChar[i3]) || (i2 == 63))
            {
              m += 1;
              break;
            }
          } while (k == 0);
          i += 1;
          break;
          if (i + m == n) {
            return true;
          }
        } while (k == 0);
        i += 1;
      }
    }
  }
  
  private static final class StartsWithMatcher
    extends WCMatcher
  {
    private final String m_prefix;
    private final char[] m_prefixChars;
    
    StartsWithMatcher(char[] paramArrayOfChar, int paramInt)
    {
      this.m_prefixChars = paramArrayOfChar;
      this.m_prefix = new String(paramArrayOfChar, 0, paramInt - 1);
    }
    
    public final boolean matches(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("null input: s");
      }
      return paramString.startsWith(this.m_prefix);
    }
    
    public final boolean matches(char[] paramArrayOfChar)
    {
      if (paramArrayOfChar == null) {
        throw new IllegalArgumentException("null input: chars");
      }
      char[] arrayOfChar = this.m_prefixChars;
      int j = arrayOfChar.length - 1;
      if (paramArrayOfChar.length < j) {
        return false;
      }
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label58;
        }
        if (paramArrayOfChar[i] != arrayOfChar[i]) {
          break;
        }
        i += 1;
      }
      label58:
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/WCMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */