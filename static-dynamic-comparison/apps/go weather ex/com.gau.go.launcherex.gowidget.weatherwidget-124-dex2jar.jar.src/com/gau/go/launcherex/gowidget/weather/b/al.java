package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.jiubang.core.b.a;

class al
  extends AsyncTask
{
  private al(ai paramai) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    ai.c(this.a);
    return Boolean.valueOf(ai.d(this.a));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      paramBoolean = GoWidgetApplication.c(ai.e(this.a).getApplicationContext()).a().edit();
      paramBoolean.putLong("key_camera_plugin_syn_time", System.currentTimeMillis() + 86400000L);
      paramBoolean.putBoolean("key_camera_plugin_update_have_show", false);
      paramBoolean.commit();
    }
    ai.a(this.a, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */