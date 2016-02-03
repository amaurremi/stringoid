package com.gtp.go.weather.sharephoto.photo;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class q
  implements Animation.AnimationListener
{
  q(PhotoActivity paramPhotoActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    PhotoActivity.q(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */