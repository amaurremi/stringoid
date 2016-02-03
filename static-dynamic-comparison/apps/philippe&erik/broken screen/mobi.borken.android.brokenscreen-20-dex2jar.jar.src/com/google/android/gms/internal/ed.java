package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

public final class ed
{
  public final int qY;
  public final boolean qZ;
  public final boolean ra;
  public final String rb;
  public final String rc;
  public final boolean rd;
  public final boolean re;
  public final boolean rf;
  public final String rg;
  public final String rh;
  public final int ri;
  public final int rj;
  public final int rk;
  public final int rl;
  public final int rm;
  public final int rn;
  public final float ro;
  public final int rp;
  public final int rq;
  public final double rr;
  public final boolean rs;
  public final boolean rt;
  public final int ru;
  
  public ed(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    Locale localLocale = Locale.getDefault();
    PackageManager localPackageManager = paramContext.getPackageManager();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    this.qY = localAudioManager.getMode();
    boolean bool1;
    if (a(localPackageManager, "geo:0,0?q=donuts") != null)
    {
      bool1 = true;
      this.qZ = bool1;
      if (a(localPackageManager, "http://www.google.com") == null) {
        break label385;
      }
      bool1 = true;
      label117:
      this.ra = bool1;
      this.rb = localTelephonyManager.getNetworkOperator();
      this.rc = localLocale.getCountry();
      this.rd = eu.bQ();
      this.re = localAudioManager.isMusicActive();
      this.rf = localAudioManager.isSpeakerphoneOn();
      this.rg = localLocale.getLanguage();
      this.rh = a(localPackageManager);
      this.ri = localAudioManager.getStreamVolume(3);
      this.rj = a(paramContext, localConnectivityManager, localPackageManager);
      this.rk = localTelephonyManager.getNetworkType();
      this.rl = localTelephonyManager.getPhoneType();
      this.rm = localAudioManager.getRingerMode();
      this.rn = localAudioManager.getStreamVolume(2);
      this.ro = localDisplayMetrics.density;
      this.rp = localDisplayMetrics.widthPixels;
      this.rq = localDisplayMetrics.heightPixels;
      if (localIntent == null) {
        break label397;
      }
      int i = localIntent.getIntExtra("status", -1);
      int j = localIntent.getIntExtra("level", -1);
      int k = localIntent.getIntExtra("scale", -1);
      this.rr = (j / k);
      bool1 = bool2;
      if (i != 2)
      {
        if (i != 5) {
          break label391;
        }
        bool1 = bool2;
      }
      label332:
      this.rs = bool1;
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.rt = localConnectivityManager.isActiveNetworkMetered();
        if (localConnectivityManager.getActiveNetworkInfo() != null)
        {
          this.ru = localConnectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
          return;
          bool1 = false;
          break;
          label385:
          bool1 = false;
          break label117;
          label391:
          bool1 = false;
          break label332;
          label397:
          this.rr = -1.0D;
          this.rs = false;
          continue;
        }
        this.ru = -1;
        return;
      }
    }
    this.rt = false;
    this.ru = -1;
  }
  
  private static int a(Context paramContext, ConnectivityManager paramConnectivityManager, PackageManager paramPackageManager)
  {
    int i = -2;
    if (ep.a(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
    {
      paramContext = paramConnectivityManager.getActiveNetworkInfo();
      if (paramContext != null) {
        i = paramContext.getType();
      }
    }
    else
    {
      return i;
    }
    return -1;
  }
  
  private static ResolveInfo a(PackageManager paramPackageManager, String paramString)
  {
    return paramPackageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 65536);
  }
  
  private static String a(PackageManager paramPackageManager)
  {
    Object localObject = a(paramPackageManager, "market://details?id=com.google.android.gms.ads");
    if (localObject == null) {}
    for (;;)
    {
      return null;
      localObject = ((ResolveInfo)localObject).activityInfo;
      if (localObject != null) {
        try
        {
          paramPackageManager = paramPackageManager.getPackageInfo(((ActivityInfo)localObject).packageName, 0);
          if (paramPackageManager != null)
          {
            paramPackageManager = paramPackageManager.versionCode + "." + ((ActivityInfo)localObject).packageName;
            return paramPackageManager;
          }
        }
        catch (PackageManager.NameNotFoundException paramPackageManager) {}
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */