package com.backflipstudios.android.engine.platform;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.backflipstudios.android.debug.BFSDebug;
import java.lang.reflect.Method;

public class BFSDeviceInfo
{
  private static final String NETWORK_TYPE_NONE = "none";
  private static final String NETWORK_TYPE_WWAN = "wwan";
  
  public static String getDeviceModel()
  {
    return Build.MODEL;
  }
  
  public static String getDeviceName()
  {
    return Build.DEVICE;
  }
  
  public static String getDeviceUniqueIdentifier(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String getNetworkTypeAsString(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(0);
        if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting())) {
          return "wwan";
        }
        paramContext = paramContext.getNetworkInfo(1);
        if ((paramContext != null) && (paramContext.isConnectedOrConnecting())) {
          return "wwan";
        }
      }
    }
    catch (Exception paramContext)
    {
      BFSDebug.e("BFSDeviceInfo.getNetworkTypeAsString", paramContext);
    }
    return "none";
  }
  
  public static String getSystemVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static boolean isConnectedToNetwork(Context paramContext)
  {
    return !"none".equals(getNetworkTypeAsString(paramContext));
  }
  
  public static boolean isTabletDevice(Context paramContext)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 11) {
      paramContext = paramContext.getResources().getConfiguration();
    }
    try
    {
      bool = ((Boolean)paramContext.getClass().getMethod("isLayoutSizeAtLeast", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(4) })).booleanValue();
      return bool;
    }
    catch (Exception paramContext)
    {
      BFSDebug.e("BFSDeviceInfo.isTabletDevice()");
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/backflipstudios/android/engine/platform/BFSDeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */