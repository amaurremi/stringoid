package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.gau.go.launcherex.gowidget.weather.util.s;

public class AdvancedWorldclockAniView
  extends AdvancedAnimationView
  implements Animation.AnimationListener
{
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  private View n;
  private LineAnimView o;
  private LineAnimView p;
  private LineAnimView q;
  private ae r;
  private ae s;
  private ae t;
  private Animation u = new AlphaAnimation(0.0F, 1.0F);
  private Animation v;
  
  public AdvancedWorldclockAniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.u.setDuration(800L);
    this.v = s.a(500L, -0.5F);
    this.v.setInterpolator(new AccelerateInterpolator(1.5F));
    this.v.setAnimationListener(this);
  }
  
  public void a()
  {
    this.a = false;
    a(this.b, this.u);
    a(this.c, this.v);
    a(this.f, this.v);
    a(this.d, this.v);
    a(this.e, this.v);
  }
  
  public void b()
  {
    this.a = true;
    this.r.cancel();
    this.s.cancel();
    this.t.cancel();
    this.u.cancel();
    this.v.cancel();
    this.b.setVisibility(4);
    this.e.setVisibility(4);
    this.c.setVisibility(4);
    this.f.setVisibility(4);
    this.d.setVisibility(4);
    this.q.setVisibility(4);
    this.p.setVisibility(4);
    this.o.setVisibility(4);
    this.i.setVisibility(4);
    this.g.setVisibility(4);
    this.j.setVisibility(4);
    this.h.setVisibility(4);
    this.m.setVisibility(4);
    this.k.setVisibility(4);
    this.l.setVisibility(4);
    this.n.setVisibility(4);
  }
  
  public long c()
  {
    return 3000L;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a)
    {
      if (!paramAnimation.equals(this.v)) {
        break label103;
      }
      this.g.setVisibility(0);
      this.h.setVisibility(0);
      this.i.setVisibility(0);
      this.j.setVisibility(0);
      a(this.k, s.a(500L, -0.2F));
      a(this.p, this.s);
      a(this.q, this.t);
      a(this.o, this.r);
    }
    label103:
    do
    {
      return;
      if (paramAnimation.equals(this.s))
      {
        a(this.m, s.a(500L, -0.5F));
        return;
      }
      if (paramAnimation.equals(this.t))
      {
        a(this.n, s.a(500L, -0.5F));
        return;
      }
    } while (!paramAnimation.equals(this.r));
    a(this.l, s.a(500L, -0.5F));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = findViewById(2131230863);
    this.c = findViewById(2131230867);
    this.f = findViewById(2131230873);
    this.d = findViewById(2131230865);
    this.e = findViewById(2131230870);
    this.g = findViewById(2131230866);
    this.j = findViewById(2131230872);
    this.h = findViewById(2131230864);
    this.i = findViewById(2131230869);
    this.k = findViewById(2131230876);
    this.n = findViewById(2131230878);
    this.l = findViewById(2131230875);
    this.m = findViewById(2131230877);
    this.q = ((LineAnimView)findViewById(2131230874));
    this.q.a(true);
    LineAnimView localLineAnimView = this.q;
    localLineAnimView.getClass();
    this.t = new ae(localLineAnimView);
    this.t.setDuration(500L);
    this.t.setAnimationListener(this);
    this.o = ((LineAnimView)findViewById(2131230868));
    localLineAnimView = this.o;
    localLineAnimView.getClass();
    this.r = new ae(localLineAnimView);
    this.r.setDuration(800L);
    this.r.setStartOffset(300L);
    this.r.setAnimationListener(this);
    this.p = ((LineAnimView)findViewById(2131230871));
    localLineAnimView = this.p;
    localLineAnimView.getClass();
    this.s = new ae(localLineAnimView);
    this.s.setDuration(800L);
    this.s.setStartOffset(100L);
    this.s.setAnimationListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AdvancedWorldclockAniView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */