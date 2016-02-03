package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.util.s;

public class AdvancedRainAniView
  extends AdvancedAnimationView
  implements Animation.AnimationListener, be
{
  private View b;
  private Water c;
  private WaterDropView d;
  private View e;
  private View f;
  private TextView g;
  private CurveAnimView h;
  private Animation i = s.a(1000L);
  private Animation j;
  private Animation k;
  private Animation l;
  private Animation m;
  private Animation n;
  private Runnable o = new h(this);
  
  public AdvancedRainAniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.i.setAnimationListener(this);
    this.j = s.c(1000L);
    this.k = s.c(500L);
    this.k.setAnimationListener(this);
    this.l = s.c(500L);
  }
  
  private void a(View paramView, Animation paramAnimation, long paramLong)
  {
    if (paramView.getVisibility() != 0) {
      paramView.setVisibility(0);
    }
    paramAnimation.setStartOffset(paramLong);
    paramView.startAnimation(paramAnimation);
  }
  
  public void a()
  {
    this.a = false;
    postDelayed(this.o, 300L);
  }
  
  public void b()
  {
    this.a = true;
    this.i.cancel();
    this.j.cancel();
    this.k.cancel();
    this.l.cancel();
    this.m.cancel();
    this.n.cancel();
    removeCallbacks(this.o);
    this.b.setVisibility(4);
    this.c.a();
    this.c.setVisibility(4);
    this.d.c();
    this.d.a = this.d.getHeight();
    this.e.setVisibility(4);
    this.f.clearAnimation();
    this.f.setVisibility(4);
    this.h.a();
    this.h.setVisibility(4);
  }
  
  public long c()
  {
    return 6000L;
  }
  
  public void d()
  {
    a(this.h, this.n);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a)
    {
      if (!paramAnimation.equals(this.i)) {
        break label56;
      }
      this.d.b();
      a(this.f, this.l, 1000L);
      a(this.c, this.k, 1000L);
    }
    label56:
    do
    {
      return;
      if (paramAnimation.equals(this.k))
      {
        a(this.c, this.m);
        return;
      }
    } while (!paramAnimation.equals(this.m));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = findViewById(2131230858);
    this.c = ((Water)findViewById(2131230857));
    this.g = ((TextView)findViewById(2131230859));
    Object localObject = this.c;
    localObject.getClass();
    this.m = new bc((Water)localObject);
    this.m.setAnimationListener(this);
    this.m.setDuration(1500L);
    this.c.a(this.g);
    this.d = ((WaterDropView)findViewById(2131230856));
    this.d.a(this);
    this.c.a = this.d;
    this.e = findViewById(2131230827);
    this.f = findViewById(2131230838);
    this.h = ((CurveAnimView)findViewById(2131230854));
    localObject = this.h;
    localObject.getClass();
    this.n = new t((CurveAnimView)localObject);
    this.n.setDuration(2000L);
    this.n.setAnimationListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AdvancedRainAniView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */