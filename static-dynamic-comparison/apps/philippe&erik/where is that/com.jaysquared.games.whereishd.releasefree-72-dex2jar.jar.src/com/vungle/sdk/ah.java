package com.vungle.sdk;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

final class ah
  extends FrameLayout
{
  private final double a = 1.0D;
  private final double b = 1.0D;
  
  public ah(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    double d = i;
    if (d > paramInt1) {}
    for (paramInt2 = (int)paramInt1;; paramInt2 = i)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
      return;
      paramInt1 = (int)d;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */