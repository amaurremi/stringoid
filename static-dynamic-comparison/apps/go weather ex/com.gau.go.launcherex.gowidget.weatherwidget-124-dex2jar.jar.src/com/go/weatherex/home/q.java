package com.go.weatherex.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.ArrayList;
import java.util.List;

public class q
{
  private void a(Activity paramActivity)
  {
    Object localObject = c.a(paramActivity.getApplicationContext());
    ArrayList localArrayList = ((c)localObject).h().d();
    if (localArrayList.size() == 0) {}
    while (!((c)localObject).f().g()) {
      return;
    }
    localObject = paramActivity.getApplicationContext().getSharedPreferences("weather_info_file", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("KEY_REFRESH_WEATHER_IN_PROGRESS", true);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new ArrayList();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      WeatherBean localWeatherBean = (WeatherBean)localArrayList.get(i);
      RequestBean localRequestBean = new RequestBean();
      localRequestBean.a(localWeatherBean.c(), localWeatherBean.d(), localWeatherBean.k.g());
      ((ArrayList)localObject).add(localRequestBean);
      i += 1;
    }
    a(paramActivity, (ArrayList)localObject, 22, 3);
  }
  
  private void a(Activity paramActivity, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", paramInt1);
    localIntent.putParcelableArrayListExtra("req_arg", paramArrayList);
    localIntent.putExtra("updateWay", paramInt2);
    paramActivity.getApplicationContext().startService(localIntent);
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    if (c.a(paramActivity.getApplicationContext()).b()) {
      a(paramActivity);
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    paramBundle = c.a(paramActivity.getApplicationContext());
    if (paramBundle.b())
    {
      a(paramActivity);
      return;
    }
    paramBundle.a(new r(this, paramActivity, paramBundle));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */