package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

public class AdvancedHourAniView
  extends AdvancedAnimationView
  implements Animation.AnimationListener
{
  private Clock b;
  private TextView c;
  private TextView d;
  private Animation e = com.gau.go.launcherex.gowidget.weather.util.s.d(500L);
  private Animation f;
  private Animation g;
  private Animation h;
  private s i;
  private s j;
  private Runnable k = new d(this);
  
  public AdvancedHourAniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e.setAnimationListener(this);
    this.f = com.gau.go.launcherex.gowidget.weather.util.s.d(500L);
    this.f.setAnimationListener(this);
    this.g = com.gau.go.launcherex.gowidget.weather.util.s.c(300L);
    this.g.setAnimationListener(this);
    this.h = com.gau.go.launcherex.gowidget.weather.util.s.c(300L);
    this.h.setAnimationListener(this);
  }
  
  public void a()
  {
    this.a = false;
    postDelayed(this.k, 300L);
  }
  
  public void b()
  {
    this.a = true;
    this.e.cancel();
    this.f.cancel();
    this.g.cancel();
    this.h.cancel();
    this.i.cancel();
    this.j.cancel();
    removeCallbacks(this.k);
    this.c.setText("45");
    this.c.clearAnimation();
    this.b.a();
  }
  
  public long c()
  {
    return 4500L;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a)
    {
      if (!paramAnimation.equals(this.i)) {
        break label31;
      }
      a(this.c, this.e);
    }
    label31:
    do
    {
      return;
      if (paramAnimation.equals(this.e))
      {
        this.c.setText("50");
        a(this.c, this.g);
        return;
      }
      if (paramAnimation.equals(this.g))
      {
        a(this.b, this.j);
        return;
      }
      if (paramAnimation.equals(this.j))
      {
        a(this.c, this.f);
        return;
      }
    } while (!paramAnimation.equals(this.f));
    this.c.setText("53");
    a(this.c, this.h);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((Clock)findViewById(2131230837));
    Clock localClock = this.b;
    localClock.getClass();
    this.i = new s(localClock, 10);
    this.i.setDuration(800L);
    this.i.setAnimationListener(this);
    localClock = this.b;
    localClock.getClass();
    this.j = new s(localClock, 11);
    this.j.setDuration(800L);
    this.j.setAnimationListener(this);
    this.c = ((TextView)findViewById(2131230839));
    this.c.setText("45");
    this.d = ((TextView)findViewById(2131230840));
    this.b.a(this.d);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AdvancedHourAniView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */