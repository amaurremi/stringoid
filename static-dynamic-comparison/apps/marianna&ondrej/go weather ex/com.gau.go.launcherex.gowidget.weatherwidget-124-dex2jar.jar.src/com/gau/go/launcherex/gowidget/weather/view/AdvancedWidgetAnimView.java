package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.gau.go.launcherex.gowidget.weather.util.s;

public class AdvancedWidgetAnimView
  extends AdvancedAnimationView
  implements Animation.AnimationListener
{
  private View b;
  private View c;
  private View d;
  private Animation e = s.i(500L);
  private Animation f;
  private Animation g = s.g(500L);
  private Runnable h = new i(this);
  private Runnable i = new j(this);
  
  public AdvancedWidgetAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e.setAnimationListener(this);
    this.f = s.i(500L);
    this.f.setAnimationListener(this);
  }
  
  public void a()
  {
    this.a = false;
    postDelayed(this.h, 500L);
  }
  
  public void b()
  {
    this.a = true;
    removeCallbacks(this.h);
    removeCallbacks(this.i);
    this.e.cancel();
    this.f.cancel();
    this.g.cancel();
    this.b.setVisibility(0);
    this.c.setVisibility(4);
    this.d.setVisibility(4);
  }
  
  public long c()
  {
    return 3500L;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a)
    {
      if (!paramAnimation.equals(this.e)) {
        break label39;
      }
      this.b.setVisibility(4);
      postDelayed(this.i, 800L);
    }
    label39:
    while (!paramAnimation.equals(this.f)) {
      return;
    }
    this.c.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = findViewById(2131230824);
    this.c = findViewById(2131230825);
    this.d = findViewById(2131230826);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AdvancedWidgetAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */