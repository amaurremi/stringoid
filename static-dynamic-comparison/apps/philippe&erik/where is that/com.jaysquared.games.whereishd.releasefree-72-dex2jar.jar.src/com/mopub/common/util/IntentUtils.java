package com.mopub.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import java.util.List;

public class IntentUtils
{
  private static final String HTTP = "http";
  private static final String HTTPS = "https";
  private static final String MARKET = "market";
  private static final String MARKET_ANDROID_COM = "market.android.com";
  private static final String PLAY_GOOGLE_COM = "play.google.com";
  private static final String TWITTER_APPLICATION_DEEPLINK_URL = "twitter://timeline";
  
  public static boolean canHandleApplicationUrl(Context paramContext, String paramString)
  {
    return canHandleApplicationUrl(paramContext, paramString, true);
  }
  
  public static boolean canHandleApplicationUrl(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (!deviceCanHandleIntent(paramContext, new Intent("android.intent.action.VIEW", Uri.parse(paramString))))
    {
      if (paramBoolean) {
        Log.w("MoPub", "Could not handle application specific action: " + paramString + ". " + "You may be running in the emulator or another device which does not " + "have the required application.");
      }
      return false;
    }
    return true;
  }
  
  public static boolean canHandleTwitterUrl(Context paramContext)
  {
    return canHandleApplicationUrl(paramContext, "twitter://timeline", false);
  }
  
  public static boolean deviceCanHandleIntent(Context paramContext, Intent paramIntent)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty();
      if (!bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (NullPointerException paramContext) {}
    return false;
  }
  
  private static boolean isAppStoreUrl(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      Object localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getScheme();
      localObject = ((Uri)localObject).getHost();
      if (("play.google.com".equals(localObject)) || ("market.android.com".equals(localObject))) {
        return true;
      }
    } while (!"market".equals(paramString));
    return true;
  }
  
  public static boolean isDeepLink(String paramString)
  {
    return (isAppStoreUrl(paramString)) || (!isHttpUrl(paramString));
  }
  
  public static boolean isHttpUrl(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = Uri.parse(paramString).getScheme();
    } while ((!"http".equals(paramString)) && (!"https".equals(paramString)));
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/util/IntentUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */