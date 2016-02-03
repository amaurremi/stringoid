package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataReadRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<DataReadRequest> CREATOR = new m();
    private final int a;
    private final List<DataType> b;
    private final List<DataSource> c;
    private final long d;
    private final long e;
    private final List<DataType> f;
    private final List<DataSource> g;
    private final int h;
    private final long i;
    private final DataSource j;
    private final int k;
    private final boolean l;
    private final boolean m;
    private final boolean n;

    DataReadRequest(int paramInt1, List<DataType> paramList1, List<DataSource> paramList2, long paramLong1, long paramLong2, List<DataType> paramList3, List<DataSource> paramList4, int paramInt2, long paramLong3, DataSource paramDataSource, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        this.a = paramInt1;
        this.b = Collections.unmodifiableList(paramList1);
        this.c = Collections.unmodifiableList(paramList2);
        this.d = paramLong1;
        this.e = paramLong2;
        this.f = Collections.unmodifiableList(paramList3);
        this.g = Collections.unmodifiableList(paramList4);
        this.h = paramInt2;
        this.i = paramLong3;
        this.j = paramDataSource;
        this.k = paramInt3;
        this.l = paramBoolean1;
        this.m = paramBoolean2;
        this.n = paramBoolean3;
    }

    private boolean a(DataReadRequest paramDataReadRequest) {
        return (this.b.equals(paramDataReadRequest.b)) && (this.c.equals(paramDataReadRequest.c)) && (this.d == paramDataReadRequest.d) && (this.e == paramDataReadRequest.e) && (this.h == paramDataReadRequest.h) && (this.g.equals(paramDataReadRequest.g)) && (this.f.equals(paramDataReadRequest.f)) && (ad.a(this.j, paramDataReadRequest.j)) && (this.i == paramDataReadRequest.i) && (this.n == paramDataReadRequest.n);
    }

    public List<DataType> a() {
        return this.b;
    }

    public List<DataSource> b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    public long d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> e() {
        return this.f;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof DataReadRequest)) && (a((DataReadRequest) paramObject)));
    }

    public List<DataSource> f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public long h() {
        return this.i;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.h), Long.valueOf(this.d), Long.valueOf(this.e)});
    }

    public DataSource i() {
        return this.j;
    }

    public int j() {
        return this.k;
    }

    public boolean k() {
        return this.l;
    }

    public boolean l() {
        return this.n;
    }

    public boolean m() {
        return this.m;
    }

    int n() {
        return this.a;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ReadDataRequest{");
        Iterator localIterator;
        if (!this.b.isEmpty()) {
            localIterator = this.b.iterator();
            while (localIterator.hasNext()) {
                localStringBuilder.append(((DataType) localIterator.next()).c()).append(" ");
            }
        }
        if (!this.c.isEmpty()) {
            localIterator = this.c.iterator();
            while (localIterator.hasNext()) {
                localStringBuilder.append(((DataSource) localIterator.next()).i()).append(" ");
            }
        }
        if (this.h != 0) {
            localStringBuilder.append("bucket by ").append(Bucket.a(this.h));
            if (this.i > 0L) {
                localStringBuilder.append(" >").append(this.i).append("ms");
            }
            localStringBuilder.append(": ");
        }
        if (!this.f.isEmpty()) {
            localIterator = this.f.iterator();
            while (localIterator.hasNext()) {
                localStringBuilder.append(((DataType) localIterator.next()).c()).append(" ");
            }
        }
        if (!this.g.isEmpty()) {
            localIterator = this.g.iterator();
            while (localIterator.hasNext()) {
                localStringBuilder.append(((DataSource) localIterator.next()).i()).append(" ");
            }
        }
        localStringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.d), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.e)}));
        if (this.j != null) {
            localStringBuilder.append("activities: ").append(this.j.i());
        }
        if (this.n) {
            localStringBuilder.append(" +server");
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        m.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/DataReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */