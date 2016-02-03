package com.gau.go.launcherex.goweather.a;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.gau.go.launcherex.gowidget.weather.view.MapDetailActivity;

public class b
{
  private MapDetailActivity a;
  private Animation b;
  private Animation c;
  private Animation d;
  private Animation e;
  
  public b(MapDetailActivity paramMapDetailActivity)
  {
    this.a = paramMapDetailActivity;
    this.b = new TranslateAnimation(1, -1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    this.b.setInterpolator(new DecelerateInterpolator());
    this.b.setDuration(150L);
    this.c = new TranslateAnimation(1, 0.0F, 1, -1.0F, 1, 0.0F, 1, 0.0F);
    this.c.setInterpolator(new AccelerateInterpolator());
    this.c.setDuration(150L);
    this.d = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    this.d.setInterpolator(new DecelerateInterpolator());
    this.d.setDuration(500L);
    this.e = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.e.setInterpolator(new AccelerateInterpolator());
    this.e.setDuration(300L);
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView.clearAnimation();
    c localc = new c(this, paramView, paramInt);
    if (paramInt == 0)
    {
      this.b.setAnimationListener(localc);
      paramView.startAnimation(this.b);
      return;
    }
    this.c.setAnimationListener(localc);
    paramView.startAnimation(this.c);
  }
  
  public void b(View paramView, int paramInt)
  {
    paramView.clearAnimation();
    d locald = new d(this, paramView, paramInt);
    if (paramInt == 0)
    {
      this.d.setAnimationListener(locald);
      paramView.startAnimation(this.d);
      return;
    }
    this.e.setAnimationListener(locald);
    paramView.startAnimation(this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */