package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hs
        implements SafeParcelable {
    public static final oi CREATOR = new oi();
    final int a;
    final hg b;
    final long c;
    final int d;
    public final String e;
    final he f;

    hs(int paramInt1, hg paramhg, long paramLong, int paramInt2, String paramString, he paramhe) {
        this.a = paramInt1;
        this.b = paramhg;
        this.c = paramLong;
        this.d = paramInt2;
        this.e = paramString;
        this.f = paramhe;
    }

    public int describeContents() {
        oi localoi = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[]{this.b, Long.valueOf(this.c), Integer.valueOf(this.d)});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        oi localoi = CREATOR;
        oi.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */