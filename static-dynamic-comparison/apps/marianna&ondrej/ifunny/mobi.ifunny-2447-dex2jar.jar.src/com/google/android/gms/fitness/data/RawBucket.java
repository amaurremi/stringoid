package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RawBucket
        implements SafeParcelable {
    public static final Parcelable.Creator<RawBucket> CREATOR = new n();
    final int a;
    final long b;
    final long c;
    final Session d;
    final int e;
    final List<RawDataSet> f;
    final int g;
    final boolean h;

    RawBucket(int paramInt1, long paramLong1, long paramLong2, Session paramSession, int paramInt2, List<RawDataSet> paramList, int paramInt3, boolean paramBoolean) {
        this.a = paramInt1;
        this.b = paramLong1;
        this.c = paramLong2;
        this.d = paramSession;
        this.e = paramInt2;
        this.f = paramList;
        this.g = paramInt3;
        this.h = paramBoolean;
    }

    public RawBucket(Bucket paramBucket, List<DataSource> paramList, List<DataType> paramList1) {
        this.a = 2;
        this.b = paramBucket.a();
        this.c = paramBucket.b();
        this.d = paramBucket.c();
        this.e = paramBucket.d();
        this.g = paramBucket.f();
        this.h = paramBucket.g();
        paramBucket = paramBucket.e();
        this.f = new ArrayList(paramBucket.size());
        paramBucket = paramBucket.iterator();
        while (paramBucket.hasNext()) {
            DataSet localDataSet = (DataSet) paramBucket.next();
            this.f.add(new RawDataSet(localDataSet, paramList, paramList1));
        }
    }

    private boolean a(RawBucket paramRawBucket) {
        return (this.b == paramRawBucket.b) && (this.c == paramRawBucket.c) && (this.e == paramRawBucket.e) && (ad.a(this.f, paramRawBucket.f)) && (this.g == paramRawBucket.g) && (this.h == paramRawBucket.h);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof RawBucket)) && (a((RawBucket) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{Long.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.g)});
    }

    public String toString() {
        return ad.a(this).a("startTime", Long.valueOf(this.b)).a("endTime", Long.valueOf(this.c)).a("activity", Integer.valueOf(this.e)).a("dataSets", this.f).a("bucketType", Integer.valueOf(this.g)).a("serverHasMoreData", Boolean.valueOf(this.h)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        n.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/RawBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */