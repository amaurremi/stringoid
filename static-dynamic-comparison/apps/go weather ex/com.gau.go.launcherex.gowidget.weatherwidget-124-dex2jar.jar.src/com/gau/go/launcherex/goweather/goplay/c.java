package com.gau.go.launcherex.goweather.goplay;

import android.widget.FrameLayout;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;

class c
  implements Runnable
{
  c(InstalledAppBackgroundPreviewView paramInstalledAppBackgroundPreviewView) {}
  
  public void run()
  {
    int i = InstalledAppBackgroundPreviewView.a(this.a).getHeight() * 480 / 800;
    InstalledAppBackgroundPreviewView.a(this.a).getLayoutParams().width = i;
    InstalledAppBackgroundPreviewView.a(this.a).requestLayout();
    String str = InstalledAppBackgroundPreviewView.b(this.a).x();
    InstalledAppBackgroundPreviewView.a(this.a, str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */