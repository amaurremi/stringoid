package com.gau.go.launcherex.gowidget.weather.globalview;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class o
  implements ViewTreeObserver.OnPreDrawListener
{
  o(n paramn) {}
  
  public boolean onPreDraw()
  {
    n.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    n.b(this.a);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */