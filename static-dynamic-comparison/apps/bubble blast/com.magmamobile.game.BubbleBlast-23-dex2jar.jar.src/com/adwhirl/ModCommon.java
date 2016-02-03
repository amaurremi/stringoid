package com.adwhirl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.System;
import android.util.Log;
import com.adwhirl.obj.Extra2;
import java.util.Locale;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class ModCommon
{
  public static String defaultjson = "";
  
  public static String alphaNum(String paramString1, String paramString2)
  {
    return paramString1.replaceAll("[^a-zA-Z0-9]", paramString2);
  }
  
  public static void callTracking(String paramString)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          BasicHttpParams localBasicHttpParams = new BasicHttpParams();
          HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 3000);
          HttpConnectionParams.setSoTimeout(localBasicHttpParams, 5000);
          new DefaultHttpClient(localBasicHttpParams).execute(new HttpGet(ModCommon.this));
          if (Extra2.verboselog) {
            Log.i("Tracking Kreactive OK", ModCommon.this);
          }
          return;
        }
        catch (Exception localException)
        {
          while (!Extra2.verboselog) {}
          Log.d("Error tracking Kreactive", ModCommon.this);
        }
      }
    }).start();
  }
  
  public static int getConnectionType(Context paramContext)
  {
    if (paramContext.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == -1) {}
    int i;
    int j;
    do
    {
      return 3;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      i = paramContext.getType();
      j = paramContext.getSubtype();
      if (i == 1) {
        return 1;
      }
    } while ((i != 0) || (j != 3));
    return 2;
  }
  
  public static String getDeviceID(Context paramContext)
  {
    String str = Settings.System.getString(paramContext.getContentResolver(), "android_id");
    paramContext = str;
    if (str == null) {
      paramContext = "emulator";
    }
    return paramContext;
  }
  
  public static String getLocale(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.toString();
  }
  
  public static String getModelNumber()
  {
    return alphaNum(Build.MODEL, "_");
  }
  
  public static String getSDK()
  {
    return Build.VERSION.SDK;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/ModCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */