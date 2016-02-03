package com.gau.go.launcherex.gowidget.weather.view;

import android.view.View;
import android.widget.ImageView;

class e
  implements Runnable
{
  e(AdvancedPromoAniView paramAdvancedPromoAniView) {}
  
  public void run()
  {
    AdvancedPromoAniView.a(this.a).setVisibility(0);
    AdvancedPromoAniView.a(this.a).startAnimation(AdvancedPromoAniView.b(this.a));
    AdvancedPromoAniView.c(this.a).setVisibility(0);
    AdvancedPromoAniView.c(this.a).startAnimation(AdvancedPromoAniView.d(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */