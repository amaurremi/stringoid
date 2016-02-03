package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.l;
import com.google.android.gms.location.LocationRequest;

import java.util.Collections;
import java.util.List;

public class n
        implements SafeParcelable {
    public static final Parcelable.Creator<n> CREATOR = new aa();
    int a;
    int b;
    private final int c;
    private final DataSource d;
    private final DataType e;
    private k f;
    private final long g;
    private final long h;
    private final PendingIntent i;
    private final long j;
    private final int k;
    private final List<LocationRequest> l;
    private final long m;
    private final List n;

    n(int paramInt1, DataSource paramDataSource, DataType paramDataType, IBinder paramIBinder, int paramInt2, int paramInt3, long paramLong1, long paramLong2, PendingIntent paramPendingIntent, long paramLong3, int paramInt4, List<LocationRequest> paramList, long paramLong4) {
        this.c = paramInt1;
        this.d = paramDataSource;
        this.e = paramDataType;
        if (paramIBinder == null) {
        }
        for (paramDataSource = null; ; paramDataSource = l.a(paramIBinder)) {
            this.f = paramDataSource;
            long l1 = paramLong1;
            if (paramLong1 == 0L) {
                l1 = paramInt2;
            }
            this.g = l1;
            this.j = paramLong3;
            paramLong1 = paramLong2;
            if (paramLong2 == 0L) {
                paramLong1 = paramInt3;
            }
            this.h = paramLong1;
            this.l = paramList;
            this.i = paramPendingIntent;
            this.k = paramInt4;
            this.n = Collections.emptyList();
            this.m = paramLong4;
            return;
        }
    }

    private boolean a(n paramn) {
        return (ad.a(this.d, paramn.d)) && (ad.a(this.e, paramn.e)) && (this.g == paramn.g) && (this.j == paramn.j) && (this.h == paramn.h) && (this.k == paramn.k) && (ad.a(this.l, paramn.l));
    }

    public DataSource a() {
        return this.d;
    }

    public DataType b() {
        return this.e;
    }

    public PendingIntent c() {
        return this.i;
    }

    public long d() {
        return this.j;
    }

    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.g;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof n)) && (a((n) paramObject)));
    }

    public long f() {
        return this.h;
    }

    public List<LocationRequest> g() {
        return this.l;
    }

    public int h() {
        return this.k;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.d, this.e, this.f, Long.valueOf(this.g), Long.valueOf(this.j), Long.valueOf(this.h), Integer.valueOf(this.k), this.l});
    }

    public long i() {
        return this.m;
    }

    int j() {
        return this.c;
    }

    IBinder k() {
        if (this.f == null) {
            return null;
        }
        return this.f.asBinder();
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.e, this.d, Long.valueOf(this.g), Long.valueOf(this.j), Long.valueOf(this.h)});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        aa.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */