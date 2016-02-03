package com.google.android.apps.analytics;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class DeviceOptOutImpl
  implements OptOut
{
  static final String OPTOUT_ID = "com.google.analytics.optout";
  static final int OPTOUT_TIME_CHECK_IN_SECONDS = 300;
  private final long checkIntervalInMillis;
  private long lastTimeChecked;
  private final String optOutApp;
  private boolean optedOut;
  private final PackageManager pm;
  
  DeviceOptOutImpl(PackageManager paramPackageManager)
  {
    this.pm = paramPackageManager;
    this.optedOut = false;
    this.optOutApp = "com.google.analytics.optout";
    this.checkIntervalInMillis = 300000L;
  }
  
  public boolean optedOut()
  {
    long l = System.currentTimeMillis();
    if (l > this.lastTimeChecked + this.checkIntervalInMillis) {}
    try
    {
      this.pm.getPackageInfo(this.optOutApp, 0);
      this.optedOut = true;
      this.lastTimeChecked = l;
      return this.optedOut;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        this.optedOut = false;
      }
    }
  }
  
  void resetLastTimeChecked()
  {
    this.lastTimeChecked = 0L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/android/apps/analytics/DeviceOptOutImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */