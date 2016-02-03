package com.appbrain.a;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

final class bh
  extends ImageView
{
  private float a;
  private int b;
  
  public bh(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a()
  {
    this.a = 2.05F;
  }
  
  public final void b()
  {
    this.b = 20;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.a == 0.0F)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = (int)(paramInt2 / this.a);
    setMeasuredDimension(paramInt2, paramInt1);
    paramInt2 = paramInt2 * this.b / 100;
    paramInt1 = paramInt1 * this.b / 100;
    setPadding(paramInt2, paramInt1, paramInt2, paramInt1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */