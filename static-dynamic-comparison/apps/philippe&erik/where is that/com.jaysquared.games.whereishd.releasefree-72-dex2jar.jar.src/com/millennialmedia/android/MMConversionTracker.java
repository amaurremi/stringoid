package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.TreeMap;

final class MMConversionTracker
{
  private static final String KEY_REFERRER = "installReferrer";
  
  protected static void trackConversion(Context paramContext, String paramString, MMRequest paramMMRequest)
  {
    long l1 = 0L;
    if ((paramContext != null) && (paramString != null)) {}
    for (;;)
    {
      int i;
      final boolean bool;
      TreeMap localTreeMap;
      try
      {
        i = paramString.length();
        if (i == 0) {
          return;
        }
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
        bool = localSharedPreferences.getBoolean("firstLaunch_" + paramString, true);
        Object localObject = localSharedPreferences.getString("installReferrer", null);
        localTreeMap = new TreeMap();
        if (paramMMRequest != null)
        {
          paramMMRequest.getUrlParams(localTreeMap);
          MMRequest.insertLocation(localTreeMap);
        }
        if (localObject != null)
        {
          paramMMRequest = ((String)localObject).split("&");
          int j = paramMMRequest.length;
          i = 0;
          if (i < j)
          {
            localObject = paramMMRequest[i].split("=");
            if (localObject.length < 2) {
              break label374;
            }
            localTreeMap.put(localObject[0], localObject[1]);
            break label374;
          }
        }
        if (bool)
        {
          paramMMRequest = localSharedPreferences.edit();
          paramMMRequest.putBoolean("firstLaunch_" + paramString, false);
          paramMMRequest.commit();
        }
      }
      finally {}
      try
      {
        paramMMRequest = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      }
      catch (PackageManager.NameNotFoundException paramMMRequest)
      {
        continue;
      }
      try
      {
        l2 = paramMMRequest.getClass().getField("firstInstallTime").getLong(paramMMRequest);
        l1 = l2;
      }
      catch (Exception paramMMRequest)
      {
        continue;
      }
      final long l2 = l1;
      if (l1 > 0L)
      {
        paramMMRequest = new GregorianCalendar();
        paramMMRequest.setTimeInMillis(l1);
        paramMMRequest.setTimeZone(TimeZone.getTimeZone("GMT"));
        l2 = paramMMRequest.getTimeInMillis();
      }
      if (MMSDK.isConnected(paramContext))
      {
        localTreeMap.put("ua", "Android:" + Build.MODEL);
        localTreeMap.put("apid", HandShake.apid);
        MMSDK.insertUrlCommonValues(paramContext, localTreeMap);
        Utils.ThreadUtils.execute(new Runnable()
        {
          public void run()
          {
            HttpGetRequest localHttpGetRequest = new HttpGetRequest();
            try
            {
              localHttpGetRequest.trackConversion(this.val$goalId, bool, l2, this.val$extraParams);
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        });
      }
      else
      {
        MMSDK.Log.w("No network available for conversion tracking.");
        continue;
        label374:
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/MMConversionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */