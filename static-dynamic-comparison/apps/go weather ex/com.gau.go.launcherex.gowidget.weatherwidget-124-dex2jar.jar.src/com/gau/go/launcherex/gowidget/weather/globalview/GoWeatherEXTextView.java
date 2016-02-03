package com.gau.go.launcherex.gowidget.weather.globalview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.d;

public class GoWeatherEXTextView
  extends TextView
{
  public GoWeatherEXTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GoWeatherEXTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d.a(paramContext).a(this, paramAttributeSet);
  }
  
  public GoWeatherEXTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d.a(paramContext).a(this, paramAttributeSet);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/GoWeatherEXTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */