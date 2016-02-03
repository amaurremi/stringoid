package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.statistics.z;
import com.jiubang.core.b.a;

class az
  extends AsyncTask
{
  String a = "";
  int b = 1;
  
  private az(ax paramax) {}
  
  protected String a(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = ax.a(this.c).getPackageManager().getPackageInfo(ax.a(this.c).getPackageName(), 0);
      this.a = paramVarArgs.versionName;
      if (this.a == null) {
        this.a = "";
      }
      this.b = paramVarArgs.versionCode;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
    return this.c.a(3, this.a, this.b, 1);
  }
  
  protected void a(String paramString)
  {
    super.onPostExecute(paramString);
    if (paramString != null)
    {
      paramString = z.a(paramString);
      if ((paramString.a == 2) || ((paramString.a == 3) && (paramString.g != y.e(ax.a(this.c)))))
      {
        SharedPreferences.Editor localEditor = GoWidgetApplication.c(ax.a(this.c).getApplicationContext()).a().edit();
        localEditor.putString("version_update", paramString.b);
        localEditor.putString("latest_version", paramString.e);
        localEditor.putString("update_url", paramString.c);
        localEditor.putInt("latest_version_num", paramString.g);
        localEditor.commit();
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */