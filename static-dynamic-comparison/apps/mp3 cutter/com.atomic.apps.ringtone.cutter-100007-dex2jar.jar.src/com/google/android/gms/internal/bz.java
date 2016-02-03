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

public final class bz
{
  public final int a;
  public final boolean b;
  public final boolean c;
  public final String d;
  public final String e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  public final String i;
  public final String j;
  public final int k;
  public final int l;
  public final int m;
  public final int n;
  public final int o;
  public final int p;
  public final float q;
  public final int r;
  public final int s;
  
  public bz(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    Locale localLocale = Locale.getDefault();
    PackageManager localPackageManager = paramContext.getPackageManager();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    this.a = localAudioManager.getMode();
    boolean bool1;
    label99:
    int i1;
    if (a(localPackageManager, "geo:0,0?q=donuts") != null)
    {
      bool1 = true;
      this.b = bool1;
      if (a(localPackageManager, "http://www.google.com") == null) {
        break label279;
      }
      bool1 = bool2;
      this.c = bool1;
      this.d = localTelephonyManager.getNetworkOperator();
      this.e = localLocale.getCountry();
      this.f = bU.a();
      this.g = localAudioManager.isMusicActive();
      this.h = localAudioManager.isSpeakerphoneOn();
      this.i = localLocale.getLanguage();
      this.j = a(localPackageManager);
      this.k = localAudioManager.getStreamVolume(3);
      if (!bN.a(localPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
        break label289;
      }
      paramContext = localConnectivityManager.getActiveNetworkInfo();
      if (paramContext == null) {
        break label284;
      }
      i1 = paramContext.getType();
    }
    for (;;)
    {
      this.l = i1;
      this.m = localTelephonyManager.getNetworkType();
      this.n = localTelephonyManager.getPhoneType();
      this.o = localAudioManager.getRingerMode();
      this.p = localAudioManager.getStreamVolume(2);
      this.q = localDisplayMetrics.density;
      this.r = localDisplayMetrics.widthPixels;
      this.s = localDisplayMetrics.heightPixels;
      return;
      bool1 = false;
      break;
      label279:
      bool1 = false;
      break label99;
      label284:
      i1 = -1;
      continue;
      label289:
      i1 = -2;
    }
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */