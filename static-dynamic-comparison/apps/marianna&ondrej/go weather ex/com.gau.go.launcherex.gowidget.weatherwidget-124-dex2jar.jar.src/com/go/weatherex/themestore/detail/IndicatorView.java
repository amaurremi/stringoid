package com.go.weatherex.themestore.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class IndicatorView
  extends FrameLayout
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private LinearLayout f;
  
  public IndicatorView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void b(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      this.f.removeAllViews();
      int i = 0;
      if (i < paramInt)
      {
        ImageView localImageView = new ImageView(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
        localLayoutParams.rightMargin = this.a;
        if (i == this.c) {
          localImageView.setImageResource(this.e);
        }
        for (;;)
        {
          this.f.addView(localImageView, localLayoutParams);
          i += 1;
          break;
          localImageView.setImageResource(this.d);
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      paramInt = 0;
      if (paramInt < this.f.getChildCount())
      {
        Object localObject = this.f.getChildAt(paramInt);
        if ((localObject instanceof ImageView))
        {
          localObject = (ImageView)localObject;
          if (paramInt != this.c) {
            break label70;
          }
          ((ImageView)localObject).setImageResource(this.e);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label70:
          ((ImageView)localObject).setImageResource(this.d);
        }
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = 2130837679;
    this.e = 2130837680;
    this.f = ((LinearLayout)findViewById(2131231610));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/IndicatorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */