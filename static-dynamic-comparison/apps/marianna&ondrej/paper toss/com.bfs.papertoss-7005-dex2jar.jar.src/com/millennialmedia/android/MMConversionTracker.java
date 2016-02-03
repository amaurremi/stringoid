package com.millennialmedia.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.TreeMap;

public final class MMConversionTracker
  extends BroadcastReceiver
{
  private static final String ACTION_REFERRER = "com.android.vending.INSTALL_REFERRER";
  private static final String EXTRA_REFERRER = "referrer";
  private static final String KEY_REFERRER = "installReferrer";
  
  public static void trackConversion(Context paramContext, String paramString)
  {
    long l1 = 0L;
    if ((paramContext != null) && (paramString != null)) {}
    for (;;)
    {
      int i;
      final boolean bool;
      Object localObject1;
      try
      {
        i = paramString.length();
        if (i == 0) {
          return;
        }
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
        bool = localSharedPreferences.getBoolean("firstLaunch_" + paramString, true);
        localObject1 = localSharedPreferences.getString("installReferrer", null);
        if (localObject1 == null) {
          break label345;
        }
        localObject2 = new TreeMap();
        String[] arrayOfString = ((String)localObject1).split("&");
        int j = arrayOfString.length;
        i = 0;
        localObject1 = localObject2;
        if (i < j)
        {
          localObject1 = arrayOfString[i].split("=");
          if (localObject1.length < 2) {
            break label338;
          }
          ((TreeMap)localObject2).put(localObject1[0], localObject1[1]);
          break label338;
        }
        if (bool)
        {
          localObject2 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject2).putBoolean("firstLaunch_" + paramString, false);
          ((SharedPreferences.Editor)localObject2).commit();
        }
      }
      finally {}
      try
      {
        localObject2 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        continue;
      }
      try
      {
        l2 = localObject2.getClass().getField("firstInstallTime").getLong(localObject2);
        l1 = l2;
      }
      catch (Exception localException)
      {
        continue;
      }
      final long l2 = l1;
      if (l1 > 0L)
      {
        localObject2 = new GregorianCalendar();
        ((GregorianCalendar)localObject2).setTimeInMillis(l1);
        ((GregorianCalendar)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
        l2 = ((GregorianCalendar)localObject2).getTimeInMillis();
      }
      final Object localObject2 = MMAdViewSDK.getHdid(paramContext);
      if (MMAdViewSDK.isConnected(paramContext))
      {
        new Thread()
        {
          public void run()
          {
            HttpGetRequest localHttpGetRequest = new HttpGetRequest();
            try
            {
              localHttpGetRequest.trackConversion(this.val$goalId, localObject2, bool, l2, this.val$extraParams);
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }.start();
      }
      else
      {
        MMAdViewSDK.Log.w("No network available for conversion tracking.");
        continue;
        label338:
        i += 1;
        continue;
        label345:
        localObject1 = null;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!paramIntent.getAction().equals("com.android.vending.INSTALL_REFERRER")) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("referrer");
    } while ((paramIntent == null) || (paramIntent.length() == 0));
    paramIntent = URLDecoder.decode(paramIntent);
    MMAdViewSDK.Log.i("Received referrer: %s", new Object[] { paramIntent });
    paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
    paramContext.putString("installReferrer", paramIntent);
    paramContext.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMConversionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */