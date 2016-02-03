package com.go.weatherex.home;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.jiubang.core.b.a;

public class x
{
  private void a(Activity paramActivity)
  {
    SharedPreferences localSharedPreferences = GoWidgetApplication.c(paramActivity).a();
    long l = localSharedPreferences.getLong("update_version_dialog_time", 0L);
    if (System.currentTimeMillis() - l >= 259200000L)
    {
      String str1 = localSharedPreferences.getString("latest_version", "");
      String str2 = localSharedPreferences.getString("version_update", "");
      String str3 = localSharedPreferences.getString("update_url", "");
      int i = localSharedPreferences.getInt("latest_version_num", 0);
      String str4 = com.gau.go.launcherex.gowidget.statistics.y.c(paramActivity.getApplicationContext());
      int j = com.gau.go.launcherex.gowidget.statistics.y.e(paramActivity.getApplicationContext());
      if ((!str1.equals("")) && (i != 0) && (!str3.equals("")))
      {
        if (((str4.equals(str1)) || (j == i)) && ((!str4.equals(str1)) || (j == i))) {
          break label209;
        }
        a(paramActivity, str2, str3);
        localSharedPreferences.edit().putLong("update_version_dialog_time", System.currentTimeMillis()).commit();
        localSharedPreferences.edit().putBoolean("key_has_new_version", true).commit();
      }
    }
    return;
    label209:
    localSharedPreferences.edit().putBoolean("key_has_new_version", false).commit();
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    try
    {
      paramString.setPackage("com.android.vending");
      paramString.addFlags(268435456);
      paramActivity.getApplicationContext().startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      Toast.makeText(paramActivity, 2131165767, 0).show();
    }
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2)
  {
    com.gau.go.launcherex.gowidget.weather.globalview.b localb = new com.gau.go.launcherex.gowidget.weather.globalview.b(paramActivity);
    localb.b(2131165363);
    localb.b(paramString1);
    localb.d(2131165364);
    localb.a(new y(this, paramActivity, paramString2));
    localb.b();
  }
  
  private void b(Activity paramActivity, String paramString)
  {
    String str;
    if (paramString.length() > 2)
    {
      str = paramString.substring(paramString.lastIndexOf("/") + 1);
      if (!paramString.contains("||")) {
        break label66;
      }
      paramString = paramString.substring(paramString.lastIndexOf("||") + 2);
    }
    label66:
    for (;;)
    {
      com.gau.go.launcherex.gowidget.download.b.a(paramActivity.getApplicationContext(), str, paramString, 1L, paramActivity.getApplicationContext().getPackageName());
      return;
      str = paramString;
      break;
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */