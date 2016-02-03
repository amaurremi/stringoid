package com.go.weatherex.home;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.globalview.b;
import com.gau.go.launcherex.gowidget.weather.globalview.g;

public class s
{
  private Activity a;
  private c b;
  private SharedPreferences c;
  
  private void a()
  {
    new Handler().postDelayed(new u(this), 1000L);
  }
  
  private void a(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramString));
    try
    {
      paramString.setPackage("com.android.vending");
      this.a.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      Toast.makeText(this.a, 2131165767, 0).show();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    b localb;
    if (!this.a.isFinishing())
    {
      localObject = this.c.edit();
      ((SharedPreferences.Editor)localObject).putBoolean("key_tip_default_appwidget_change", true);
      ((SharedPreferences.Editor)localObject).commit();
      localb = new b(this.a);
      localb.b(2131166487);
      localb.d(2131165382);
      if (!paramBoolean) {
        break label98;
      }
      localb.c(2131165996);
      localb.e(2131165547);
    }
    for (Object localObject = "market://details?id=com.gau.go.weatherex.systemwidgetskin.whiteskin";; localObject = "market://details?id=com.gau.go.weatherex.systemwidgetskin.moonlightskin")
    {
      localb.a(new v(this, (String)localObject));
      localb.b();
      return;
      label98:
      localb.c(2131165997);
      localb.e(2131165546);
    }
  }
  
  private boolean b()
  {
    int i = this.c.getInt("key_last_versioncode", -1);
    boolean bool = this.c.getBoolean("key_tip_default_appwidget_change", false);
    if ((i == -1) || (i > 53) || (bool)) {
      return false;
    }
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a))
    {
      String str = com.gau.go.launcherex.gowidget.weather.util.r.d(this.a);
      if ("app_widget_theme_white".equals(str))
      {
        a(true);
        return true;
      }
      if ("com.gau.go.weatherex.systemwidgetskin.moonlightskin".equals(str))
      {
        i = com.gau.go.launcherex.gowidget.weather.util.r.b(this.a, "com.gau.go.weatherex.systemwidgetskin.moonlightskin");
        if ((i != -1) && (i <= 5))
        {
          a(false);
          return true;
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  private boolean c()
  {
    if (!this.c.getBoolean("key_open_dialog_boolean", true)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.c.getLong("key_first_install_time", 0L);
        if ((l1 < l2) || (l2 == 0L)) {
          break;
        }
        Object localObject = this.c.edit();
        ((SharedPreferences.Editor)localObject).putBoolean("key_open_dialog_boolean", true);
        ((SharedPreferences.Editor)localObject).commit();
        if (!this.a.isFinishing())
        {
          localObject = new g(this.a);
          ((g)localObject).a(2131166487);
          ((g)localObject).b(2131165962);
          ((g)localObject).d(2131165963);
          ((g)localObject).c(2131165964);
          ((g)localObject).a(new w(this));
          ((g)localObject).a();
          com.gau.go.launcherex.gowidget.statistics.r.a(this.a.getApplicationContext()).a(new com.gau.go.launcherex.gowidget.statistics.a.a(109, "f000"));
        }
      }
      return bool;
    }
    return false;
  }
  
  public void a(Activity paramActivity)
  {
    this.a = null;
    this.c = null;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    this.a = paramActivity;
    this.c = GoWidgetApplication.c(this.a.getApplicationContext()).a();
    this.b = c.a(paramActivity.getApplicationContext());
    if (this.b.b())
    {
      a();
      return;
    }
    this.b.a(new t(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */