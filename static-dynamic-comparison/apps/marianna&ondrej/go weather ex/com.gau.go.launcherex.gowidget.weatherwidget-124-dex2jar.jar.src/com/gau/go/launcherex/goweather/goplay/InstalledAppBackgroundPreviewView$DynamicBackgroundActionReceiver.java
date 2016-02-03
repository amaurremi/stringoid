package com.gau.go.launcherex.goweather.goplay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.goweather.livewallpaper.b.h;
import com.gau.go.launcherex.gowidget.scriptengine.parser.DescriptionBean;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview.DynamicBgPreviewView;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview.DynamicbgDescriptionView;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview.d;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.scroller.WeatherDetailScrollGroup;
import com.go.weatherex.themestore.detail.IndicatorView;
import java.util.ArrayList;

public class InstalledAppBackgroundPreviewView$DynamicBackgroundActionReceiver
  extends BroadcastReceiver
{
  public InstalledAppBackgroundPreviewView$DynamicBackgroundActionReceiver(InstalledAppBackgroundPreviewView paramInstalledAppBackgroundPreviewView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SCREEN_BACKGROUND_PREVIEW_DONE".equals(paramContext))
    {
      InstalledAppBackgroundPreviewView.e(this.a);
      paramContext = paramIntent.getParcelableArrayListExtra("extra_dynamicbackground_preview");
      if (paramContext != null)
      {
        int j = paramContext.size();
        if (j > 0)
        {
          InstalledAppBackgroundPreviewView.f(this.a).b(j);
          InstalledAppBackgroundPreviewView.f(this.a).c(0);
          InstalledAppBackgroundPreviewView.g(this.a).a(0);
          int i = 0;
          while (i < j)
          {
            paramIntent = (DescriptionBean)paramContext.get(i);
            InstalledAppBackgroundPreviewView.h(this.a).a(paramIntent.c(), paramIntent.a());
            i += 1;
          }
          paramIntent = ((DynamicbgDescriptionView)InstalledAppBackgroundPreviewView.h(this.a).a().getChildAt(0)).c();
          InstalledAppBackgroundPreviewView.i(this.a).setText(paramIntent);
          if (InstalledAppBackgroundPreviewView.j(this.a) != null) {
            InstalledAppBackgroundPreviewView.g(this.a).a(((DescriptionBean)paramContext.get(0)).c(), ((DescriptionBean)paramContext.get(0)).a(), true);
          }
        }
      }
      InstalledAppBackgroundPreviewView.a(this.a).setVisibility(0);
    }
    do
    {
      do
      {
        return;
      } while ((!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_DONE".equals(paramContext)) && (!"com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_ALL_SCRIPT_DONE".equals(paramContext)));
      InstalledAppBackgroundPreviewView.e(this.a);
    } while ((InstalledAppBackgroundPreviewView.b(this.a) == null) || (InstalledAppBackgroundPreviewView.b(this.a).t()) || (!h.a(InstalledAppBackgroundPreviewView.c(this.a).getApplicationContext())));
    Toast.makeText(InstalledAppBackgroundPreviewView.c(this.a), 2131166418, 1).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/InstalledAppBackgroundPreviewView$DynamicBackgroundActionReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */