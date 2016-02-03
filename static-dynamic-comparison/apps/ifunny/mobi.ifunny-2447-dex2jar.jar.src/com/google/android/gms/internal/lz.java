package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;

import java.util.Collections;
import java.util.List;

public class lz
        implements SafeParcelable {
    public static final qz CREATOR = new qz();
    static final List<lr> a = ;
    LocationRequest b;
    boolean c;
    boolean d;
    boolean e;
    List<lr> f;
    final String g;
    private final int h;

    lz(int paramInt, LocationRequest paramLocationRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<lr> paramList, String paramString) {
        this.h = paramInt;
        this.b = paramLocationRequest;
        this.c = paramBoolean1;
        this.d = paramBoolean2;
        this.e = paramBoolean3;
        this.f = paramList;
        this.g = paramString;
    }

    int a() {
        return this.h;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof lz)) {
        }
        do {
            return false;
            paramObject = (lz) paramObject;
        }
        while ((!ad.a(this.b, ((lz) paramObject).b)) || (this.c != ((lz) paramObject).c) || (this.d != ((lz) paramObject).d) || (this.e != ((lz) paramObject).e) || (!ad.a(this.f, ((lz) paramObject).f)));
        return true;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b.toString());
        localStringBuilder.append(" requestNlpDebugInfo=");
        localStringBuilder.append(this.c);
        localStringBuilder.append(" restorePendingIntentListeners=");
        localStringBuilder.append(this.d);
        localStringBuilder.append(" triggerUpdate=");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" clients=");
        localStringBuilder.append(this.f);
        if (this.g != null) {
            localStringBuilder.append(" tag=");
            localStringBuilder.append(this.g);
        }
        return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        qz.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */