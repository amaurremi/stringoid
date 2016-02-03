package com.go.weatherex.home;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.jiubang.core.b.a;

public class z
{
  private void a(Activity paramActivity)
  {
    SharedPreferences localSharedPreferences = GoWidgetApplication.c(paramActivity.getApplicationContext()).a();
    long l = localSharedPreferences.getLong("key_check_extreme_expired_time", 0L);
    l = System.currentTimeMillis() - l;
    if ((l < 0L) || (l > 14400000L))
    {
      paramActivity = f.a(paramActivity.getApplicationContext());
      paramActivity.l();
      paramActivity.k();
      paramActivity = localSharedPreferences.edit();
      paramActivity.putLong("key_check_extreme_expired_time", System.currentTimeMillis());
      paramActivity.commit();
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
    paramBundle.a(new aa(this, paramActivity, paramBundle));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */