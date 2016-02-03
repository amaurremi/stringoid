package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Arrays;

public class h
        implements SafeParcelable {
    public static final m CREATOR = new m();
    private final int a;
    private final String b;
    private final String[] c;
    private final String[] d;
    private final String[] e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final PlusCommonExtras j;

    h(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramArrayOfString1;
        this.d = paramArrayOfString2;
        this.e = paramArrayOfString3;
        this.f = paramString2;
        this.g = paramString3;
        this.h = paramString4;
        this.i = paramString5;
        this.j = paramPlusCommonExtras;
    }

    public h(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, PlusCommonExtras paramPlusCommonExtras) {
        this.a = 1;
        this.b = paramString1;
        this.c = paramArrayOfString1;
        this.d = paramArrayOfString2;
        this.e = paramArrayOfString3;
        this.f = paramString2;
        this.g = paramString3;
        this.h = paramString4;
        this.i = null;
        this.j = paramPlusCommonExtras;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String[] c() {
        return this.c;
    }

    public String[] d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public String[] e() {
        return this.e;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof h)) {
        }
        do {
            return false;
            paramObject = (h) paramObject;
        }
        while ((this.a != ((h) paramObject).a) || (!ad.a(this.b, ((h) paramObject).b)) || (!Arrays.equals(this.c, ((h) paramObject).c)) || (!Arrays.equals(this.d, ((h) paramObject).d)) || (!Arrays.equals(this.e, ((h) paramObject).e)) || (!ad.a(this.f, ((h) paramObject).f)) || (!ad.a(this.g, ((h) paramObject).g)) || (!ad.a(this.h, ((h) paramObject).h)) || (!ad.a(this.i, ((h) paramObject).i)) || (!ad.a(this.j, ((h) paramObject).j)));
        return true;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.a), this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j});
    }

    public String i() {
        return this.i;
    }

    public PlusCommonExtras j() {
        return this.j;
    }

    public Bundle k() {
        Bundle localBundle = new Bundle();
        localBundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.j.a(localBundle);
        return localBundle;
    }

    public String toString() {
        return ad.a(this).a("versionCode", Integer.valueOf(this.a)).a("accountName", this.b).a("requestedScopes", this.c).a("visibleActivities", this.d).a("requiredFeatures", this.e).a("packageNameForAuth", this.f).a("callingPackageName", this.g).a("applicationName", this.h).a("extra", this.j.toString()).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        m.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */