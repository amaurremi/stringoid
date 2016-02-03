package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

@ii
public final class fi
        implements SafeParcelable {
    public static final kd CREATOR = new kd();
    public final int a;
    public final Bundle b;
    public final av c;
    public final ay d;
    public final String e;
    public final ApplicationInfo f;
    public final PackageInfo g;
    public final String h;
    public final String i;
    public final String j;
    public final gt k;
    public final Bundle l;
    public final int m;
    public final List<String> n;
    public final Bundle o;
    public final boolean p;

    fi(int paramInt1, Bundle paramBundle1, av paramav, ay paramay, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, gt paramgt, Bundle paramBundle2, int paramInt2, List<String> paramList, Bundle paramBundle3, boolean paramBoolean) {
        this.a = paramInt1;
        this.b = paramBundle1;
        this.c = paramav;
        this.d = paramay;
        this.e = paramString1;
        this.f = paramApplicationInfo;
        this.g = paramPackageInfo;
        this.h = paramString2;
        this.i = paramString3;
        this.j = paramString4;
        this.k = paramgt;
        this.l = paramBundle2;
        this.m = paramInt2;
        this.n = paramList;
        this.o = paramBundle3;
        this.p = paramBoolean;
    }

    public fi(Bundle paramBundle1, av paramav, ay paramay, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, gt paramgt, Bundle paramBundle2, int paramInt, List<String> paramList, Bundle paramBundle3, boolean paramBoolean) {
        this(4, paramBundle1, paramav, paramay, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramgt, paramBundle2, paramInt, paramList, paramBundle3, paramBoolean);
    }

    public fi(kc paramkc, String paramString) {
        this(paramkc.a, paramkc.b, paramkc.c, paramkc.d, paramkc.e, paramkc.f, paramString, paramkc.g, paramkc.h, paramkc.j, paramkc.i, paramkc.k, paramkc.l, paramkc.m, paramkc.n);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        kd.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */