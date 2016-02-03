package com.gau.go.launcherex.goweather.goplay;

import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.gtp.go.weather.sharephoto.d.h;
import com.gtp.go.weather.sharephoto.x;

class d
  implements Runnable
{
  d(InstalledAppBackgroundPreviewView paramInstalledAppBackgroundPreviewView) {}
  
  public void run()
  {
    int i = InstalledAppBackgroundPreviewView.a(this.a).getHeight() * 480 / 800;
    InstalledAppBackgroundPreviewView.a(this.a).getLayoutParams().width = i;
    InstalledAppBackgroundPreviewView.a(this.a).requestLayout();
    Bitmap localBitmap = h.a(InstalledAppBackgroundPreviewView.c(this.a), x.a, null);
    InstalledAppBackgroundPreviewView.d(this.a).setImageBitmap(localBitmap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */