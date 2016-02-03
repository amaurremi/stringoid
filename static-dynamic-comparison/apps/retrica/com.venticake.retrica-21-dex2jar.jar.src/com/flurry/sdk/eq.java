package com.flurry.sdk;

import android.os.Build.VERSION;
import android.text.TextUtils;

public final class eq
  extends es
{
  private final int a;
  
  public eq(String paramString, int paramInt)
  {
    super(a(paramString, paramInt));
    this.a = paramInt;
  }
  
  private static et a(String paramString, int paramInt)
  {
    et localet = null;
    if (b(paramString, paramInt)) {
      localet = er.a(paramString);
    }
    return localet;
  }
  
  private static boolean b(String paramString, int paramInt)
  {
    return (!TextUtils.isEmpty(paramString)) && (Build.VERSION.SDK_INT >= paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */