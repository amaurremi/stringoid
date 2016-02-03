package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

@ii
public final class av
        implements SafeParcelable {
    public static final as CREATOR = new as();
    public final int a;
    public final long b;
    public final Bundle c;
    public final int d;
    public final List<String> e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final String i;
    public final bj j;
    public final Location k;
    public final String l;
    public final Bundle m;

    public av(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List<String> paramList, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, bj parambj, Location paramLocation, String paramString2, Bundle paramBundle2) {
        this.a = paramInt1;
        this.b = paramLong;
        this.c = paramBundle1;
        this.d = paramInt2;
        this.e = paramList;
        this.f = paramBoolean1;
        this.g = paramInt3;
        this.h = paramBoolean2;
        this.i = paramString1;
        this.j = parambj;
        this.k = paramLocation;
        this.l = paramString2;
        this.m = paramBundle2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        as.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */