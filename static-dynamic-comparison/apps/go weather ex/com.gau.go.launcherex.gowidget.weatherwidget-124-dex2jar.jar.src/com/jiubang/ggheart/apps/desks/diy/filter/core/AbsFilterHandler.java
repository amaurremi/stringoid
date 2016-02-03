package com.jiubang.ggheart.apps.desks.diy.filter.core;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public abstract class AbsFilterHandler
{
  protected Bitmap a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramArrayOfInt, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    try
    {
      paramArrayOfInt = Bitmap.createBitmap(paramArrayOfInt, paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      localOutOfMemoryError.printStackTrace();
      return paramArrayOfInt;
    }
    catch (OutOfMemoryError paramArrayOfInt)
    {
      for (;;)
      {
        paramArrayOfInt.printStackTrace();
        paramArrayOfInt = (int[])localObject;
      }
    }
  }
  
  public abstract Bitmap handler(FilterParameter paramFilterParameter);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/apps/desks/diy/filter/core/AbsFilterHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */