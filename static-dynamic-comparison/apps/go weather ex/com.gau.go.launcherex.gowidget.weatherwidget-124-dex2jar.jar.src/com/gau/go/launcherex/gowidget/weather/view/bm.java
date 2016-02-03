package com.gau.go.launcherex.gowidget.weather.view;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.f.c;
import com.gau.go.launcherex.gowidget.weather.util.b;

class bm
  extends b
{
  bm(bl parambl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bl.a(this.a).setVisibility(8);
    bl.d(this.a).setImageDrawable(c.a(bl.b(this.a).b, bl.a(this.a, bl.c(this.a) / 10, true), bl.b(this.a).a));
    bl.e(this.a).setImageDrawable(c.a(bl.b(this.a).b, bl.a(this.a, bl.c(this.a) % 10, true), bl.b(this.a).a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */