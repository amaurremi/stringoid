package com.magmamobile.game.engine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class Utils
{
  public static final String getAppVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static final int getAppVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  private static final String getDIDPref(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("DIDBIS", "");
  }
  
  public static final String getDeviceID()
  {
    String str3;
    try
    {
      str3 = Settings.System.getString(Game.application.getContentResolver(), "android_id");
      String str1;
      if (str3 == null)
      {
        str3 = getDIDPref(Game.application);
        if (!str3.equals(""))
        {
          str1 = str3;
          if (str3 != null) {
            return str1;
          }
        }
        str1 = "emulator/" + UUID.randomUUID().toString();
        setDIDPref(Game.application, str1);
        return str1;
      }
      if (str3.toLowerCase().equals("9774d56d682e549c"))
      {
        str3 = getDIDPref(Game.application);
        if (!str3.equals(""))
        {
          str1 = str3;
          if (str3 != null) {
            return str1;
          }
        }
        str1 = "9774d56d682e549c/" + UUID.randomUUID().toString();
        setDIDPref(Game.application, str1);
        return str1;
      }
    }
    catch (Exception localException)
    {
      return "";
    }
    String str2;
    if (str3.toLowerCase().equals("575c2ef207c21d5b"))
    {
      str3 = getDIDPref(Game.application);
      if (!str3.equals(""))
      {
        str2 = str3;
        if (str3 != null) {}
      }
      else
      {
        str2 = "575c2ef207c21d5b/" + UUID.randomUUID().toString();
        setDIDPref(Game.application, str2);
        return str2;
      }
    }
    else if (str3.toLowerCase().equals("22a000002457bbd5"))
    {
      str3 = getDIDPref(Game.application);
      if (!str3.equals(""))
      {
        str2 = str3;
        if (str3 != null) {}
      }
      else
      {
        str2 = "22a000002457bbd5/" + UUID.randomUUID().toString();
        setDIDPref(Game.application, str2);
        return str2;
      }
    }
    else if (str3.toLowerCase().equals("200146e3ff6bd264"))
    {
      str3 = getDIDPref(Game.application);
      if (!str3.equals(""))
      {
        str2 = str3;
        if (str3 != null) {}
      }
      else
      {
        str2 = "200146e3ff6bd264/" + UUID.randomUUID().toString();
        setDIDPref(Game.application, str2);
        return str2;
      }
    }
    else
    {
      str2 = str3;
      if (str3.toLowerCase().equals("emulator"))
      {
        str3 = getDIDPref(Game.application);
        if (!str3.equals(""))
        {
          str2 = str3;
          if (str3 != null) {}
        }
        else
        {
          str2 = "Emulator/" + UUID.randomUUID().toString();
          setDIDPref(Game.application, str2);
        }
      }
    }
    return str2;
  }
  
  public static final boolean isNullOrEmpty(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {}
    while (paramArrayOfObject.length <= 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean isPackageExists(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getInstalledApplications(0).iterator();
    do
    {
      if (!paramContext.hasNext()) {
        return false;
      }
    } while (!((ApplicationInfo)paramContext.next()).packageName.equals(paramString));
    return true;
  }
  
  private static final void setDIDPref(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("DIDBIS", paramString);
    paramContext.commit();
  }
  
  public static final void shareText(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("text/*");
      localIntent.putExtra("android.intent.extra.TEXT", paramString3);
      localIntent.putExtra("android.intent.extra.SUBJECT", paramString2);
      paramContext.startActivity(Intent.createChooser(localIntent, paramString1));
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static final void showCarValet(Context paramContext)
  {
    Game.showMarket("com.magmamobile.game.CarValet");
  }
  
  public static final void showMouseTrap(Context paramContext)
  {
    Game.showMarket("com.magmamobile.game.mousetrap");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */