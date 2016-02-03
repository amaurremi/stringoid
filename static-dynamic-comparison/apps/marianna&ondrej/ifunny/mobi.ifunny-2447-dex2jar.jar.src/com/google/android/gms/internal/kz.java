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

@ii
public final class kz {
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
    public final double t;
    public final boolean u;
    public final boolean v;
    public final int w;

    public kz(Context paramContext) {
        AudioManager localAudioManager = (AudioManager) paramContext.getSystemService("audio");
        ConnectivityManager localConnectivityManager = (ConnectivityManager) paramContext.getSystemService("connectivity");
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        Locale localLocale = Locale.getDefault();
        PackageManager localPackageManager = paramContext.getPackageManager();
        TelephonyManager localTelephonyManager = (TelephonyManager) paramContext.getSystemService("phone");
        Intent localIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.a = localAudioManager.getMode();
        boolean bool1;
        if (a(localPackageManager, "geo:0,0?q=donuts") != null) {
            bool1 = true;
            this.b = bool1;
            if (a(localPackageManager, "http://www.google.com") == null) {
                break label385;
            }
            bool1 = true;
            label117:
            this.c = bool1;
            this.d = localTelephonyManager.getNetworkOperator();
            this.e = localLocale.getCountry();
            this.f = mv.a();
            this.g = localAudioManager.isMusicActive();
            this.h = localAudioManager.isSpeakerphoneOn();
            this.i = localLocale.getLanguage();
            this.j = a(localPackageManager);
            this.k = localAudioManager.getStreamVolume(3);
            this.l = a(paramContext, localConnectivityManager, localPackageManager);
            this.m = localTelephonyManager.getNetworkType();
            this.n = localTelephonyManager.getPhoneType();
            this.o = localAudioManager.getRingerMode();
            this.p = localAudioManager.getStreamVolume(2);
            this.q = localDisplayMetrics.density;
            this.r = localDisplayMetrics.widthPixels;
            this.s = localDisplayMetrics.heightPixels;
            if (localIntent == null) {
                break label397;
            }
            int i1 = localIntent.getIntExtra("status", -1);
            int i2 = localIntent.getIntExtra("level", -1);
            int i3 = localIntent.getIntExtra("scale", -1);
            this.t = (i2 / i3);
            bool1 = bool2;
            if (i1 != 2) {
                if (i1 != 5) {
                    break label391;
                }
                bool1 = bool2;
            }
            label332:
            this.u = bool1;
        }
        for (; ; ) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.v = localConnectivityManager.isActiveNetworkMetered();
                if (localConnectivityManager.getActiveNetworkInfo() != null) {
                    this.w = localConnectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
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
                    this.t = -1.0D;
                    this.u = false;
                    continue;
                }
                this.w = -1;
                return;
            }
        }
        this.v = false;
        this.w = -1;
    }

    private static int a(Context paramContext, ConnectivityManager paramConnectivityManager, PackageManager paramPackageManager) {
        int i1 = -2;
        if (lw.a(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            paramContext = paramConnectivityManager.getActiveNetworkInfo();
            if (paramContext != null) {
                i1 = paramContext.getType();
            }
        } else {
            return i1;
        }
        return -1;
    }

    private static ResolveInfo a(PackageManager paramPackageManager, String paramString) {
        return paramPackageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 65536);
    }

    private static String a(PackageManager paramPackageManager) {
        Object localObject = a(paramPackageManager, "market://details?id=com.google.android.gms.ads");
        if (localObject == null) {
        }
        for (; ; ) {
            return null;
            localObject = ((ResolveInfo) localObject).activityInfo;
            if (localObject != null) {
                try {
                    paramPackageManager = paramPackageManager.getPackageInfo(((ActivityInfo) localObject).packageName, 0);
                    if (paramPackageManager != null) {
                        paramPackageManager = paramPackageManager.versionCode + "." + ((ActivityInfo) localObject).packageName;
                        return paramPackageManager;
                    }
                } catch (PackageManager.NameNotFoundException paramPackageManager) {
                }
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */