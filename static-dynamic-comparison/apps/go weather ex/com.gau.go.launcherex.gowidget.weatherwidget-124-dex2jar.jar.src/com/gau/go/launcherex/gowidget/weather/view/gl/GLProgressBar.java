package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.go.gl.animation.RotateAnimation;
import com.go.gl.widget.GLImageView;

public class GLProgressBar
  extends GLImageView
{
  private RotateAnimation a = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
  
  public GLProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a.setRepeatCount(-1);
    this.a.setDuration(700L);
    paramContext = new LinearInterpolator();
    this.a.setInterpolator(paramContext);
  }
  
  public void startAnimation()
  {
    setAnimation(null);
    startAnimation(this.a);
  }
  
  public void stopAnimation()
  {
    if (this.a != null) {
      clearAnimation();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */