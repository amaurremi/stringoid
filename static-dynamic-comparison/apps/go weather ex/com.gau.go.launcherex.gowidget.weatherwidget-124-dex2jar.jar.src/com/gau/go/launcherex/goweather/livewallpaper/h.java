package com.gau.go.launcherex.goweather.livewallpaper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.gtp.go.weather.sharephoto.x;
import com.jiubang.core.a.e;
import com.jiubang.core.a.l;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class h
{
  private int a = 1;
  private boolean b = true;
  private boolean c = true;
  private a d;
  private j e;
  private ExecutorService f;
  private Context g;
  private Handler h;
  private boolean i;
  private com.gau.go.launcherex.goweather.livewallpaper.b.a j;
  private x k;
  
  public h(Context paramContext, com.gau.go.launcherex.goweather.livewallpaper.b.a parama, com.gau.go.launcherex.goweather.livewallpaper.b.c paramc)
  {
    this.g = paramContext;
    this.d = new a(paramContext, paramc);
    this.f = Executors.newFixedThreadPool(1);
    this.j = parama;
    this.k = new x(paramContext);
    c();
  }
  
  private String a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramInt)
    {
    default: 
      if (!paramBoolean2) {
        break label254;
      }
      if (paramBoolean1) {
        return "wallpaper/weather_dynamicbackground_sunny_day.xml";
      }
      break;
    case 2: 
      if (paramBoolean2)
      {
        if (paramBoolean1) {
          return "wallpaper/weather_dynamicbackground_sunny_day.xml";
        }
        return "wallpaper/weather_background_sunny_day.xml";
      }
      if (paramBoolean1) {
        return "wallpaper/weather_dynamicbackground_sunny_night.xml";
      }
      return "wallpaper/weather_background_sunny_night.xml";
    case 3: 
      if (paramBoolean2)
      {
        if (paramBoolean1) {
          return "wallpaper/weather_dynamicbackground_cloudy_day.xml";
        }
        return "wallpaper/weather_background_cloudy_day.xml";
      }
      if (paramBoolean1) {
        return "wallpaper/weather_dynamicbackground_cloudy_night.xml";
      }
      return "wallpaper/weather_background_cloudy_night.xml";
    case 4: 
      if (paramBoolean2)
      {
        if (paramBoolean1) {
          return "wallpaper/weather_dynamicbackground_overcast_day.xml";
        }
        return "wallpaper/weather_background_overcast_day.xml";
      }
      if (paramBoolean1) {
        return "wallpaper/weather_dynamicbackground_overcast_night.xml";
      }
      return "wallpaper/weather_background_overcast_night.xml";
    case 5: 
      if (paramBoolean2)
      {
        if (paramBoolean1) {
          return "wallpaper/weather_dynamicbackground_snowy_day.xml";
        }
        return "wallpaper/weather_background_snowy_day.xml";
      }
      if (paramBoolean1) {
        return "wallpaper/weather_dynamicbackground_snowy_night.xml";
      }
      return "wallpaper/weather_background_snowy_night.xml";
    case 6: 
      if (paramBoolean2)
      {
        if (paramBoolean1) {
          return "wallpaper/weather_dynamicbackground_foggy_day.xml";
        }
        return "wallpaper/weather_background_foggy_day.xml";
      }
      if (paramBoolean1) {
        return "wallpaper/weather_dynamicbackground_foggy_night.xml";
      }
      return "wallpaper/weather_background_foggy_night.xml";
    case 7: 
      if (paramBoolean2)
      {
        if (paramBoolean1) {
          return "wallpaper/weather_dynamicbackground_rainy_day.xml";
        }
        return "wallpaper/weather_background_rainy_day.xml";
      }
      if (paramBoolean1) {
        return "wallpaper/weather_dynamicbackground_rainy_night.xml";
      }
      return "wallpaper/weather_background_rainy_night.xml";
    case 8: 
      if (paramBoolean2)
      {
        if (paramBoolean1) {
          return "wallpaper/weather_dynamicbackground_thunderstorm_day.xml";
        }
        return "wallpaper/weather_background_thunderstorm_day.xml";
      }
      if (paramBoolean1) {
        return "wallpaper/weather_dynamicbackground_thunderstorm_night.xml";
      }
      return "wallpaper/weather_background_thunderstorm_night.xml";
    case 1: 
      if (paramBoolean2)
      {
        if (paramBoolean1) {
          return "wallpaper/weather_dynamicbackground_sunny_day.xml";
        }
        return "wallpaper/weather_background_sunny_day.xml";
      }
      if (paramBoolean1) {
        return "wallpaper/weather_dynamicbackground_sunny_night.xml";
      }
      return "wallpaper/weather_background_sunny_night.xml";
    }
    return "wallpaper/weather_background_sunny_day.xml";
    label254:
    if (paramBoolean1) {
      return "wallpaper/weather_dynamicbackground_sunny_night.xml";
    }
    return "wallpaper/weather_background_sunny_night.xml";
  }
  
  private void a(l paraml, boolean paramBoolean)
  {
    this.c = paramBoolean;
    Message localMessage = this.h.obtainMessage(1);
    localMessage.obj = paraml;
    this.h.sendMessage(localMessage);
  }
  
  private void c()
  {
    this.h = new i(this);
  }
  
  public void a()
  {
    com.gtp.a.a.b.c.a("wallpaper", "setPhotoBackground:[packageName]=" + this.d.a());
    Object localObject = this.g.getResources().getDisplayMetrics();
    int n = ((DisplayMetrics)localObject).widthPixels;
    if (com.gtp.a.a.c.c.b(this.g)) {}
    for (int m = com.gtp.a.a.c.c.a(this.g);; m = ((DisplayMetrics)localObject).heightPixels)
    {
      e.a(n, m);
      localObject = this.k.a();
      if (localObject != null) {
        a((l)localObject, false);
      }
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    com.gtp.a.a.b.c.a("wallpaper", "setDynamicBg:[packageName]=" + this.d.a());
    if (d.a(this.d.a())) {
      a();
    }
    do
    {
      do
      {
        return;
      } while ((this.a == paramInt) && (this.b == paramBoolean2) && (this.c == paramBoolean1) && (!paramBoolean3));
      this.a = paramInt;
      this.b = paramBoolean2;
      this.c = paramBoolean1;
      if (this.e != null) {
        this.e.a(true);
      }
    } while (this.f == null);
    String str = a(this.a, this.c, this.b);
    z localz = this.d.a(str);
    if (localz == null)
    {
      Toast.makeText(this.g, 2131165776, 0).show();
      this.d.c(str);
      return;
    }
    this.e = new j(this, localz, this.d.a());
    this.f.execute(this.e);
  }
  
  public void a(String paramString)
  {
    this.d.b(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b()
  {
    if (this.e != null) {
      this.e.a(true);
    }
    this.f.shutdown();
    this.f = null;
    this.d.b();
    this.i = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */