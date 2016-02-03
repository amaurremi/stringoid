package com.gtp.go.weather.sharephoto;

import android.view.View;
import android.view.animation.Animation;
import com.gau.go.launcherex.gowidget.weather.util.b;

class p
  extends b
{
  p(PhotoDetailActivity paramPhotoDetailActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PhotoDetailActivity.n(this.a).setEnabled(true);
    PhotoDetailActivity.n(this.a).setVisibility(8);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    PhotoDetailActivity.n(this.a).setEnabled(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */