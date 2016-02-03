package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Radar
  extends RelativeLayout
{
  private ImageView a;
  
  public Radar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131231881));
    post(new am(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/Radar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */