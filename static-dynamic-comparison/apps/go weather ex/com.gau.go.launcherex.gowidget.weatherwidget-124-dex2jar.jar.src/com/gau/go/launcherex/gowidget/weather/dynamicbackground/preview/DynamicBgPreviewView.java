package com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.gau.go.launcherex.gowidget.weather.scroller.WeatherDetailScrollGroup;

public class DynamicBgPreviewView
  extends LinearLayout
{
  private Context a = null;
  private LayoutInflater b = null;
  private WeatherDetailScrollGroup c = null;
  
  public DynamicBgPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public WeatherDetailScrollGroup a()
  {
    return this.c;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    DynamicbgDescriptionView localDynamicbgDescriptionView = (DynamicbgDescriptionView)this.b.inflate(2130903126, null);
    localDynamicbgDescriptionView.a(paramInt1, paramInt2);
    this.c.addView(localDynamicbgDescriptionView);
    this.c.a();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = LayoutInflater.from(this.a);
    this.c = ((WeatherDetailScrollGroup)findViewById(2131231299));
    this.c.setTag(Boolean.valueOf(false));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/dynamicbackground/preview/DynamicBgPreviewView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */