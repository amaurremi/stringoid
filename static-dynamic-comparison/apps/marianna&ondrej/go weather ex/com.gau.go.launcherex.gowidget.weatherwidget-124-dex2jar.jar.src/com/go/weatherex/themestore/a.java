package com.go.weatherex.themestore;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.go.weatherex.viewex.SlidingTabStrip;

public class a
  extends com.gau.go.launcherex.gowidget.weather.viewframe.viewholder.b
  implements ViewPager.OnPageChangeListener
{
  private SlidingTabStrip a;
  private int b;
  private c c;
  private final View.OnClickListener d = new b(this);
  
  public a() {}
  
  public a(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
    this.a = ((SlidingTabStrip)paramView);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.a.a((int)(f * 5.3F));
    this.a.a(false);
    this.a.a(new int[] { -1 });
    this.a.a((byte)0);
  }
  
  private void a(int paramInt, float paramFloat)
  {
    this.a.a(paramInt, paramFloat);
    int i = this.a.getChildCount();
    if ((paramInt >= 0) && (paramInt < i)) {
      ((TextView)this.a.getChildAt(paramInt)).setTextColor(Color.argb((int)((1.0F - paramFloat) * 105.0F + 150.0F), 255, 255, 255));
    }
    paramInt += 1;
    if ((paramInt > 0) && (paramInt < i)) {
      ((TextView)this.a.getChildAt(paramInt)).setTextColor(Color.argb((int)(105.0F * paramFloat + 150.0F), 255, 255, 255));
    }
  }
  
  public void a(c paramc)
  {
    this.c = paramc;
  }
  
  public void a(String... paramVarArgs)
  {
    this.a.removeAllViews();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      TextView localTextView = (TextView)LayoutInflater.from(this.f).inflate(2130903311, this.a, false);
      localTextView.setText((CharSequence)localObject);
      localTextView.setOnClickListener(this.d);
      localObject = new LinearLayout.LayoutParams(0, -1, 1.0F / paramVarArgs.length);
      this.a.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    this.a.a(0, 0.0F);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt2 = this.a.getChildCount();
    if ((paramInt2 == 0) || (paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      return;
    }
    a(paramInt1, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.b == 0) {
      a(paramInt, 0.0F);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */