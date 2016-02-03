package com.appfireworks.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Calendar;
import java.util.Enumeration;
import org.json.JSONObject;

public class AppDeviceParamaters
{
  private static final String SDK_LEVEL = "02";
  private static final String SDK_VERSION = "2";
  
  public static JSONObject appDeviceParamaters(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    j = 0;
    k = 0;
    int i = j;
    for (;;)
    {
      try
      {
        localObject1 = paramContext.getResources().getDisplayMetrics();
        i = j;
        j = ((DisplayMetrics)localObject1).widthPixels;
        i = j;
        int m = ((DisplayMetrics)localObject1).heightPixels;
        i = j;
        j = m;
      }
      catch (Exception localException11)
      {
        Object localObject1;
        Object localObject3;
        double d;
        String str4;
        j = k;
        continue;
        String str3 = "wifi";
        continue;
        continue;
        str3 = "sim_carrier_locked";
        continue;
        str3 = "sim_user_locked";
        continue;
        str3 = "sim_puk_locked";
        continue;
        str3 = "sim_ok";
        continue;
      }
      try
      {
        localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        localObject3 = Calendar.getInstance();
        localJSONObject.put("ref1", localObject1);
        localJSONObject.put("ref2", Build.VERSION.RELEASE);
        localJSONObject.put("ref3", "Android");
        localJSONObject.put("ref4", getLocalIpAddress());
        localJSONObject.put("ref5", ((Calendar)localObject3).get(15));
        localJSONObject.put("ref6", (int)(((Calendar)localObject3).getTimeInMillis() / 1000L));
        localJSONObject.put("ref7", i);
        localJSONObject.put("ref8", j);
        if ((paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
        {
          i = 0;
          if (i == 0) {}
        }
      }
      catch (Exception localException9)
      {
        try
        {
          localObject1 = ((LocationManager)paramContext.getSystemService("location")).getLastKnownLocation("gps");
          d = ((Location)localObject1).getLongitude();
          localJSONObject.put("ref9", String.valueOf(((Location)localObject1).getLatitude()));
          localJSONObject.put("ref10", String.valueOf(d));
        }
        catch (Exception localException9)
        {
          try
          {
            AppLog.d("AppFireworks", "Generating Ref11-14");
            localJSONObject.put("ref11", localTelephonyManager.getNetworkCountryIso());
            localJSONObject.put("ref12", localTelephonyManager.getNetworkOperator());
            localJSONObject.put("ref13", localTelephonyManager.getNetworkOperatorName());
          }
          catch (Exception localException9)
          {
            try
            {
              localJSONObject.put("ref15", "2");
              localJSONObject.put("ref16", "02");
              if (paramContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0)
              {
                i = 1;
                if (i == 0) {}
              }
            }
            catch (Exception localException9)
            {
              try
              {
                if (localTelephonyManager.getDeviceId() != null)
                {
                  localObject1 = localTelephonyManager.getDeviceId();
                  localJSONObject.put("ref17", localObject1);
                }
              }
              catch (Exception localException9)
              {
                try
                {
                  localJSONObject.put("ref18", Build.MANUFACTURER);
                  localJSONObject.put("ref19", Build.MODEL);
                  if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
                  {
                    i = 1;
                    if (i == 0) {}
                  }
                }
                catch (Exception localException9)
                {
                  try
                  {
                    localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
                    localObject3 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
                    localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
                    if (localObject3 != null)
                    {
                      localObject3 = ((NetworkInfo)localObject3).getState();
                      if (localObject1 == null) {
                        continue;
                      }
                      localObject1 = ((NetworkInfo)localObject1).getState();
                      str4 = "";
                      if (localObject1 == NetworkInfo.State.CONNECTED) {
                        continue;
                      }
                      if (localObject1 != NetworkInfo.State.CONNECTING) {
                        continue;
                      }
                      continue;
                      localJSONObject.put("ref20", localObject1);
                    }
                  }
                  catch (Exception localException9)
                  {
                    try
                    {
                      i = localTelephonyManager.getSimState();
                      localObject1 = "";
                      switch (i)
                      {
                      case 1: 
                        localJSONObject.put("ref21", localObject1);
                        if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {}
                        break;
                      }
                    }
                    catch (Exception localException9)
                    {
                      try
                      {
                        localJSONObject.put("ref22", ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress());
                      }
                      catch (Exception localException9)
                      {
                        try
                        {
                          localJSONObject.put("ref23", paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
                          localJSONObject.put("ref25", paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode);
                          try
                          {
                            localJSONObject.put("ref24", paramContext.getSharedPreferences("APPFIREWORKS", 0).getString("installreferrer", ""));
                            AppLog.d("AppFireworks", "D = " + localJSONObject.toString());
                            return localJSONObject;
                            localException1 = localException1;
                            AppLog.e("AppFireworks", "Error generating Ref1-8 - " + localException1.getMessage());
                            AppLog.printStackTrace("AppFireworks", localException1);
                            continue;
                            i = 1;
                            continue;
                            localException2 = localException2;
                            AppLog.e("AppFireworks", "Error generating Ref9-10 - " + localException2.getMessage());
                            AppLog.printStackTrace("AppFireworks", localException2);
                            continue;
                            localException3 = localException3;
                            AppLog.e("AppFireworks", "Error generating Ref11-14 - " + localException3.getMessage());
                            AppLog.printStackTrace("AppFireworks", localException3);
                            continue;
                            localException4 = localException4;
                            AppLog.e("AppFireworks", "Error generating Ref15-16 - " + localException4.getMessage());
                            continue;
                            i = 0;
                            continue;
                            String str1 = "0";
                            continue;
                            localException5 = localException5;
                            AppLog.e("AppFireworks", "Error generating Ref17 - " + localException5.getMessage());
                            continue;
                            localException6 = localException6;
                            AppLog.e("AppFireworks", "Error generating Ref18-19 - " + localException6.getMessage());
                            continue;
                            i = 0;
                            continue;
                            localObject3 = null;
                            continue;
                            Object localObject2 = null;
                            continue;
                            if (localObject3 != NetworkInfo.State.CONNECTED)
                            {
                              localObject2 = str4;
                              if (localObject3 != NetworkInfo.State.CONNECTING) {
                                continue;
                              }
                            }
                            localObject2 = "carrier";
                            continue;
                            localException7 = localException7;
                            AppLog.e("AppFireworks", "Error generating Ref20 - " + localException7.getMessage());
                            continue;
                            String str2 = "no_sim";
                            continue;
                            str2 = "sim_unknown";
                            continue;
                            localException8 = localException8;
                            AppLog.e("AppFireworks", "Error generating Ref21 - " + localException8.getMessage());
                            continue;
                            localException9 = localException9;
                            AppLog.e("AppFireworks", "Error generating Ref22 - " + localException9.getMessage());
                          }
                          catch (Exception paramContext) {}
                        }
                        catch (Exception localException10) {}
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static String getLocalIpAddress()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress().toString();
      return (String)localObject;
    }
    catch (SocketException localSocketException)
    {
      AppLog.printStackTrace("AppFireworks", localSocketException);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/util/AppDeviceParamaters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */