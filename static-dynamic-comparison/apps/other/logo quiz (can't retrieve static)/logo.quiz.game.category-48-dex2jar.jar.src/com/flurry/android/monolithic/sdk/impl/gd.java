package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class gd
{
  private static final gd a = new gd();
  private final Map<String, gc> b = new HashMap();
  
  public static gc a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    return a.b(paramContext, paramString);
  }
  
  private gc b(Context paramContext, String paramString)
  {
    try
    {
      gc localgc2 = (gc)this.b.get(paramString);
      gc localgc1 = localgc2;
      if (localgc2 == null)
      {
        localgc1 = new gc(paramContext.getApplicationContext(), paramString);
        this.b.put(paramString, localgc1);
      }
      return localgc1;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */