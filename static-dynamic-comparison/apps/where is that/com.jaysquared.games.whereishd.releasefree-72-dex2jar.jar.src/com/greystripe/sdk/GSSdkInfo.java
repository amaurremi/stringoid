package com.greystripe.sdk;

import android.content.Context;
import android.location.Location;

public class GSSdkInfo
{
  public static String getHashedDeviceId(Context paramContext)
  {
    return DeviceInfo.getDeviceInfoController(paramContext).getHashedAndroidId("SHA-1");
  }
  
  public static String getVersion()
  {
    return "2.3.0";
  }
  
  public static void updateLocation(Location paramLocation)
  {
    DeviceInfo.updateLocation(paramLocation);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/GSSdkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */