package com.jiubang.playsdk.views;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.adapter.PackageBroadcastReceiver;
import com.jiubang.playsdk.adapter.k;
import com.jiubang.playsdk.adapter.l;
import com.jiubang.playsdk.adapter.m;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g.a;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.i;

public class DefaultTabView
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, k, l, m, i
{
  private ViewPager a = null;
  private com.jiubang.playsdk.adapter.e b;
  private PlayTabContainer c = null;
  private PackageBroadcastReceiver d;
  private boolean e = false;
  private FrameLayout f;
  private View g;
  private Handler h = new e(this);
  
  public DefaultTabView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DefaultTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      this.g = paramView;
      this.g.getViewTreeObserver().addOnGlobalLayoutListener(new d(this));
      this.f.removeAllViews();
      a.a(paramView);
      this.f.addView(this.g);
    }
  }
  
  private void c()
  {
    this.b = new com.jiubang.playsdk.adapter.e(getContext());
    this.a.setAdapter(this.b);
    if (this.b.getCount() <= 1) {
      this.c.setVisibility(8);
    }
    this.c.a(this.a);
    this.c.onPageSelected(this.b.d());
    this.a.setCurrentItem(this.b.d());
    if (this.b.d() == 0) {
      this.b.b(0);
    }
  }
  
  public void a()
  {
    if (this.d == null) {
      this.d = new PackageBroadcastReceiver(getContext());
    }
    if (this.e) {
      b();
    }
    this.d.a(this);
    this.d.a(this);
    this.d.a(this);
    getContext().registerReceiver(this.d, this.d.a());
    this.e = true;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.b != null) {
      this.b.b();
    }
  }
  
  public void b()
  {
    getContext().unregisterReceiver(this.d);
    this.d.a(null);
    this.d.a(null);
    this.d.a(null);
    this.e = false;
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
    a();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ViewPager)findViewById(f.t));
    this.a.setOnPageChangeListener(this);
    this.c = ((PlayTabContainer)findViewById(f.r));
    this.f = ((FrameLayout)findViewById(f.s));
    c();
    View localView = aa.a().b().a(getContext(), this);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/DefaultTabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */