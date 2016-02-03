package com.jiubang.playsdk.views;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.jiubang.playsdk.b;
import com.jiubang.playsdk.detail.a.a;
import com.jiubang.playsdk.f;
import java.util.List;

public class ThemeFullPreview
  extends FrameLayout
{
  private ViewPager a;
  
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
      this.a.setCurrentItem(paramInt);
      paramPagerAdapter = AnimationUtils.loadAnimation(getContext(), b.a);
      paramPagerAdapter.setDuration(400L);
      startAnimation(paramPagerAdapter);
    }
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
      paramList.b(false);
      paramList.a(false);
      a(paramList, paramInt);
    }
  }
  
  protected void onFinishInflate()
  {
    this.a = ((ViewPager)findViewById(f.v));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 4))
    {
      paramKeyEvent = AnimationUtils.loadAnimation(getContext(), b.b);
      paramKeyEvent.setDuration(400L);
      startAnimation(paramKeyEvent);
      if ((getParent() instanceof ViewGroup)) {
        ((ViewGroup)getParent()).removeView(this);
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/ThemeFullPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */