package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;

public class ei
{
  private final Object ls = new Object();
  private final String rR;
  private int rX = 0;
  private long rY = -1L;
  private long rZ = -1L;
  private int sa = 0;
  private int sb = -1;
  
  public ei(String paramString)
  {
    this.rR = paramString;
  }
  
  public static boolean l(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (i == 0)
    {
      eu.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
    try
    {
      if (i == paramContext.getPackageManager().getActivityInfo(localComponentName, 0).theme) {
        return true;
      }
      eu.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      eu.D("Fail to fetch AdActivity theme");
      eu.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    }
    return false;
  }
  
  public Bundle b(Context paramContext, String paramString)
  {
    synchronized (this.ls)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", this.rR);
      localBundle.putLong("basets", this.rZ);
      localBundle.putLong("currts", this.rY);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", this.sb);
      localBundle.putInt("pclick", this.rX);
      localBundle.putInt("pimp", this.sa);
      localBundle.putBoolean("support_transparent_background", l(paramContext));
      return localBundle;
    }
  }
  
  public void b(ai paramai, long paramLong)
  {
    synchronized (this.ls)
    {
      if (this.rZ == -1L)
      {
        this.rZ = paramLong;
        this.rY = this.rZ;
        if ((paramai.extras == null) || (paramai.extras.getInt("gw", 2) != 1)) {}
      }
      else
      {
        this.rY = paramLong;
      }
    }
    this.sb += 1;
  }
  
  public void bB()
  {
    synchronized (this.ls)
    {
      this.sa += 1;
      return;
    }
  }
  
  public void bC()
  {
    synchronized (this.ls)
    {
      this.rX += 1;
      return;
    }
  }
  
  public long bO()
  {
    return this.rZ;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */