package com.gtp.nextlauncher.a.a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.widget.Toast;
import java.util.List;

public class a
{
  public static String a(Context paramContext)
  {
    if (b(paramContext, "com.gtp.nextlauncher")) {
      return "com.gtp.nextlauncher";
    }
    if (b(paramContext, "com.gtp.nextlauncher.trial")) {
      return "com.gtp.nextlauncher.trial";
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 200: 
      if (c(paramContext, "com.android.vending"))
      {
        if (paramInt2 == 1)
        {
          a(paramContext, paramString2, "com.android.vending");
          return;
        }
        a(paramContext, paramString1, "com.android.vending");
        return;
      }
      Toast.makeText(paramContext, paramString3, 0).show();
      return;
    }
    if (a(paramContext, "com.amazon.venezia"))
    {
      if (paramInt2 == 1)
      {
        a(paramContext, "http://www.amazon.com/gp/mas/dl/android?p=com.gtp.nextlauncher.trial", "com.amazon.venezia");
        return;
      }
      a(paramContext, "http://www.amazon.com/gp/mas/dl/android?p=com.gtp.nextlauncher", "com.amazon.venezia");
      return;
    }
    Toast.makeText(paramContext, paramString4, 0).show();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString1.setPackage(paramString2);
      paramString1.setFlags(268435456);
      paramContext.startActivity(paramString1);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext.createPackageContext(paramString, 2);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null)) {
      try
      {
        paramContext.getPackageManager().getPackageInfo(paramString, 1);
        return true;
      }
      catch (Exception paramContext)
      {
        return false;
      }
    }
    return false;
  }
  
  private static boolean c(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=" + paramContext.getPackageName()));
    localIntent.setPackage(paramString);
    localIntent.addCategory("android.intent.category.DEFAULT");
    paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
    return (paramContext != null) && (paramContext.size() != 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */