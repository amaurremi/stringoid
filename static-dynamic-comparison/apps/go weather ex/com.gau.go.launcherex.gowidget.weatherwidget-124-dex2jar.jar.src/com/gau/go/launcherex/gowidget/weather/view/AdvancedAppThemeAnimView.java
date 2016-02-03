package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.gau.go.launcherex.gowidget.weather.util.s;

public class AdvancedAppThemeAnimView
  extends AdvancedAnimationView
  implements Animation.AnimationListener
{
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private Animation g = s.a(800L);
  private Animation h;
  private Animation i;
  private Animation j;
  private Animation k;
  private Runnable l = new a(this);
  
  public AdvancedAppThemeAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g.setAnimationListener(this);
    this.h = s.c(800L);
    this.i = s.a(false, 400L);
    this.i.setAnimationListener(this);
    this.j = s.a(false, 400L);
    this.j.setAnimationListener(this);
    this.k = s.b(true, 400L);
  }
  
  public void a()
  {
    this.a = false;
    a(this.b, this.g);
    a(this.f, this.h);
  }
  
  public void b()
  {
    this.a = true;
    removeCallbacks(this.l);
    this.g.cancel();
    this.h.cancel();
    this.i.cancel();
    this.j.cancel();
    this.k.cancel();
    this.b.clearAnimation();
    this.b.setVisibility(4);
    this.f.clearAnimation();
    this.f.setVisibility(4);
    this.c.clearAnimation();
    this.c.setVisibility(0);
    this.d.clearAnimation();
    this.d.setVisibility(4);
    this.e.clearAnimation();
    this.e.setVisibility(4);
  }
  
  public long c()
  {
    return 3300L;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a)
    {
      if (!paramAnimation.equals(this.g)) {
        break label43;
      }
      a(this.c, this.k);
      a(this.d, this.i);
    }
    label43:
    do
    {
      return;
      if (paramAnimation.equals(this.i))
      {
        this.c.setVisibility(4);
        postDelayed(this.l, 500L);
        return;
      }
    } while (!paramAnimation.equals(this.j));
    this.d.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = findViewById(2131230823);
    this.c = findViewById(2131230824);
    this.d = findViewById(2131230825);
    this.e = findViewById(2131230826);
    this.f = findViewById(2131230827);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AdvancedAppThemeAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */