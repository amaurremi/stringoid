package com.gau.go.launcherex.gowidget.weather.view;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

class am
  implements Runnable
{
  am(Radar paramRadar) {}
  
  public void run()
  {
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)Radar.a(this.a).getBackground();
    if (localAnimationDrawable != null) {
      localAnimationDrawable.start();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */