package com.go.weatherex.themestore.detail;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.g.a;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.i;

public class ThemeDetailView
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, i
{
  private FrameLayout a;
  private View b;
  private ImageView c;
  private TextView d;
  private FrameLayout e;
  private LinearLayout f;
  private ViewPager g;
  private IndicatorView h;
  private Handler i = new f(this);
  
  public ThemeDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.e != null) {
      this.e.removeAllViews();
    }
  }
  
  public void a(int paramInt)
  {
    this.b.setVisibility(0);
    this.c.setVisibility(0);
    this.c.setImageResource(paramInt);
  }
  
  public void a(PagerAdapter paramPagerAdapter)
  {
    if (paramPagerAdapter != null)
    {
      this.g.setAdapter(paramPagerAdapter);
      this.h.b(paramPagerAdapter.getCount());
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      this.h.setVisibility(8);
      this.f.removeAllViews();
      a.a(paramView);
      this.f.addView(paramView);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    this.d.setText(paramInt);
  }
  
  public void b(View paramView)
  {
    if ((this.e != null) && (paramView != null))
    {
      this.e.removeAllViews();
      a.a(paramView);
      this.e.addView(paramView);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131231633);
    this.a = ((FrameLayout)localFrameLayout.findViewById(2131231634));
    this.a.setBackgroundResource(aa.a().b().f());
    this.b = localFrameLayout.findViewById(2131231636);
    this.b.setBackgroundResource(aa.a().b().g());
    this.c = ((ImageView)localFrameLayout.findViewById(2131231635));
    this.d = ((TextView)localFrameLayout.findViewById(2131231637));
    this.e = ((FrameLayout)findViewById(2131231632));
    b(aa.a().b().b(getContext(), this));
    this.g = ((ViewPager)findViewById(2131231640));
    this.g.setOnPageChangeListener(this);
    this.h = ((IndicatorView)findViewById(2131231639));
    int j = getContext().getResources().getDimensionPixelSize(2131427362);
    this.h.a(j);
    this.f = ((LinearLayout)findViewById(2131231638));
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.h.c(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/ThemeDetailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */