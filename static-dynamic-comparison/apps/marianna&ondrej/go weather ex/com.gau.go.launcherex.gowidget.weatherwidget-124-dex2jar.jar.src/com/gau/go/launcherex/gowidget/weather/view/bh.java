package com.gau.go.launcherex.gowidget.weather.view;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.f.d;
import com.gau.go.launcherex.gowidget.weather.util.b;

class bh
  extends b
{
  bh(bg parambg) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bg.a(this.a).setVisibility(8);
    bg.d(this.a).setImageDrawable(d.a(bg.b(this.a).b, bg.a(this.a, bg.c(this.a) / 10, true), bg.b(this.a).a));
    bg.e(this.a).setImageDrawable(d.a(bg.b(this.a).b, bg.a(this.a, bg.c(this.a) % 10, true), bg.b(this.a).a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */