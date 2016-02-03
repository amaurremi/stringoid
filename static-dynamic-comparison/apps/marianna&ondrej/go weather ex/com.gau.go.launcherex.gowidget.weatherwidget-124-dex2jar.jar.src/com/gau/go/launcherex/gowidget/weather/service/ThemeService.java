package com.gau.go.launcherex.gowidget.weather.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.gau.go.launcherex.gowidget.weather.b.a;
import com.gau.go.launcherex.gowidget.weather.b.g;
import com.gau.go.launcherex.gowidget.weather.b.o;

public class ThemeService
  extends Service
{
  private g a;
  private o b;
  private a c;
  private Context d;
  private int e = 0;
  private int f = 0;
  
  public void a()
  {
    this.e += 1;
  }
  
  public void b()
  {
    if (this.e > 0) {
      this.e -= 1;
    }
  }
  
  public void c()
  {
    if (this.e == 0) {
      stopSelfResult(this.f);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.d = getApplicationContext();
    this.e = 0;
    this.f = 0;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
    {
      stopSelfResult(paramInt2);
      return 2;
    }
    this.f = paramInt2;
    switch (paramIntent.getIntExtra("theme_data_request_code", -1))
    {
    case 3: 
    default: 
      return 2;
    case 4: 
      paramIntent = paramIntent.getStringExtra("com.gau.go.launcherex.gowidget.weatherwidget.EXTRA_PACKAGE_CHANGE");
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PACKAGE_REMOVED");
      localIntent.putExtra("com.gau.go.launcherex.gowidget.weatherwidget.EXTRA_PACKAGE_NAME", paramIntent);
      sendBroadcast(localIntent);
      if (this.a == null) {
        this.a = new g(this.d, this);
      }
      if (this.b == null) {
        this.b = new o(this.d, this);
      }
      if (this.c == null) {
        this.c = new a(this.d, this);
      }
      this.a.a(paramIntent);
      this.b.a(paramIntent);
      this.c.a(paramIntent);
      return 2;
    case 5: 
      paramIntent = paramIntent.getStringExtra("com.gau.go.launcherex.gowidget.weatherwidget.EXTRA_PACKAGE_CHANGE");
      if (this.c == null) {
        this.c = new a(this.d, this);
      }
      this.c.b(paramIntent);
      return 2;
    }
    if (this.a == null) {
      this.a = new g(this.d, this);
    }
    if (this.c == null) {
      this.c = new a(this.d, this);
    }
    this.a.a();
    this.c.a();
    return 2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/ThemeService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */