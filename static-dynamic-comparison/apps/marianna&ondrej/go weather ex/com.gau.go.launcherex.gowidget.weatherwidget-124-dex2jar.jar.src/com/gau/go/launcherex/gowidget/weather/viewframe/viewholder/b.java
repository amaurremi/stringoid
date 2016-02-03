package com.gau.go.launcherex.gowidget.weather.viewframe.viewholder;

import android.content.Context;
import android.view.View;

public class b
{
  protected View e;
  protected Context f;
  
  public b() {}
  
  public b(Context paramContext)
  {
    this.f = paramContext;
  }
  
  public b(Context paramContext, View paramView)
  {
    this.f = paramContext;
    this.e = paramView;
  }
  
  public void a(int paramInt)
  {
    this.e.setVisibility(paramInt);
  }
  
  public View b(int paramInt)
  {
    return this.e.findViewById(paramInt);
  }
  
  public View e()
  {
    return this.e;
  }
  
  public void f() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/viewframe/viewholder/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */