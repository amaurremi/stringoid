package com.go.weatherex.themestore.detail;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.jiubang.playsdk.detail.a.a;
import com.jiubang.playsdk.detail.a.d;
import java.util.List;

public class ThemeFullPreview
  extends FrameLayout
  implements ViewPager.OnPageChangeListener, d
{
  private ViewPager a;
  private IndicatorView b;
  
  public ThemeFullPreview(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ThemeFullPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(PagerAdapter paramPagerAdapter, int paramInt)
  {
    if (this.a != null)
    {
      this.a.setAdapter(paramPagerAdapter);
      this.b.b(paramPagerAdapter.getCount());
      this.b.c(paramInt);
      this.a.setCurrentItem(paramInt);
      paramPagerAdapter = AnimationUtils.loadAnimation(getContext(), 2130968598);
      paramPagerAdapter.setDuration(400L);
      startAnimation(paramPagerAdapter);
    }
  }
  
  public void a()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130968599);
    localAnimation.setDuration(400L);
    startAnimation(localAnimation);
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).removeView(this);
    }
  }
  
  public void a(int paramInt)
  {
    a();
  }
  
  public void a(com.jiubang.playsdk.e.e parame, int paramInt)
  {
    if (parame != null)
    {
      parame = new a(getContext(), parame);
      parame.b(false);
      parame.a(false);
      a(parame, paramInt);
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = new com.jiubang.playsdk.detail.a.e(getContext(), paramList);
      paramList.a(this);
      paramList.b(false);
      paramList.a(false);
      a(paramList, paramInt);
    }
  }
  
  protected void onFinishInflate()
  {
    this.a = ((ViewPager)findViewById(2131231598));
    this.a.setOnPageChangeListener(this);
    this.b = ((IndicatorView)findViewById(2131231955));
    int i = getContext().getResources().getDimensionPixelSize(2131427362);
    this.b.a(i);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 4))
    {
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.b.c(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/ThemeFullPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */