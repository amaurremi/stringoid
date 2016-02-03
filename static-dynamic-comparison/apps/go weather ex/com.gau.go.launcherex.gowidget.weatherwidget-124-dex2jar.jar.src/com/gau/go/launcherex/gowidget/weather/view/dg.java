package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public abstract class dg
  extends FrameLayout
{
  private dh a;
  protected Context b;
  protected LayoutInflater c;
  
  public dg(Context paramContext, dh paramdh)
  {
    super(paramContext);
    this.b = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.c.inflate(a(), this);
    this.a = paramdh;
  }
  
  public abstract int a();
  
  public dh n()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */