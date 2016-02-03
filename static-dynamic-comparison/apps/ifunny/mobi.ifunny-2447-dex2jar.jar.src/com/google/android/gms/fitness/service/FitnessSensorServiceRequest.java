package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.l;

public class FitnessSensorServiceRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new a();
    private final int a;
    private final DataSource b;
    private final k c;
    private final long d;
    private final long e;

    FitnessSensorServiceRequest(int paramInt, DataSource paramDataSource, IBinder paramIBinder, long paramLong1, long paramLong2) {
        this.a = paramInt;
        this.b = paramDataSource;
        this.c = l.a(paramIBinder);
        this.d = paramLong1;
        this.e = paramLong2;
    }

    private boolean a(FitnessSensorServiceRequest paramFitnessSensorServiceRequest) {
        return (ad.a(this.b, paramFitnessSensorServiceRequest.b)) && (this.d == paramFitnessSensorServiceRequest.d) && (this.e == paramFitnessSensorServiceRequest.e);
    }

    public DataSource a() {
        return this.b;
    }

    public long b() {
        return this.d;
    }

    public long c() {
        return this.e;
    }

    int d() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    IBinder e() {
        return this.c.asBinder();
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof FitnessSensorServiceRequest)) && (a((FitnessSensorServiceRequest) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, Long.valueOf(this.d), Long.valueOf(this.e)});
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[]{this.b});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/service/FitnessSensorServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */