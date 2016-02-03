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

public final class bh
{
  public final int EA;
  public final int EB;
  public final int ED;
  public final int EE;
  public final float EF;
  public final int EG;
  public final int EH;
  public final int Ep;
  public final boolean Eq;
  public final boolean Er;
  public final String Es;
  public final boolean Et;
  public final boolean Eu;
  public final boolean Ev;
  public final String Ew;
  public final String Ex;
  public final int Ey;
  public final int Ez;
  public final String wK;
  
  public bh(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    Locale localLocale = Locale.getDefault();
    PackageManager localPackageManager = paramContext.getPackageManager();
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    this.Ep = localAudioManager.getMode();
    if (a(localPackageManager, "geo:0,0?q=donuts") != null)
    {
      bool1 = true;
      this.Eq = bool1;
      if (a(localPackageManager, "http://www.google.com") == null) {
        break label255;
      }
    }
    label255:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Er = bool1;
      this.Es = localTelephonyManager.getNetworkOperator();
      this.wK = localLocale.getCountry();
      this.Et = cb.pQ();
      this.Eu = localAudioManager.isMusicActive();
      this.Ev = localAudioManager.isSpeakerphoneOn();
      this.Ew = localLocale.getLanguage();
      this.Ex = a(localPackageManager);
      this.Ey = localAudioManager.getStreamVolume(3);
      this.Ez = a(paramContext, localConnectivityManager, localPackageManager);
      this.EA = localTelephonyManager.getNetworkType();
      this.EB = localTelephonyManager.getPhoneType();
      this.ED = localAudioManager.getRingerMode();
      this.EE = localAudioManager.getStreamVolume(2);
      this.EF = localDisplayMetrics.density;
      this.EG = localDisplayMetrics.widthPixels;
      this.EH = localDisplayMetrics.heightPixels;
      return;
      bool1 = false;
      break;
    }
  }
  
  private static int a(Context paramContext, ConnectivityManager paramConnectivityManager, PackageManager paramPackageManager)
  {
    int i = -2;
    if (bw.a(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE"))
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */