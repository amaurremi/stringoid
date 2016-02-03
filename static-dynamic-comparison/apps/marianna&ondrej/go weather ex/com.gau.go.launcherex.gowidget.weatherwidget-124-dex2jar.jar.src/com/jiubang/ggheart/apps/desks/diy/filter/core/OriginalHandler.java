package com.jiubang.ggheart.apps.desks.diy.filter.core;

import android.graphics.Bitmap;

public class OriginalHandler
  extends AbsFilterHandler
{
  public static boolean canHandle(int paramInt)
  {
    return (getHadlerIds() & paramInt) == paramInt;
  }
  
  public static int getHadlerIds()
  {
    return 0;
  }
  
  public Bitmap handler(FilterParameter paramFilterParameter)
  {
    if (paramFilterParameter != null) {
      return paramFilterParameter.mSrcBitmap;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/apps/desks/diy/filter/core/OriginalHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */