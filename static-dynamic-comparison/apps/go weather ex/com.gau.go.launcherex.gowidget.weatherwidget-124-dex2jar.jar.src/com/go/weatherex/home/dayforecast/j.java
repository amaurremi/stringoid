package com.go.weatherex.home.dayforecast;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;

public class j
  extends Animation
{
  private View a;
  private int b;
  private int c;
  private LinearLayout.LayoutParams d;
  
  public j(View paramView, int paramInt1, int paramInt2)
  {
    this.a = paramView;
    if (paramInt1 == 1)
    {
      this.b = paramInt2;
      this.c = 0;
    }
    for (;;)
    {
      this.d = ((LinearLayout.LayoutParams)paramView.getLayoutParams());
      if (this.b == 0)
      {
        this.d.height = this.b;
        paramView.setVisibility(0);
        paramView.requestLayout();
      }
      return;
      if (paramInt1 == 0)
      {
        this.b = 0;
        this.c = paramInt2;
      }
    }
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    int i = (int)(this.b + (this.c - this.b) * paramFloat);
    this.d.height = i;
    this.a.requestLayout();
    if (paramFloat >= 1.0F)
    {
      if (this.b <= this.c) {
        break label68;
      }
      this.a.setVisibility(8);
    }
    label68:
    while (this.b >= this.c) {
      return;
    }
    this.a.setVisibility(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/dayforecast/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */