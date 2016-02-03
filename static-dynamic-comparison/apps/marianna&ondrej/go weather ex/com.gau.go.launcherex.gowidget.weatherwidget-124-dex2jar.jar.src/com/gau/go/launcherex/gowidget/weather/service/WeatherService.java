package com.gau.go.launcherex.gowidget.weather.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.v;
import com.gau.go.launcherex.gowidget.weather.util.w;

public class WeatherService
  extends Service
{
  private m a;
  private SparseArray b = new SparseArray();
  private o c;
  
  private void a()
  {
    this.c = new o(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_TEMPERATURE_UNIT");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIND_UNIT");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DATESTYLE_UNIT");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LUNAR");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_FESTIVAL");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WORLD_CLOCK");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_CYCLE_MODE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_calendar_binding_app");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_GOWIDGET_DYNAMIC_ICON_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GOWIDGET_THEME_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_AUTO_LOCATION");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CONVERT_INDEX_STATE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_ADD_CITY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_CITY");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_NEW_THEME_FLAG_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_THEME_SWITCHER_CHANGE");
    registerReceiver(this.c, localIntentFilter);
  }
  
  private void a(String paramString)
  {
    try
    {
      str = this.a.a(paramString);
      if (!TextUtils.isEmpty(str))
      {
        int j = this.b.size();
        i = 0;
        if (i >= j) {}
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        try
        {
          String str;
          int i;
          ((c)this.b.valueAt(i)).a(paramString, str);
          i += 1;
        }
        catch (RemoteException paramString)
        {
          Object localObject;
          paramString.printStackTrace();
        }
        localRemoteException = localRemoteException;
        localRemoteException.printStackTrace();
        localObject = null;
      }
    }
  }
  
  private void b()
  {
    try
    {
      boolean bool = this.a.d();
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        ((c)this.b.valueAt(i)).a(bool);
        i += 1;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  private void b(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("extra_convert_from_index", -1);
    int k = paramIntent.getIntExtra("extra_convert_to_index", -1);
    if ((j >= 0) && (k >= 0) && (j != k))
    {
      int m = this.b.size();
      int i = 0;
      for (;;)
      {
        if (i < m) {
          try
          {
            ((c)this.b.valueAt(i)).a(j, k);
            i += 1;
          }
          catch (RemoteException paramIntent)
          {
            paramIntent.printStackTrace();
          }
        }
      }
    }
  }
  
  private void c(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("city_code");
    paramIntent = paramIntent.getStringExtra("city_name");
    WeatherBean localWeatherBean = new WeatherBean();
    localWeatherBean.c(str);
    localWeatherBean.e(paramIntent);
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          ((c)this.b.valueAt(i)).a(localWeatherBean);
          i += 1;
        }
        catch (RemoteException paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
    }
  }
  
  private void d(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("city_code_list");
    int j = this.b.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          ((c)this.b.valueAt(i)).a(paramIntent);
          i += 1;
        }
        catch (RemoteException paramIntent)
        {
          paramIntent.printStackTrace();
        }
      }
    }
  }
  
  private void e(Intent paramIntent)
  {
    try
    {
      paramIntent = this.a.c();
      if (paramIntent != null)
      {
        int j = this.b.size();
        int i = 0;
        while (i < j)
        {
          ((c)this.b.valueAt(i)).b(paramIntent);
          i += 1;
        }
      }
      return;
    }
    catch (RemoteException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  private void f(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("extra_new_theme_flag", 0);
    try
    {
      int k = this.b.size();
      int i = 0;
      if (i < k)
      {
        paramIntent = (c)this.b.valueAt(i);
        if (j == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramIntent.b(bool);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (RemoteException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void a(Intent paramIntent)
  {
    w localw = new v().a(paramIntent);
    int i;
    if (localw != null) {
      switch (localw.a)
      {
      default: 
        i = 0;
        if (i == 0) {
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = this.a.a();
        int j = this.b.size();
        i = 0;
        if (i >= j) {
          break label129;
        }
        ((c)this.b.valueAt(i)).a(localw.a, paramIntent);
        i += 1;
        continue;
        i = 1;
      }
      catch (RemoteException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      i = 0;
      break;
      label129:
      return;
      paramIntent = null;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = new m(this);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/service/WeatherService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */