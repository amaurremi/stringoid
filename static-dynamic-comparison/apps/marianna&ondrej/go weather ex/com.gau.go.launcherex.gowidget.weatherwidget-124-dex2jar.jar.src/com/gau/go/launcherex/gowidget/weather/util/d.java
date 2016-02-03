package com.gau.go.launcherex.gowidget.weather.util;

import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

public class d
{
  public static ArrayList a = new ArrayList();
  
  static
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setDataAndType(Uri.parse("content://com.android.calendar"), "time/epoch");
    localIntent.addFlags(268435456);
    a.add(localIntent);
    localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setClassName("com.android.calendar", "com.android.calendar.LaunchActivity");
    localIntent.addFlags(268435456);
    a.add(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */