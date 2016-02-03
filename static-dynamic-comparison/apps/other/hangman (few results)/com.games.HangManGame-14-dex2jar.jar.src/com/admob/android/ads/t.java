package com.admob.android.ads;

import android.content.Context;
import android.util.Log;
import org.json.JSONObject;
import org.json.JSONTokener;

final class t
{
  private static boolean a = false;
  
  public static void a(Context paramContext)
  {
    if (!a)
    {
      a = true;
      if (AdManager.getUserId(paramContext) != null) {
        break label138;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      try
      {
        String str = u.a(paramContext, null, null, 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("http://api.admob.com/v1/pubcode/android_sdk_emulator_notice");
        localStringBuilder.append("?");
        localStringBuilder.append(str);
        paramContext = e.a(localStringBuilder.toString(), "developer_message", AdManager.getUserId(paramContext));
        if (paramContext.a())
        {
          paramContext = paramContext.d();
          if (paramContext != null)
          {
            paramContext = new JSONObject(new JSONTokener(new String(paramContext))).getString("data");
            if ((paramContext != null) && (!paramContext.equals(""))) {
              Log.w("AdMobSDK", paramContext);
            }
          }
        }
        return;
      }
      catch (Exception paramContext)
      {
        label138:
        while (!Log.isLoggable("AdMobSDK", 2)) {}
        Log.v("AdMobSDK", "Unhandled exception retrieving developer message.", paramContext);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */