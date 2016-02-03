package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bucket
        implements SafeParcelable {
    public static final Parcelable.Creator<Bucket> CREATOR = new d();
    private final int a;
    private final long b;
    private final long c;
    private final Session d;
    private final int e;
    private final List<DataSet> f;
    private final int g;
    private boolean h = false;

    Bucket(int paramInt1, long paramLong1, long paramLong2, Session paramSession, int paramInt2, List<DataSet> paramList, int paramInt3, boolean paramBoolean) {
        this.a = paramInt1;
        this.b = paramLong1;
        this.c = paramLong2;
        this.d = paramSession;
        this.e = paramInt2;
        this.f = paramList;
        this.g = paramInt3;
        this.h = paramBoolean;
    }

    public Bucket(RawBucket paramRawBucket, List<DataSource> paramList, List<DataType> paramList1) {
        this(2, paramRawBucket.b, paramRawBucket.c, paramRawBucket.d, paramRawBucket.e, a(paramRawBucket.f, paramList, paramList1), paramRawBucket.g, paramRawBucket.h);
    }

    public static String a(int paramInt) {
        switch (paramInt) {
            default:
                return "bug";
            case 1:
                return "time";
            case 3:
                return "type";
            case 4:
                return "segment";
            case 2:
                return "session";
        }
        return "unknown";
    }

    private static List<DataSet> a(List<RawDataSet> paramList, List<DataSource> paramList1, List<DataType> paramList2) {
        ArrayList localArrayList = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            localArrayList.add(new DataSet((RawDataSet) paramList.next(), paramList1, paramList2));
        }
        return localArrayList;
    }

    private boolean a(Bucket paramBucket) {
        return (this.b == paramBucket.b) && (this.c == paramBucket.c) && (this.e == paramBucket.e) && (ad.a(this.f, paramBucket.f)) && (this.g == paramBucket.g) && (this.h == paramBucket.h);
    }

    public long a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public Session c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataSet> e() {
        return this.f;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof Bucket)) && (a((Bucket) paramObject)));
    }

    public int f() {
        return this.g;
    }

    public boolean g() {
        if (this.h) {
            return true;
        }
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
            if (((DataSet) localIterator.next()).c()) {
                return true;
            }
        }
        return false;
    }

    int h() {
        return this.a;
    }

    public int hashCode() {
        return ad.a(new Object[]{Long.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.e), Integer.valueOf(this.g)});
    }

    public String toString() {
        return ad.a(this).a("startTime", Long.valueOf(this.b)).a("endTime", Long.valueOf(this.c)).a("activity", Integer.valueOf(this.e)).a("dataSets", this.f).a("bucketType", a(this.g)).a("serverHasMoreData", Boolean.valueOf(this.h)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        d.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */