package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.jiubang.playsdk.a.x;
import com.jiubang.playsdk.adapter.PackageBroadcastReceiver;
import com.jiubang.playsdk.adapter.k;
import com.jiubang.playsdk.adapter.l;
import com.jiubang.playsdk.adapter.m;
import com.jiubang.playsdk.adapter.n;
import com.jiubang.playsdk.e.d;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g.a;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.i;

public class TabView
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, k, l, m, i, q
{
  private ViewPager a = null;
  private n b;
  private PlayTabContainer c = null;
  private x d;
  private PackageBroadcastReceiver e;
  private boolean f = false;
  private FrameLayout g;
  private View h;
  private Handler i = new aa(this);
  
  public TabView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      this.h = paramView;
      this.h.getViewTreeObserver().addOnGlobalLayoutListener(new z(this));
      this.g.removeAllViews();
      a.a(paramView);
      this.g.addView(this.h);
    }
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(x paramx)
  {
    this.d = paramx;
  }
  
  public void a(d paramd)
  {
    if (paramd != null)
    {
      this.b = new n(getContext(), paramd, this.d);
      this.a.setAdapter(this.b);
      this.a.setOffscreenPageLimit(this.b.getCount());
      this.c.a(this.a);
      this.c.onPageSelected(this.b.d());
      this.a.setCurrentItem(this.b.d());
      if (this.b.d() == 0) {
        this.b.b(0);
      }
      if (this.b.getCount() <= 1) {
        this.c.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.b != null) {
      this.b.b();
    }
  }
  
  public void b()
  {
    if (this.e == null) {
      this.e = new PackageBroadcastReceiver(getContext());
    }
    if (this.f) {
      c();
    }
    this.e.a(this);
    this.e.a(this);
    this.e.a(this);
    getContext().registerReceiver(this.e, this.e.a());
    this.f = true;
  }
  
  public void c()
  {
    getContext().unregisterReceiver(this.e);
    this.e.a(null);
    this.e.a(null);
    this.e.a(null);
    this.f = false;
  }
  
  public void k()
  {
    if (this.b != null) {
      this.b.a();
    }
  }
  
  public void l()
  {
    if (this.b != null) {
      this.b.c();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
    if (this.a != null) {
      this.a.setOnPageChangeListener(this);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
    if (this.a != null) {
      this.a.setOnPageChangeListener(null);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ViewPager)findViewById(f.ao));
    this.a.setOnPageChangeListener(this);
    this.c = ((PlayTabContainer)findViewById(f.am));
    this.g = ((FrameLayout)findViewById(f.an));
    View localView = com.jiubang.playsdk.a.aa.a().b().a(getContext(), this);
    if (localView != null) {
      a(localView);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.c.onPageScrollStateChanged(paramInt);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.c.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.c.onPageSelected(paramInt);
    this.b.b(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/TabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */