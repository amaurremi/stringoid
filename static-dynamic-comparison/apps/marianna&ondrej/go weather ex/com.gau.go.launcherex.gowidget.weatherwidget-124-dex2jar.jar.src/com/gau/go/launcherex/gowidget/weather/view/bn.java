package com.gau.go.launcherex.gowidget.weather.view;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.f.c;
import com.gau.go.launcherex.gowidget.weather.util.b;

class bn
  extends b
{
  bn(bl parambl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bl.f(this.a).setVisibility(8);
    bl.h(this.a).setImageDrawable(c.a(bl.b(this.a).b, bl.a(this.a, bl.g(this.a) / 10, true), bl.b(this.a).a));
    bl.i(this.a).setImageDrawable(c.a(bl.b(this.a).b, bl.a(this.a, bl.g(this.a) % 10, true), bl.b(this.a).a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */