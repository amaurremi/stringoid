package com.gau.go.launcherex.gowidget.weather.view;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

class f
  implements Runnable
{
  f(AdvancedPromoAniView paramAdvancedPromoAniView) {}
  
  public void run()
  {
    AdvancedPromoAniView.a(this.a).setVisibility(0);
    AdvancedPromoAniView.a(this.a).setImageDrawable(AdvancedPromoAniView.e(this.a));
    AdvancedPromoAniView.e(this.a).start();
    AdvancedPromoAniView.f(this.a).setVisibility(0);
    AdvancedPromoAniView.f(this.a).startAnimation(AdvancedPromoAniView.g(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */