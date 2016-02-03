package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Arrays;
import java.util.List;

public final class RawDataPoint
        implements SafeParcelable {
    public static final Parcelable.Creator<RawDataPoint> CREATOR = new o();
    final int a;
    final long b;
    final long c;
    final Value[] d;
    final int e;
    final int f;
    final long g;
    final long h;

    RawDataPoint(int paramInt1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, int paramInt2, int paramInt3, long paramLong3, long paramLong4) {
        this.a = paramInt1;
        this.b = paramLong1;
        this.c = paramLong2;
        this.e = paramInt2;
        this.f = paramInt3;
        this.g = paramLong3;
        this.h = paramLong4;
        this.d = paramArrayOfValue;
    }

    RawDataPoint(DataPoint paramDataPoint, List<DataSource> paramList) {
        this.a = 4;
        this.b = paramDataPoint.d();
        this.c = paramDataPoint.g();
        this.d = paramDataPoint.a();
        this.e = u.a(paramDataPoint.b(), paramList);
        this.f = u.a(paramDataPoint.c(), paramList);
        this.g = paramDataPoint.e();
        this.h = paramDataPoint.f();
    }

    private boolean a(RawDataPoint paramRawDataPoint) {
        return (this.b == paramRawDataPoint.b) && (this.c == paramRawDataPoint.c) && (Arrays.equals(this.d, paramRawDataPoint.d)) && (this.e == paramRawDataPoint.e) && (this.f == paramRawDataPoint.f) && (this.g == paramRawDataPoint.g);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof RawDataPoint)) && (a((RawDataPoint) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{Long.valueOf(this.b), Long.valueOf(this.c)});
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.d), Long.valueOf(this.c), Long.valueOf(this.b), Integer.valueOf(this.e), Integer.valueOf(this.f)});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        o.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/RawDataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */