package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Arrays;
import java.util.List;

public final class DataPoint
        implements SafeParcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new e();
    private final int a;
    private final DataSource b;
    private long c;
    private long d;
    private final Value[] e;
    private DataSource f;
    private long g;
    private long h;

    DataPoint(int paramInt, DataSource paramDataSource1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, DataSource paramDataSource2, long paramLong3, long paramLong4) {
        this.a = paramInt;
        this.b = paramDataSource1;
        this.f = paramDataSource2;
        this.c = paramLong1;
        this.d = paramLong2;
        this.e = paramArrayOfValue;
        this.g = paramLong3;
        this.h = paramLong4;
    }

    DataPoint(List<DataSource> paramList, RawDataPoint paramRawDataPoint) {
        this(4, a(paramList, paramRawDataPoint.e), paramRawDataPoint.b, paramRawDataPoint.c, paramRawDataPoint.d, a(paramList, paramRawDataPoint.f), paramRawDataPoint.g, paramRawDataPoint.h);
    }

    private static DataSource a(List<DataSource> paramList, int paramInt) {
        if ((paramInt >= 0) && (paramInt < paramList.size())) {
            return (DataSource) paramList.get(paramInt);
        }
        return null;
    }

    private boolean a(DataPoint paramDataPoint) {
        return (ad.a(this.b, paramDataPoint.b)) && (this.c == paramDataPoint.c) && (this.d == paramDataPoint.d) && (Arrays.equals(this.e, paramDataPoint.e)) && (ad.a(this.f, paramDataPoint.f));
    }

    public Value[] a() {
        return this.e;
    }

    public DataSource b() {
        return this.b;
    }

    public DataSource c() {
        return this.f;
    }

    public long d() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.g;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof DataPoint)) && (a((DataPoint) paramObject)));
    }

    public long f() {
        return this.h;
    }

    public long g() {
        return this.d;
    }

    public int h() {
        return this.a;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, Long.valueOf(this.c), Long.valueOf(this.d)});
    }

    public String toString() {
        return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", new Object[]{Arrays.toString(this.e), Long.valueOf(this.d), Long.valueOf(this.c), Long.valueOf(this.g), Long.valueOf(this.h), this.b, this.f});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/DataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */