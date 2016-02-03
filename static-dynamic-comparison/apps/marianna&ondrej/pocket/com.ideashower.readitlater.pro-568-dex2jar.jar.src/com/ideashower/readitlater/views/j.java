package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class j
  extends FrameLayout
{
  private float a;
  private float b;
  private boolean c = true;
  private boolean d;
  
  public j(Context paramContext)
  {
    super(paramContext);
    setMaxWidth(getResources().getDimension(2131296283));
    setMaxHeight(getResources().getDimension(2131296282));
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt1 == 1073741824) {
      return paramInt2;
    }
    if (paramBoolean) {}
    for (paramInt3 = Math.min(paramInt3, paramInt2);; paramInt3 = paramInt2)
    {
      if (paramInt1 == Integer.MIN_VALUE) {
        return Math.min(paramInt3, paramInt2);
      }
      return paramInt3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    int m = localDisplay.getWidth();
    int i = localDisplay.getHeight();
    int j = (int)getResources().getDimension(2131296284);
    int n = (int)this.a;
    int k = (int)this.b;
    n = Math.min(m - j, n);
    m = View.MeasureSpec.getMode(paramInt1);
    m = View.MeasureSpec.makeMeasureSpec(a(m, View.MeasureSpec.getSize(paramInt1), n, true), m);
    if (this.d) {}
    for (paramInt1 = Math.min(i - j, k);; paramInt1 = Math.min(i - j, n))
    {
      i = View.MeasureSpec.getMode(paramInt2);
      super.onMeasure(m, View.MeasureSpec.makeMeasureSpec(a(i, View.MeasureSpec.getSize(paramInt2), paramInt1, this.c), i));
      return;
    }
  }
  
  public void setCapHeight(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setMaxHeight(float paramFloat)
  {
    this.b = paramFloat;
    requestLayout();
    invalidate();
  }
  
  public void setMaxWidth(float paramFloat)
  {
    this.a = com.ideashower.readitlater.util.j.a(paramFloat);
    requestLayout();
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */