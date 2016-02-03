package com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.DynamicBackgroundView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d
{
  private DynamicBackgroundView a = null;
  private int b;
  private int c;
  private boolean d;
  private Context e;
  private Handler f;
  private e g;
  private ExecutorService h;
  private a i;
  
  public d(Context paramContext)
  {
    this.e = paramContext;
    b();
    this.h = Executors.newFixedThreadPool(1);
  }
  
  private String a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      if ((paramInt2 != 1) && (paramInt2 != 0)) {
        break label299;
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_sunny_day.xml";
      }
      break;
    case 2: 
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_sunny_day.xml";
        }
        return "background/weather_background_sunny_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_sunny_night.xml";
      }
      return "background/weather_background_sunny_night.xml";
    case 3: 
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_cloudy_day.xml";
        }
        return "background/weather_background_cloudy_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_cloudy_night.xml";
      }
      return "background/weather_background_cloudy_night.xml";
    case 4: 
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_overcast_day.xml";
        }
        return "background/weather_background_overcast_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_overcast_night.xml";
      }
      return "background/weather_background_overcast_night.xml";
    case 5: 
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_snowy_day.xml";
        }
        return "background/weather_background_snowy_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_snowy_night.xml";
      }
      return "background/weather_background_snowy_night.xml";
    case 6: 
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_foggy_day.xml";
        }
        return "background/weather_background_foggy_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_foggy_night.xml";
      }
      return "background/weather_background_foggy_night.xml";
    case 7: 
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_rainy_day.xml";
        }
        return "background/weather_background_rainy_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_rainy_night.xml";
      }
      return "background/weather_background_rainy_night.xml";
    case 8: 
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_thunderstorm_day.xml";
        }
        return "background/weather_background_thunderstorm_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_thunderstorm_night.xml";
      }
      return "background/weather_background_thunderstorm_night.xml";
    case 1: 
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        if (paramBoolean) {
          return "background/weather_dynamicbackground_sunny_day.xml";
        }
        return "background/weather_background_sunny_day.xml";
      }
      if (paramBoolean) {
        return "background/weather_dynamicbackground_sunny_night.xml";
      }
      return "background/weather_background_sunny_night.xml";
    }
    return "background/weather_background_sunny_day.xml";
    label299:
    if (paramBoolean) {
      return "background/weather_dynamicbackground_sunny_night.xml";
    }
    return "background/weather_background_sunny_night.xml";
  }
  
  private void b()
  {
    this.f = new f(this);
  }
  
  public void a()
  {
    if (this.g != null) {
      this.g.a(true);
    }
    com.jiubang.core.a.f.b(this.a);
    com.jiubang.core.a.f.a();
    this.a.b();
    this.h.shutdown();
    this.h = null;
  }
  
  public void a(int paramInt)
  {
    this.a.setBackgroundColor(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    z localz;
    if ((this.b != paramInt1) || (this.c != paramInt2) || (this.d != paramBoolean))
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramBoolean;
      if (this.g != null) {
        this.g.a(true);
      }
      if (this.h != null)
      {
        String str = a(this.b, this.d, paramInt2);
        localz = this.i.a(str);
        if (localz != null) {
          break label115;
        }
        Toast.makeText(this.e, 2131165776, 0).show();
        this.i.b(str);
      }
    }
    return;
    label115:
    this.g = new e(this, localz, this.i.a());
    this.h.execute(this.g);
  }
  
  public void a(DynamicBackgroundView paramDynamicBackgroundView)
  {
    this.a = paramDynamicBackgroundView;
  }
  
  public void a(a parama)
  {
    this.i = parama;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/dynamicbackground/preview/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */