package com.jiubang.ggheart.apps.desks.diy.filter.core;

import android.graphics.Bitmap;

public class SunshineHandler
  extends AbsFilterHandler
{
  public static boolean canHandle(int paramInt)
  {
    return (getHadlerIds() & paramInt) == paramInt;
  }
  
  public static int getHadlerIds()
  {
    return 256;
  }
  
  public native void doFilt(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2);
  
  public Bitmap handler(FilterParameter paramFilterParameter)
  {
    Object localObject;
    if ((paramFilterParameter == null) || (paramFilterParameter.mSrcBitmap == null)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return (Bitmap)localObject;
      int i = paramFilterParameter.mSrcBitmap.getWidth();
      int j = paramFilterParameter.mSrcBitmap.getHeight();
      localObject = new int[i * j];
      paramFilterParameter.mSrcBitmap.getPixels((int[])localObject, 0, i, 0, 0, i, j);
      doFilt((int[])localObject, i, j, 10, 0.1F, 0.1F);
      localBitmap = a((int[])localObject, i, j);
      localObject = localBitmap;
    } while (localBitmap != null);
    return paramFilterParameter.mSrcBitmap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/apps/desks/diy/filter/core/SunshineHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */