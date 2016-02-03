package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.gau.go.launcherex.gowidget.weather.util.s;

public class AdvancedNoAdAniView
  extends AdvancedAnimationView
  implements Animation.AnimationListener
{
  private View b;
  private View c;
  private View d;
  private Animation e = s.a(1000L);
  private Animation f;
  private Animation g;
  
  public AdvancedNoAdAniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e.setAnimationListener(this);
    this.f = s.c(1000L);
    this.g = s.e(1000L);
    this.g.setFillAfter(true);
  }
  
  public void a()
  {
    this.a = false;
    a(this.b, this.e);
    a(this.c, this.f);
  }
  
  public void b()
  {
    this.a = true;
    this.e.cancel();
    this.f.cancel();
    this.g.cancel();
    this.b.setVisibility(4);
    this.d.clearAnimation();
    this.d.setVisibility(4);
    this.c.setVisibility(4);
  }
  
  public long c()
  {
    return 3000L;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((!this.a) && (paramAnimation.equals(this.e))) {
      a(this.d, this.g);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = findViewById(2131230845);
    this.c = findViewById(2131230827);
    this.d = findViewById(2131230846);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AdvancedNoAdAniView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */