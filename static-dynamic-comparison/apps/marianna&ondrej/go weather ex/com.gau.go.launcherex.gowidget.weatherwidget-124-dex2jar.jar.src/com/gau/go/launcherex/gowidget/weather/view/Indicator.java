package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Indicator
  extends LinearLayout
{
  private int a = 2130838150;
  private int b = 2130838153;
  
  public Indicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    int i = getChildCount();
    int j = paramInt - i;
    if (j > 0)
    {
      paramInt = 0;
      while (paramInt < j)
      {
        ImageView localImageView = new ImageView(getContext());
        localImageView.setImageResource(this.b);
        addView(localImageView);
        paramInt += 1;
      }
    }
    Math.abs(j);
    while (paramInt < i)
    {
      removeViewAt(i - 1);
      i -= 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) && (paramInt >= getChildCount())) {
      return;
    }
    int i = 0;
    label15:
    if (i < getChildCount())
    {
      if (i != paramInt) {
        break label50;
      }
      ((ImageView)getChildAt(i)).setImageResource(this.a);
    }
    for (;;)
    {
      i += 1;
      break label15;
      break;
      label50:
      ((ImageView)getChildAt(i)).setImageResource(this.b);
    }
  }
  
  public void c(int paramInt)
  {
    int i = paramInt / 2;
    int j = getChildCount();
    paramInt = 0;
    if (paramInt < j)
    {
      if (paramInt == 0) {
        ((ImageView)getChildAt(paramInt)).setPadding(0, 0, i, 0);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (paramInt == j) {
          ((ImageView)getChildAt(paramInt)).setPadding(i, 0, 0, 0);
        } else {
          ((ImageView)getChildAt(paramInt)).setPadding(i, 0, i, 0);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/Indicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */