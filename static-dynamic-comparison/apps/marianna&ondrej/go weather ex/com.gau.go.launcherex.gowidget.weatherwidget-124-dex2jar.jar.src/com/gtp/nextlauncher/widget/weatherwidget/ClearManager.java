package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;

public class ClearManager
{
  private c a;
  private Context b;
  
  private void a()
  {
    if (this.a == null) {
      this.a = new c(this, this.b.getContentResolver());
    }
    this.a.a(1, null, WeatherContentProvider.D, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/ClearManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */