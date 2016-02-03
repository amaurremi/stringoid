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

public final class dg {
    public final int pZ;
    public final boolean qa;
    public final boolean qb;
    public final String qc;
    public final String qd;
    public final boolean qe;
    public final boolean qf;
    public final boolean qg;
    public final String qh;
    public final String qi;
    public final int qj;
    public final int qk;
    public final int ql;
    public final int qm;
    public final int qn;
    public final int qo;
    public final float qp;
    public final int qq;
    public final int qr;

    public dg(Context paramContext) {
        AudioManager localAudioManager = (AudioManager) paramContext.getSystemService("audio");
        ConnectivityManager localConnectivityManager = (ConnectivityManager) paramContext.getSystemService("connectivity");
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        Locale localLocale = Locale.getDefault();
        PackageManager localPackageManager = paramContext.getPackageManager();
        TelephonyManager localTelephonyManager = (TelephonyManager) paramContext.getSystemService("phone");
        this.pZ = localAudioManager.getMode();
        if (a(localPackageManager, "geo:0,0?q=donuts") != null) {
            bool1 = true;
            this.qa = bool1;
            if (a(localPackageManager, "http://www.google.com") == null) {
                break label255;
            }
        }
        label255:
        for (boolean bool1 = bool2; ; bool1 = false) {
            this.qb = bool1;
            this.qc = localTelephonyManager.getNetworkOperator();
            this.qd = localLocale.getCountry();
            this.qe = dv.bC();
            this.qf = localAudioManager.isMusicActive();
            this.qg = localAudioManager.isSpeakerphoneOn();
            this.qh = localLocale.getLanguage();
            this.qi = a(localPackageManager);
            this.qj = localAudioManager.getStreamVolume(3);
            this.qk = a(paramContext, localConnectivityManager, localPackageManager);
            this.ql = localTelephonyManager.getNetworkType();
            this.qm = localTelephonyManager.getPhoneType();
            this.qn = localAudioManager.getRingerMode();
            this.qo = localAudioManager.getStreamVolume(2);
            this.qp = localDisplayMetrics.density;
            this.qq = localDisplayMetrics.widthPixels;
            this.qr = localDisplayMetrics.heightPixels;
            return;
            bool1 = false;
            break;
        }
    }

    private static int a(Context paramContext, ConnectivityManager paramConnectivityManager, PackageManager paramPackageManager) {
        int i = -2;
        if (dq.a(paramPackageManager, paramContext.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            paramContext = paramConnectivityManager.getActiveNetworkInfo();
            if (paramContext != null) {
                i = paramContext.getType();
            }
        } else {
            return i;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */