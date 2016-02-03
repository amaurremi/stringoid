package com.gau.go.launcherex.gowidget.weather.systemwidget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.x;
import com.gau.go.launcherex.gowidget.weather.service.AppWidgetService;
import com.gau.go.launcherex.gowidget.weather.view.ThemeSettingActivity;
import java.util.ArrayList;
import java.util.List;

public class u
{
  protected Context b;
  protected List c = new ArrayList();
  protected boolean d = true;
  protected boolean e = false;
  
  protected PendingIntent a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", 19);
    return PendingIntent.getService(paramContext, 458752, localIntent, 134217728);
  }
  
  protected PendingIntent a(Context paramContext, x paramx)
  {
    int i = 327680;
    Intent localIntent = new Intent(paramContext, ThemeSettingActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("extra_theme_entrance", 2);
    if (paramx != null) {
      i = 327680 + paramx.a();
    }
    return PendingIntent.getActivity(paramContext, i, localIntent, 134217728);
  }
  
  protected PendingIntent a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", 23);
    localIntent.putExtra("request_extra_url", paramString);
    return PendingIntent.getService(paramContext, 589824, localIntent, 134217728);
  }
  
  protected int b(Context paramContext, String paramString)
  {
    int i = -1;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 1);
      if (paramContext != null) {
        i = paramContext.versionCode;
      }
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return -1;
  }
  
  protected PendingIntent b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AppWidgetService.class);
    localIntent.putExtra("appwidget_service_request", 20);
    return PendingIntent.getService(paramContext, 524288, localIntent, 134217728);
  }
  
  protected PendingIntent c(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      localObject = (WeatherBean)this.c.get(i);
      RequestBean localRequestBean = new RequestBean();
      localRequestBean.a(((WeatherBean)localObject).c(), ((WeatherBean)localObject).d(), ((WeatherBean)localObject).k.g());
      localArrayList.add(localRequestBean);
      i += 1;
    }
    Object localObject = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    ((Intent)localObject).putExtra("notify_request", 22);
    ((Intent)localObject).putParcelableArrayListExtra("req_arg", localArrayList);
    return PendingIntent.getService(paramContext, 131072, (Intent)localObject, 134217728);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */