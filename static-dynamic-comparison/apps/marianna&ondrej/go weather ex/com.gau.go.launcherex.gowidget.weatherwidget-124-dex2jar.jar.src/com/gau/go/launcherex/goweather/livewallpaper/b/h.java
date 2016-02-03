package com.gau.go.launcherex.goweather.livewallpaper.b;

import android.app.KeyguardManager;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.gau.go.launcherex.gowidget.weather.view.AppInSDPromptActivity;

public abstract class h
{
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    Object localObject = WallpaperManager.getInstance(paramContext);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((WallpaperManager)localObject).getWallpaperInfo();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (paramContext.getPackageName().equals(((WallpaperInfo)localObject).getPackageName())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AppInSDPromptActivity.class);
    localIntent.putExtra("app_in_sd_prompt_tips_type", 2);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0).flags;
      if ((i & 0x40000) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean d(Context paramContext)
  {
    paramContext = (KeyguardManager)paramContext.getSystemService("keyguard");
    return (paramContext != null) && (paramContext.inKeyguardRestrictedInputMode());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */