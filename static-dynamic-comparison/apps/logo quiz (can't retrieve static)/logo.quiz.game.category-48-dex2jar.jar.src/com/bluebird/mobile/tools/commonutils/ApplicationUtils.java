package com.bluebird.mobile.tools.commonutils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.util.Base64;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ApplicationUtils
{
  public static String getCurrentApplicationName(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getApplicationContext().getPackageManager();
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        paramContext = localPackageManager.getApplicationLabel(paramContext);
        return (String)paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
        continue;
        paramContext = "(unknown)";
      }
    }
  }
  
  public static String getPlatform(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("platform", "string", paramContext.getPackageName());
    if (i == 0) {
      return "ANDROID";
    }
    return paramContext.getResources().getString(i);
  }
  
  public static boolean isInstalled(String paramString, Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static void logAppSignatures(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 64).signatures;
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        str = paramContext[i];
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA");
        localMessageDigest.update(str.toByteArray());
        Log.e("KeyHash:", Base64.encodeToString(localMessageDigest.digest(), 0));
        i += 1;
      }
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.e("ApplicationUtils", paramContext.getMessage(), paramContext);
      return;
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      Log.e("ApplicationUtils", paramContext.getMessage(), paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/commonutils/ApplicationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */