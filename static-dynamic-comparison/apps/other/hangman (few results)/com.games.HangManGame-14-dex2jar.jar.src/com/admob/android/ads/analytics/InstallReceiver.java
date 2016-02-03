package com.admob.android.ads.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.admob.android.ads.AdManager;
import com.admob.android.ads.e;
import com.admob.android.ads.h;
import com.admob.android.ads.r;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class InstallReceiver
  extends BroadcastReceiver
{
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    if (paramString1 != null) {}
    for (;;)
    {
      String str;
      try
      {
        String[] arrayOfString = paramString1.split("&");
        paramString1 = null;
        if (i < arrayOfString.length)
        {
          Object localObject = arrayOfString[i];
          str = paramString1;
          if (!((String)localObject).startsWith("admob_")) {
            break label226;
          }
          localObject = ((String)localObject).substring("admob_".length()).split("=");
          str = URLEncoder.encode(localObject[0], "UTF-8");
          localObject = URLEncoder.encode(localObject[1], "UTF-8");
          if (paramString1 == null)
          {
            paramString1 = new StringBuilder(128);
            paramString1.append(str).append("=").append((String)localObject);
            str = paramString1;
            break label226;
          }
          paramString1.append("&");
          continue;
          return null;
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        Log.e("AdMobSDK", "Could not create install URL.  Install not tracked.", paramString1);
      }
      while (paramString1 == null) {}
      paramString2 = URLEncoder.encode(paramString2, "UTF-8");
      paramString1.append("&").append("isu").append("=").append(paramString2);
      paramString2 = URLEncoder.encode(paramString3, "UTF-8");
      paramString1.append("&").append("app_id").append("=").append(paramString2);
      paramString1 = "http://a.admob.com/f0?" + paramString1.toString();
      return paramString1;
      label226:
      i += 1;
      paramString1 = str;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getStringExtra("referrer");
      paramIntent = AdManager.getUserId(paramContext);
      paramContext = a(str, paramIntent, AdManager.getApplicationPackageName(paramContext));
      if (paramContext != null)
      {
        if (Log.isLoggable("AdMobSDK", 2)) {
          Log.v("AdMobSDK", "Processing install from an AdMob ad (" + paramContext + ").");
        }
        paramContext = e.a(paramContext, "Conversion", paramIntent);
        paramContext.a(new h()
        {
          public final void a(r paramAnonymousr)
          {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Recorded install from an AdMob ad.");
            }
          }
          
          public final void a(r paramAnonymousr, Exception paramAnonymousException)
          {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Failed to record install from an AdMob ad.", paramAnonymousException);
            }
          }
        });
        paramContext.a();
      }
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("AdMobSDK", "Unhandled exception processing Market install.", paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/analytics/InstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */