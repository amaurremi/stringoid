package com.vungle.sdk.a.a;

import android.text.TextUtils;
import android.util.SparseArray;
import com.vungle.sdk.e;

public final class i
{
  private static final SparseArray<i> a = new SparseArray();
  private final int b;
  private final String c;
  
  private i(int paramInt)
  {
    this(paramInt, null);
  }
  
  private i(int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
  }
  
  static i a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  static i a(int paramInt, String paramString)
  {
    int i;
    if ((TextUtils.isEmpty(paramString)) && ((paramInt == 200) || (paramInt / 100 == 6))) {
      i = 1;
    }
    while (i != 0)
    {
      paramString = (i)a.get(paramInt);
      String str;
      if (paramString == null)
      {
        paramString = new i(paramInt);
        str = e.t;
        new StringBuilder("Caching response (").append(paramInt).append(")");
        a.put(paramInt, paramString);
        return paramString;
        i = 0;
      }
      else
      {
        str = e.t;
        new StringBuilder("Returning cached response (").append(paramInt).append(")");
        return paramString;
      }
    }
    return new i(paramInt, paramString);
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final String b()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */