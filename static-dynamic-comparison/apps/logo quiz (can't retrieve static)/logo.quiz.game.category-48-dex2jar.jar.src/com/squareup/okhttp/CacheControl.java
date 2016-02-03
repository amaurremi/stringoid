package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;

public final class CacheControl
{
  private final boolean isPublic;
  private final int maxAgeSeconds;
  private final int maxStaleSeconds;
  private final int minFreshSeconds;
  private final boolean mustRevalidate;
  private final boolean noCache;
  private final boolean noStore;
  private final boolean onlyIfCached;
  private final int sMaxAgeSeconds;
  
  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3, int paramInt4, boolean paramBoolean5)
  {
    this.noCache = paramBoolean1;
    this.noStore = paramBoolean2;
    this.maxAgeSeconds = paramInt1;
    this.sMaxAgeSeconds = paramInt2;
    this.isPublic = paramBoolean3;
    this.mustRevalidate = paramBoolean4;
    this.maxStaleSeconds = paramInt3;
    this.minFreshSeconds = paramInt4;
    this.onlyIfCached = paramBoolean5;
  }
  
  public static CacheControl parse(Headers paramHeaders)
  {
    boolean bool5 = false;
    boolean bool4 = false;
    int n = -1;
    int m = -1;
    boolean bool3 = false;
    boolean bool2 = false;
    int k = -1;
    int j = -1;
    boolean bool1 = false;
    int i1 = 0;
    while (i1 < paramHeaders.size())
    {
      boolean bool6;
      int i;
      int i3;
      boolean bool7;
      boolean bool8;
      int i4;
      int i5;
      boolean bool9;
      boolean bool10;
      if ((!paramHeaders.name(i1).equalsIgnoreCase("Cache-Control")) && (!paramHeaders.name(i1).equalsIgnoreCase("Pragma")))
      {
        bool6 = bool1;
        i = j;
        i3 = k;
        bool7 = bool2;
        bool8 = bool3;
        i4 = m;
        i5 = n;
        bool9 = bool4;
        bool10 = bool5;
        i1 += 1;
        bool5 = bool10;
        bool4 = bool9;
        n = i5;
        m = i4;
        bool3 = bool8;
        bool2 = bool7;
        k = i3;
        j = i;
        bool1 = bool6;
      }
      else
      {
        String str2 = paramHeaders.value(i1);
        int i2 = 0;
        for (;;)
        {
          bool10 = bool5;
          bool9 = bool4;
          i5 = n;
          i4 = m;
          bool8 = bool3;
          bool7 = bool2;
          i3 = k;
          i = j;
          bool6 = bool1;
          if (i2 >= str2.length()) {
            break;
          }
          i = HeaderParser.skipUntil(str2, i2, "=,;");
          String str3 = str2.substring(i2, i).trim();
          String str1;
          if ((i == str2.length()) || (str2.charAt(i) == ',') || (str2.charAt(i) == ';'))
          {
            i += 1;
            str1 = null;
          }
          for (;;)
          {
            if (!"no-cache".equalsIgnoreCase(str3)) {
              break label365;
            }
            bool5 = true;
            i2 = i;
            break;
            i2 = HeaderParser.skipWhitespace(str2, i + 1);
            if ((i2 < str2.length()) && (str2.charAt(i2) == '"'))
            {
              i = i2 + 1;
              i2 = HeaderParser.skipUntil(str2, i, "\"");
              str1 = str2.substring(i, i2);
              i = i2 + 1;
            }
            else
            {
              i = HeaderParser.skipUntil(str2, i2, ",;");
              str1 = str2.substring(i2, i).trim();
            }
          }
          label365:
          if ("no-store".equalsIgnoreCase(str3))
          {
            bool4 = true;
            i2 = i;
          }
          else if ("max-age".equalsIgnoreCase(str3))
          {
            n = HeaderParser.parseSeconds(str1);
            i2 = i;
          }
          else if ("s-maxage".equalsIgnoreCase(str3))
          {
            m = HeaderParser.parseSeconds(str1);
            i2 = i;
          }
          else if ("public".equalsIgnoreCase(str3))
          {
            bool3 = true;
            i2 = i;
          }
          else if ("must-revalidate".equalsIgnoreCase(str3))
          {
            bool2 = true;
            i2 = i;
          }
          else if ("max-stale".equalsIgnoreCase(str3))
          {
            k = HeaderParser.parseSeconds(str1);
            i2 = i;
          }
          else if ("min-fresh".equalsIgnoreCase(str3))
          {
            j = HeaderParser.parseSeconds(str1);
            i2 = i;
          }
          else
          {
            i2 = i;
            if ("only-if-cached".equalsIgnoreCase(str3))
            {
              bool1 = true;
              i2 = i;
            }
          }
        }
      }
    }
    return new CacheControl(bool5, bool4, n, m, bool3, bool2, k, j, bool1);
  }
  
  public boolean isPublic()
  {
    return this.isPublic;
  }
  
  public int maxAgeSeconds()
  {
    return this.maxAgeSeconds;
  }
  
  public int maxStaleSeconds()
  {
    return this.maxStaleSeconds;
  }
  
  public int minFreshSeconds()
  {
    return this.minFreshSeconds;
  }
  
  public boolean mustRevalidate()
  {
    return this.mustRevalidate;
  }
  
  public boolean noCache()
  {
    return this.noCache;
  }
  
  public boolean noStore()
  {
    return this.noStore;
  }
  
  public boolean onlyIfCached()
  {
    return this.onlyIfCached;
  }
  
  public int sMaxAgeSeconds()
  {
    return this.sMaxAgeSeconds;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/CacheControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */