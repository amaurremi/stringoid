package com.jiubang.ggheart.apps.desks.diy.filter.core;

import android.graphics.Bitmap;

public class FilterParameter
{
  public static final int PAY_EXTRA_IDS_INDEX_EDIT = 0;
  public static final int PAY_EXTRA_IDS_INDEX_SETTING = 1;
  private int a;
  private boolean b;
  private int[] c;
  private int d;
  private int e;
  private int[] f;
  public Bitmap mSrcBitmap;
  
  public FilterParameter(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    this.a = paramInt1;
    this.e = paramInt2;
    this.f = paramArrayOfInt;
  }
  
  public boolean canDiyColor()
  {
    return this.b;
  }
  
  public void cleanUp()
  {
    this.mSrcBitmap = null;
    this.c = null;
  }
  
  public int getDiyColor()
  {
    return this.d;
  }
  
  public int[] getDiyColors()
  {
    return this.c;
  }
  
  public int getFilterNameResId()
  {
    return this.e;
  }
  
  public int[] getPayExtraIds()
  {
    return this.f;
  }
  
  public int getTypeId()
  {
    return this.a;
  }
  
  public void setDiyColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setFilterNameResId(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/apps/desks/diy/filter/core/FilterParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */