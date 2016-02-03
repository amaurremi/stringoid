package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;

@ii
public class lk {
    private final Object a = new Object();
    private final String b;
    private int c = 0;
    private long d = -1L;
    private long e = -1L;
    private int f = 0;
    private int g = -1;

    public lk(String paramString) {
        this.b = paramString;
    }

    public static boolean a(Context paramContext) {
        int i = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (i == 0) {
            mx.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
        try {
            if (i == paramContext.getPackageManager().getActivityInfo(localComponentName, 0).theme) {
                return true;
            }
            mx.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException paramContext) {
            mx.e("Fail to fetch AdActivity theme");
            mx.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
        }
        return false;
    }

    public long a() {
        return this.e;
    }

    public Bundle a(Context paramContext, String paramString) {
        synchronized (this.a) {
            Bundle localBundle = new Bundle();
            localBundle.putString("session_id", this.b);
            localBundle.putLong("basets", this.e);
            localBundle.putLong("currts", this.d);
            localBundle.putString("seq_num", paramString);
            localBundle.putInt("preqs", this.g);
            localBundle.putInt("pclick", this.c);
            localBundle.putInt("pimp", this.f);
            localBundle.putBoolean("support_transparent_background", a(paramContext));
            return localBundle;
        }
    }

    public void a(av paramav, long paramLong) {
        synchronized (this.a) {
            if (this.e == -1L) {
                this.e = paramLong;
                this.d = this.e;
                if ((paramav.c == null) || (paramav.c.getInt("gw", 2) != 1)) {
                }
            } else {
                this.d = paramLong;
            }
        }
        this.g += 1;
    }

    public void b() {
        synchronized (this.a) {
            this.c += 1;
            return;
        }
    }

    public void c() {
        synchronized (this.a) {
            this.f += 1;
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */