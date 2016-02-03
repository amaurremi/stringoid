package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.gau.go.launcherex.gowidget.weather.util.s;

public class AdvancedMapsAnimView
  extends AdvancedAnimationView
  implements Animation.AnimationListener
{
  private Radar b;
  private View c;
  private Animation d;
  private Animation e;
  
  public AdvancedMapsAnimView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdvancedMapsAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.a = false;
    a(this.b, this.d);
  }
  
  public void b()
  {
    this.a = true;
    this.b.clearAnimation();
    this.b.setVisibility(4);
    this.c.clearAnimation();
    this.c.setVisibility(4);
  }
  
  public long c()
  {
    return 3500L;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a)
    {
      if (!paramAnimation.equals(this.d)) {
        break label39;
      }
      this.b.setVisibility(0);
      a(this.c, this.e);
    }
    label39:
    while (!paramAnimation.equals(this.e)) {
      return;
    }
    this.c.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((Radar)findViewById(2131230841));
    this.d = new TranslateAnimation(1, -1.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    this.d.setDuration(1000L);
    this.d.setAnimationListener(this);
    this.e = s.b(800L);
    this.e.setAnimationListener(this);
    this.c = findViewById(2131230843);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AdvancedMapsAnimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */