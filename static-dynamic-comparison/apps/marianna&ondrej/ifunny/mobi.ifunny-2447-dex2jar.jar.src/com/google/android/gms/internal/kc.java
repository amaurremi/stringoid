package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

import java.util.List;

@ii
public final class kc {
    public final Bundle a;
    public final av b;
    public final ay c;
    public final String d;
    public final ApplicationInfo e;
    public final PackageInfo f;
    public final String g;
    public final String h;
    public final Bundle i;
    public final gt j;
    public final int k;
    public final List<String> l;
    public final Bundle m;
    public final boolean n;

    public kc(Bundle paramBundle1, av paramav, ay paramay, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, gt paramgt, Bundle paramBundle2, List<String> paramList, Bundle paramBundle3, boolean paramBoolean) {
        this.a = paramBundle1;
        this.b = paramav;
        this.c = paramay;
        this.d = paramString1;
        this.e = paramApplicationInfo;
        this.f = paramPackageInfo;
        this.g = paramString2;
        this.h = paramString3;
        this.j = paramgt;
        this.i = paramBundle2;
        this.n = paramBoolean;
        if ((paramList != null) && (paramList.size() > 0)) {
            this.k = 2;
        }
        for (this.l = paramList; ; this.l = null) {
            this.m = paramBundle3;
            return;
            this.k = 0;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */