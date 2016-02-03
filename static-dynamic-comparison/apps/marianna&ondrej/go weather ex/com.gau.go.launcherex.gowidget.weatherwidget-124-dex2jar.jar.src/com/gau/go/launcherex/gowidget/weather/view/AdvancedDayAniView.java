package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.util.s;

public class AdvancedDayAniView
  extends AdvancedAnimationView
  implements Animation.AnimationListener
{
  private TextView b;
  private MultiDayScrollView c;
  private MultiDayScrollView d;
  private int[] e = { 1, 2, 3, 1, 2, 3, 1, 2, 3 };
  private String[] f = { "5/20", "5/21", "5/22", "5/23", "5/24", "5/25", "5/26", "5/27", "5/28" };
  private LayoutInflater g;
  private Drawable h;
  private Drawable i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private Animation n;
  private Animation o;
  private Animation p;
  private Animation q;
  private Animation r;
  private Animation s;
  private TextView t;
  private TextView u;
  private Runnable v;
  private Runnable w;
  
  public AdvancedDayAniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = LayoutInflater.from(paramContext);
    this.p = s.f(400L);
    this.q = s.d(300L);
    this.q.setAnimationListener(this);
    this.r = s.d(300L);
    this.r.setAnimationListener(this);
    this.s = s.c(200L);
    this.n = s.h(400L);
    this.n.setAnimationListener(this);
    this.o = s.h(400L);
    this.o.setAnimationListener(this);
    a(paramContext);
  }
  
  private Drawable a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      if (paramBoolean) {
        return this.h;
      }
      return this.k;
    case 2: 
      if (paramBoolean) {
        return this.i;
      }
      return this.l;
    }
    if (paramBoolean) {
      return this.j;
    }
    return this.m;
  }
  
  private void a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.h = paramContext.getDrawable(2130837572);
    Rect localRect = new Rect(0, 0, this.h.getIntrinsicWidth(), this.h.getIntrinsicHeight());
    this.h.setBounds(localRect);
    this.k = paramContext.getDrawable(2130837573);
    this.i = paramContext.getDrawable(2130837536);
    this.i.setBounds(localRect);
    this.l = paramContext.getDrawable(2130837537);
    this.j = paramContext.getDrawable(2130837561);
    this.m = paramContext.getDrawable(2130837562);
    this.j.setBounds(localRect);
  }
  
  private void d()
  {
    this.v = new b(this);
    this.w = new c(this);
  }
  
  private void e()
  {
    int i1 = 0;
    DayIcon localDayIcon;
    while (i1 < 5)
    {
      localDayIcon = (DayIcon)this.g.inflate(2130903048, null);
      localDayIcon.a(this.f[i1]);
      localDayIcon.a(a(this.e[i1], false));
      this.c.addView(localDayIcon);
      i1 += 1;
    }
    i1 = 4;
    while (i1 < 9)
    {
      localDayIcon = (DayIcon)this.g.inflate(2130903048, null);
      localDayIcon.a(this.f[i1]);
      localDayIcon.a(a(this.e[i1], false));
      this.d.addView(localDayIcon);
      i1 += 1;
    }
  }
  
  public void a()
  {
    postDelayed(this.v, 500L);
  }
  
  public void b()
  {
    this.a = true;
    removeCallbacks(this.v);
    removeCallbacks(this.w);
    this.n.cancel();
    this.o.cancel();
    this.p.cancel();
    this.q.cancel();
    this.r.cancel();
    this.s.cancel();
    this.t.clearAnimation();
    this.t.setText(String.valueOf(23));
    this.u.clearAnimation();
    this.u.setText(String.valueOf(24));
    this.u.setVisibility(4);
    this.b.clearAnimation();
    this.b.setText("Sunny");
    this.b.setCompoundDrawables(null, a(1, true), null, null);
    this.c.a();
    this.d.a();
  }
  
  public long c()
  {
    return 3500L;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.n))
    {
      this.t.setText(String.valueOf(24));
      this.u.setVisibility(4);
      postDelayed(this.w, 800L);
    }
    do
    {
      return;
      if (paramAnimation.equals(this.o))
      {
        this.t.setText(String.valueOf(25));
        this.u.setVisibility(4);
        return;
      }
      if (paramAnimation.equals(this.q))
      {
        this.b.setText("Cloudy");
        this.b.setCompoundDrawables(null, a(2, true), null, null);
        a(this.b, this.s);
        return;
      }
    } while (!paramAnimation.equals(this.r));
    this.b.setText("Overcast");
    this.b.setCompoundDrawables(null, a(3, true), null, null);
    a(this.b, this.s);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((TextView)findViewById(2131230829));
    this.t = ((TextView)findViewById(2131230831));
    this.u = ((TextView)findViewById(2131230832));
    this.c = ((MultiDayScrollView)findViewById(2131230833));
    this.d = ((MultiDayScrollView)findViewById(2131230834));
    e();
    d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AdvancedDayAniView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */