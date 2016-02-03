package com.adfonic.android.api.request;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.adfonic.android.api.request.utils.AndroidDeviceId;
import com.adfonic.android.api.request.utils.UserAgentBuilder;
import com.adfonic.android.utils.Permission;
import java.util.Locale;
import java.util.TimeZone;

public class AndroidSystemRequestAdapter
{
  private static String NETWORK_NAME;
  private static String OPERATOR;
  private static String ROAMING;
  private static String SIM_NAME;
  private static String USER_AGENT;
  
  private Location getLocation(Context paramContext)
  {
    LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
    Location localLocation1 = null;
    Location localLocation2 = null;
    if (Permission.hasFineGrainLocationAccess(paramContext)) {
      localLocation1 = localLocationManager.getLastKnownLocation("network");
    }
    if (Permission.hasFineGrainLocationAccess(paramContext)) {
      localLocation2 = localLocationManager.getLastKnownLocation("gps");
    }
    if ((localLocation1 == null) && (localLocation2 != null)) {}
    do
    {
      return localLocation2;
      if ((localLocation2 == null) && (localLocation1 != null)) {
        return localLocation1;
      }
      if (localLocation2 == null) {
        break;
      }
    } while (localLocation2.getTime() > localLocation1.getTime());
    return localLocation1;
    return null;
  }
  
  public void prepareStandardRequest(AndroidRequest paramAndroidRequest, Context paramContext)
  {
    setUserAgent(paramAndroidRequest, paramContext);
    setHardwareVersion(paramAndroidRequest);
    setAdfonicVersion(paramAndroidRequest);
    setAndroidDeviceId(paramAndroidRequest, paramContext);
    setConnectionType(paramAndroidRequest, paramContext);
    setOperatorInfo(paramAndroidRequest, paramContext);
    setLocation(paramAndroidRequest, paramContext);
    setLocale(paramAndroidRequest);
    setLanguage(paramAndroidRequest);
    setTimeZone(paramAndroidRequest);
    setScreenSize(paramAndroidRequest, paramContext);
  }
  
  protected void setAdfonicVersion(AndroidRequest paramAndroidRequest)
  {
    paramAndroidRequest.setAdfonicSdkVersion("Adfonic/Android/1.1.5");
  }
  
  protected void setAndroidDeviceId(AndroidRequest paramAndroidRequest, Context paramContext)
  {
    paramAndroidRequest.setAndroidDeviceId(AndroidDeviceId.getDpId(paramContext));
  }
  
  protected void setConnectionType(AndroidRequest paramAndroidRequest, Context paramContext)
  {
    try
    {
      if (!Permission.hasNetworkStateAccess(paramContext)) {
        return;
      }
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null) {
          switch (paramContext.getType())
          {
          case 0: 
            paramAndroidRequest.setNetworkType("mobile");
          case 1: 
            paramAndroidRequest.setNetworkType("wifi");
            return;
          }
        }
      }
    }
    catch (Exception paramAndroidRequest) {}
    return;
  }
  
  protected void setHardwareVersion(AndroidRequest paramAndroidRequest)
  {
    paramAndroidRequest.setHardwareVersion("Android/" + Build.VERSION.RELEASE + "/" + Build.MODEL);
    paramAndroidRequest.setOsName(Build.VERSION.SDK);
    paramAndroidRequest.setOsVersion(Build.VERSION.RELEASE);
    paramAndroidRequest.setAndroidSdkVersion(Build.VERSION.SDK_INT);
    paramAndroidRequest.setDeviceName(Build.DEVICE);
  }
  
  public void setLanguage(AndroidRequest paramAndroidRequest)
  {
    try
    {
      if (paramAndroidRequest.getLanguage() != null) {
        return;
      }
      paramAndroidRequest.setLanguage(Locale.getDefault().toString());
      return;
    }
    catch (Exception paramAndroidRequest) {}
  }
  
  public void setLocale(AndroidRequest paramAndroidRequest)
  {
    try
    {
      paramAndroidRequest.setLocale(Locale.getDefault().toString());
      return;
    }
    catch (Exception paramAndroidRequest) {}
  }
  
  protected void setLocation(AndroidRequest paramAndroidRequest, Context paramContext)
  {
    try
    {
      if (paramAndroidRequest.getLocation() != null)
      {
        paramAndroidRequest.setLongitude("" + paramAndroidRequest.getLocation().getLongitude());
        paramAndroidRequest.setLatitude("" + paramAndroidRequest.getLocation().getLatitude());
        return;
      }
      if (paramAndroidRequest.isAllowLocation())
      {
        paramContext = getLocation(paramContext);
        paramAndroidRequest.setLocation(paramContext);
        paramAndroidRequest.setLongitude("" + paramContext.getLongitude());
        paramAndroidRequest.setLatitude("" + paramContext.getLatitude());
        return;
      }
    }
    catch (Exception paramAndroidRequest) {}
  }
  
  public void setOperatorInfo(AndroidRequest paramAndroidRequest, Context paramContext)
  {
    try
    {
      if (OPERATOR == null)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext == null) {
          return;
        }
        OPERATOR = paramContext.getNetworkOperator();
        NETWORK_NAME = paramContext.getNetworkOperatorName();
        SIM_NAME = paramContext.getSimOperatorName();
        if (paramContext.isNetworkRoaming()) {
          ROAMING = "1";
        }
      }
      paramAndroidRequest.setOperator(OPERATOR);
      paramAndroidRequest.setNetworkName(NETWORK_NAME);
      paramAndroidRequest.setSimName(SIM_NAME);
      paramAndroidRequest.setRoaming(ROAMING);
      return;
    }
    catch (Exception paramAndroidRequest) {}
  }
  
  public void setScreenSize(AndroidRequest paramAndroidRequest, Context paramContext)
  {
    try
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      paramContext.getMetrics(new DisplayMetrics());
      int i = paramContext.getWidth();
      int j = paramContext.getHeight();
      if ((i > 0) && (j > 0)) {
        paramAndroidRequest.setScreenSize(i + "x" + j);
      }
      return;
    }
    catch (Exception paramAndroidRequest) {}
  }
  
  public void setTimeZone(AndroidRequest paramAndroidRequest)
  {
    try
    {
      paramAndroidRequest.setTimeZone(TimeZone.getDefault().getID());
      return;
    }
    catch (Exception paramAndroidRequest) {}
  }
  
  protected void setUserAgent(AndroidRequest paramAndroidRequest, Context paramContext)
  {
    if (USER_AGENT == null) {
      USER_AGENT = UserAgentBuilder.getUserAgentString(paramContext);
    }
    paramAndroidRequest.setUserAgent(USER_AGENT);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/request/AndroidSystemRequestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */