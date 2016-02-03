package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

public final class ci
{
  public final int hZ;
  public final boolean ia;
  public final boolean ib;
  public final String ic;
  public final String id;
  public final boolean ie;
  public final boolean jdField_if;
  public final boolean ig;
  public final String ih;
  public final String ii;
  public final int ij;
  public final int ik;
  public final int il;
  public final int im;
  public final int in;
  public final int io;
  public final float ip;
  public final int iq;
  public final int ir;
  
  public ci(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    Locale localLocale = Locale.getDefault();
    PackageManager localPackageManager = paramContext.getPackageManager();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    this.hZ = localAudioManager.getMode();
    if (a(localPackageManager, "geo:0,0?q=donuts") != null)
    {
      bool1 = true;
      this.ia = bool1;
      if (a(localPackageManager, "http://www.google.com") == null) {
        break label255;
      }
    }
    label255:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ib = bool1;
      this.ic = localTelephonyManager.getNetworkOperator();
      this.id = localLocale.getCountry();
      this.ie = cs.ax();
      this.jdField_if = localAudioManager.isMusicActive();
      this.ig = localAudioManager.isSpeakerphoneOn();
      this.ih = localLocale.getLanguage();
      this.ii = a(localPackageManager);
      this.ij = localAudioManager.getStreamVolume(3);
      this.ik = a(paramContext, localConnectivityManager, localPackageManager);
      this.il = localTelephonyManager.getNetworkType();
      this.im = localTelephonyManager.getPhoneType();
      this.in = localAudioManager.getRingerMode();
      this.io = localAudioManager.getStreamVolume(2);
      this.ip = localDisplayMetrics.density;
      this.iq = localDisplayMetrics.widthPixels;
      this.ir = localDisplayMetrics.heightPixels;
      return;
      bool1 = false;
      break;
    }
  }
  
  private static int a(Context paramContext, ConnectivityManager paramConnectivityManager, PackageManager paramPackageManager)
  {
    int i = -2;
    if (co.a(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */