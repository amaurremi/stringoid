package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationRequest
        implements SafeParcelable {
    public static final f CREATOR = new f();
    int a;
    long b;
    long c;
    boolean d;
    long e;
    int f;
    float g;
    long h;
    private final int i;

    public LocationRequest() {
        this.i = 1;
        this.a = 102;
        this.b = 3600000L;
        this.c = 600000L;
        this.d = false;
        this.e = Long.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0.0F;
        this.h = 0L;
    }

    LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat, long paramLong4) {
        this.i = paramInt1;
        this.a = paramInt2;
        this.b = paramLong1;
        this.c = paramLong2;
        this.d = paramBoolean;
        this.e = paramLong3;
        this.f = paramInt3;
        this.g = paramFloat;
        this.h = paramLong4;
    }

    public static String a(int paramInt) {
        switch (paramInt) {
            case 101:
            case 103:
            default:
                return "???";
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
        }
        return "PRIORITY_NO_POWER";
    }

    int a() {
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof LocationRequest)) {
                return false;
            }
            paramObject = (LocationRequest) paramObject;
        }
        while ((this.a == ((LocationRequest) paramObject).a) && (this.b == ((LocationRequest) paramObject).b) && (this.c == ((LocationRequest) paramObject).c) && (this.d == ((LocationRequest) paramObject).d) && (this.e == ((LocationRequest) paramObject).e) && (this.f == ((LocationRequest) paramObject).f) && (this.g == ((LocationRequest) paramObject).g));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Boolean.valueOf(this.d), Long.valueOf(this.e), Integer.valueOf(this.f), Float.valueOf(this.g)});
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Request[").append(a(this.a));
        if (this.a != 105) {
            localStringBuilder.append(" requested=");
            localStringBuilder.append(this.b + "ms");
        }
        localStringBuilder.append(" fastest=");
        localStringBuilder.append(this.c + "ms");
        if (this.e != Long.MAX_VALUE) {
            long l1 = this.e;
            long l2 = SystemClock.elapsedRealtime();
            localStringBuilder.append(" expireIn=");
            localStringBuilder.append(l1 - l2 + "ms");
        }
        if (this.f != Integer.MAX_VALUE) {
            localStringBuilder.append(" num=").append(this.f);
        }
        localStringBuilder.append(']');
        return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        f.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/location/LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */