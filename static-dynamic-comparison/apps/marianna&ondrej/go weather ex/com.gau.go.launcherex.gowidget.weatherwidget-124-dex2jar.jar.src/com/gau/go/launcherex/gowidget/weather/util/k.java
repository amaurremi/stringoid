package com.gau.go.launcherex.gowidget.weather.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.download.b;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.jiubang.core.b.a;
import java.util.Iterator;
import java.util.List;

public class k
{
  public static void a(Context paramContext, int paramInt)
  {
    if (y.p(paramContext))
    {
      b(paramContext);
      return;
    }
    b(paramContext, paramInt);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramString.equals("com.gau.go.launcherex")) || (paramString.equals("com.gau.go.launcherex.zh")))
    {
      paramContext = GoWidgetApplication.c(paramContext).a();
      if (paramContext.getBoolean("key_rec_golauncher_has_recommended", false))
      {
        paramContext = paramContext.edit();
        paramContext.putBoolean("key_rec_golauncher_uninstalled", true);
        paramContext.commit();
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (c(paramContext, "com.go.launcherpad")) {}
    while ((c(paramContext, "com.gau.go.launcherex")) || (c(paramContext, "com.gau.go.launcherex.zh"))) {
      return true;
    }
    return false;
  }
  
  private static void b(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.gau.go.launcherex.zh"));
    localIntent.setPackage("com.android.vending");
    localIntent.setFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      d(paramContext, "https://play.google.com/store/apps/details?id=com.gau.go.launcherex&referrer=utm_source%3DGOWeatherEX_GOwidgetRecommend%26utm_medium%3DHyperlink%26utm_campaign%3DGOWeatherEX_GOwidgetRecommend");
    }
  }
  
  private static void b(Context paramContext, int paramInt)
  {
    Object localObject;
    if (paramInt == 1) {
      localObject = Uri.parse("market://details?id=com.gau.go.launcherex&referrer=utm_source%3DGOWeatherEX_GOwidgetRecommend%26utm_medium%3DHyperlink%26utm_campaign%3DGOWeatherEX_GOwidgetRecommend");
    }
    for (;;)
    {
      localObject = new Intent("android.intent.action.VIEW", (Uri)localObject);
      ((Intent)localObject).setPackage("com.android.vending");
      ((Intent)localObject).setFlags(268435456);
      try
      {
        paramContext.startActivity((Intent)localObject);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        d(paramContext, "https://play.google.com/store/apps/details?id=com.gau.go.launcherex&referrer=utm_source%3DGOWeatherEX_GOwidgetRecommend%26utm_medium%3DHyperlink%26utm_campaign%3DGOWeatherEX_GOwidgetRecommend");
      }
      if (paramInt == 3) {
        localObject = Uri.parse("market://details?id=com.gau.go.launcherex&referrer=utm_source%3DGOweatherGIF%26utm_medium%3Dbanner%26utm_campaign%3DGOAPP");
      } else {
        localObject = Uri.parse("market://details?id=com.gau.go.launcherex&referrer=utm_source%3DGOweatherFullScreen%26utm_medium%3Dbanner%26utm_campaign%3DGOAPP");
      }
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramString = Uri.parse(paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW", paramString);
    localIntent.setPackage("com.android.vending");
    localIntent.setFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      paramString = new Intent("android.intent.action.VIEW", paramString);
      paramString.setFlags(268435456);
      try
      {
        paramContext.startActivity(paramString);
        return;
      }
      catch (ActivityNotFoundException paramString)
      {
        Toast.makeText(paramContext, 2131165768, 0).show();
      }
    }
  }
  
  private static boolean c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    Object localObject = new Intent("android.intent.action.MAIN");
    ((Intent)localObject).addCategory("android.intent.category.HOME");
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    paramContext = paramContext.queryIntentActivities((Intent)localObject, 0).iterator();
    while (paramContext.hasNext())
    {
      localObject = (ResolveInfo)paramContext.next();
      if ((localObject != null) && (((ResolveInfo)localObject).activityInfo != null) && (((ResolveInfo)localObject).activityInfo.packageName != null) && (((ResolveInfo)localObject).activityInfo.name != null) && (((ResolveInfo)localObject).activityInfo.packageName.startsWith(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static void d(Context paramContext, String paramString)
  {
    if (paramString.length() > 2) {}
    for (String str = paramString.substring(paramString.lastIndexOf("/") + 1);; str = paramString)
    {
      b.a(paramContext.getApplicationContext(), str, paramString, 1L, paramContext.getPackageName());
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */