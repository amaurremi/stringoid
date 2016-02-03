package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import com.gau.go.launcherex.gowidget.weather.util.s;

public class AdvancedPromoAniView
  extends AdvancedAnimationView
  implements Animation.AnimationListener
{
  private LightAnimView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private View f;
  private View g;
  private ad h;
  private Animation i = s.b(500L);
  private Animation j;
  private Animation k;
  private AnimationDrawable l = (AnimationDrawable)getResources().getDrawable(2130837525);
  private AnimationDrawable m = (AnimationDrawable)getResources().getDrawable(2130837515);
  private AnimationDrawable n = (AnimationDrawable)getResources().getDrawable(2130837569);
  private Runnable o = new e(this);
  private Runnable p = new f(this);
  private Runnable q = new g(this);
  
  public AdvancedPromoAniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.i.setInterpolator(new BounceInterpolator());
    this.i.setAnimationListener(this);
    this.j = s.c(300L);
    this.j.setAnimationListener(this);
    this.k = s.j(300L);
    this.k.setInterpolator(new BounceInterpolator());
    this.k.setAnimationListener(this);
  }
  
  private void d()
  {
    this.l.stop();
    this.c.setImageResource(2130837520);
    this.m.stop();
    this.d.setImageResource(2130837516);
    this.n.stop();
    this.e.setImageDrawable(null);
  }
  
  public void a()
  {
    postDelayed(this.o, 300L);
  }
  
  public void b()
  {
    d();
    removeCallbacks(this.o);
    removeCallbacks(this.p);
    removeCallbacks(this.q);
    this.h.cancel();
    this.c.setVisibility(4);
    this.b.setVisibility(4);
    this.e.setVisibility(4);
    this.f.setVisibility(4);
    this.g.setVisibility(4);
  }
  
  public long c()
  {
    return 5000L;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.i))
    {
      postDelayed(this.p, 200L);
      postDelayed(this.q, 400L);
    }
    while (!paramAnimation.equals(this.k)) {
      return;
    }
    this.d.setImageDrawable(this.m);
    this.m.start();
    this.e.setVisibility(0);
    this.e.setImageDrawable(this.n);
    this.n.start();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.g = findViewById(2131230838);
    this.d = ((ImageView)findViewById(2131230850));
    this.c = ((ImageView)findViewById(2131230848));
    this.f = findViewById(2131230827);
    this.b = ((LightAnimView)findViewById(2131230852));
    this.e = ((ImageView)findViewById(2131230853));
    LightAnimView localLightAnimView = this.b;
    localLightAnimView.getClass();
    this.h = new ad(localLightAnimView);
    this.h.setDuration(200L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AdvancedPromoAniView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */