package com.gtp.go.weather.sharephoto;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.gau.go.launcherex.gowidget.weather.util.b;

class q
  extends b
{
  q(PhotoDetailActivity paramPhotoDetailActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PhotoDetailActivity.o(this.a).setEnabled(true);
    PhotoDetailActivity.g(this.a).setEnabled(true);
    PhotoDetailActivity.h(this.a).setVisibility(8);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    PhotoDetailActivity.o(this.a).setEnabled(false);
    PhotoDetailActivity.g(this.a).setEnabled(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */