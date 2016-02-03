package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.jiubang.playsdk.d;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.g.j;

public class PlayTabContainer
  extends HorizontalScrollView
  implements ViewPager.OnPageChangeListener
{
  private int a;
  private int b = 2;
  private PlayTabStrip c;
  private final int d;
  private ViewPager e;
  private int f = 0;
  
  public PlayTabContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PlayTabContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    setClipChildren(false);
    setHorizontalScrollBarEnabled(false);
    this.d = paramContext.getResources().getDimensionPixelSize(d.p);
  }
  
  private void a() {}
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = this.c.getChildCount();
    if ((i == 0) || (paramInt1 < 0) || (paramInt1 > i)) {}
    do
    {
      View localView;
      do
      {
        return;
        localView = this.c.getChildAt(paramInt1);
      } while (localView == null);
      i = localView.getLeft() + paramInt2;
      if (paramInt1 <= 0)
      {
        paramInt1 = i;
        if (paramInt2 <= 0) {}
      }
      else
      {
        paramInt1 = i - this.d;
      }
    } while (paramInt1 == this.a);
    this.a = paramInt1;
    scrollTo(paramInt1, 0);
  }
  
  private void b()
  {
    this.c.removeAllViews();
    PagerAdapter localPagerAdapter = this.e.getAdapter();
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    int j = localPagerAdapter.getCount();
    int i = 0;
    if (i < j)
    {
      TextView localTextView = (TextView)localLayoutInflater.inflate(g.t, this.c, false);
      if (j <= 3)
      {
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(j.b(getContext()) / j, -1);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(localLayoutParams);
      }
      for (;;)
      {
        localTextView.setText(localPagerAdapter.getPageTitle(i));
        localTextView.setOnClickListener(new u(this, i));
        this.c.addView(localTextView);
        i += 1;
        break;
        int k = getResources().getDimensionPixelSize(d.m);
        localTextView.setPadding(k, 0, k, 0);
      }
    }
  }
  
  public void a(ViewPager paramViewPager)
  {
    this.e = paramViewPager;
    b();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 2) {}
    for (this.f = Math.max(j.b(getContext()), j.c(getContext()));; this.f = Math.min(j.b(getContext()), j.c(getContext())))
    {
      b();
      this.c.c(this.f);
      this.c.a(this.c.a());
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((PlayTabStrip)findViewById(f.ah));
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i = this.c.getChildCount();
    if ((i == 0) || (paramInt1 < 0) || (paramInt1 >= i)) {
      return;
    }
    this.c.a(paramInt1, paramFloat, paramInt2);
    View localView = this.c.getChildAt(paramInt1);
    paramInt2 = 0;
    if (localView != null) {
      paramInt2 = (int)(localView.getWidth() * paramFloat);
    }
    a(paramInt1, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.b == 0)
    {
      this.c.b(paramInt);
      a(paramInt, 0);
    }
    while (this.b != 2) {
      return;
    }
    this.c.a(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/PlayTabContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */