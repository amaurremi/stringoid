package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;

public class ej
{
  private final Object lq = new Object();
  private final String rO;
  private int rU = 0;
  private long rV = -1L;
  private long rW = -1L;
  private int rX = 0;
  private int rY = -1;
  
  public ej(String paramString)
  {
    this.rO = paramString;
  }
  
  public static boolean i(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (i == 0)
    {
      ev.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
    try
    {
      if (i == paramContext.getPackageManager().getActivityInfo(localComponentName, 0).theme) {
        return true;
      }
      ev.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ev.D("Fail to fetch AdActivity theme");
      ev.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    }
    return false;
  }
  
  public Bundle b(Context paramContext, String paramString)
  {
    synchronized (this.lq)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", this.rO);
      localBundle.putLong("basets", this.rW);
      localBundle.putLong("currts", this.rV);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", this.rY);
      localBundle.putInt("pclick", this.rU);
      localBundle.putInt("pimp", this.rX);
      localBundle.putBoolean("support_transparent_background", i(paramContext));
      return localBundle;
    }
  }
  
  public void b(aj paramaj, long paramLong)
  {
    synchronized (this.lq)
    {
      if (this.rW == -1L)
      {
        this.rW = paramLong;
        this.rV = this.rW;
        if ((paramaj.extras == null) || (paramaj.extras.getInt("gw", 2) != 1)) {}
      }
      else
      {
        this.rV = paramLong;
      }
    }
    this.rY += 1;
  }
  
  public long bJ()
  {
    return this.rW;
  }
  
  public void bw()
  {
    synchronized (this.lq)
    {
      this.rX += 1;
      return;
    }
  }
  
  public void bx()
  {
    synchronized (this.lq)
    {
      this.rU += 1;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */