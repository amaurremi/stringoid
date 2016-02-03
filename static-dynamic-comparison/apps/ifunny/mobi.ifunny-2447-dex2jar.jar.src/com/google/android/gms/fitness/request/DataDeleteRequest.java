package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;

import java.util.Collections;
import java.util.List;

public class DataDeleteRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new j();
    private final int a;
    private final long b;
    private final long c;
    private final List<DataSource> d;
    private final List<DataType> e;
    private final List<Session> f;
    private final boolean g;
    private final boolean h;

    DataDeleteRequest(int paramInt, long paramLong1, long paramLong2, List<DataSource> paramList, List<DataType> paramList1, List<Session> paramList2, boolean paramBoolean1, boolean paramBoolean2) {
        this.a = paramInt;
        this.b = paramLong1;
        this.c = paramLong2;
        this.d = Collections.unmodifiableList(paramList);
        this.e = Collections.unmodifiableList(paramList1);
        this.f = paramList2;
        this.g = paramBoolean1;
        this.h = paramBoolean2;
    }

    private boolean a(DataDeleteRequest paramDataDeleteRequest) {
        return (this.b == paramDataDeleteRequest.b) && (this.c == paramDataDeleteRequest.c) && (ad.a(this.d, paramDataDeleteRequest.d)) && (ad.a(this.e, paramDataDeleteRequest.e)) && (ad.a(this.f, paramDataDeleteRequest.f)) && (this.g == paramDataDeleteRequest.g) && (this.h == paramDataDeleteRequest.h);
    }

    public long a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public List<DataSource> c() {
        return this.d;
    }

    public List<DataType> d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public List<Session> e() {
        return this.f;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof DataDeleteRequest)) && (a((DataDeleteRequest) paramObject)));
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.h;
    }

    int h() {
        return this.a;
    }

    public int hashCode() {
        return ad.a(new Object[]{Long.valueOf(this.b), Long.valueOf(this.c)});
    }

    public String toString() {
        return ad.a(this).a("startTimeMillis", Long.valueOf(this.b)).a("endTimeMillis", Long.valueOf(this.c)).a("dataSources", this.d).a("dateTypes", this.e).a("sessions", this.f).a("deleteAllData", Boolean.valueOf(this.g)).a("deleteAllSessions", Boolean.valueOf(this.h)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        j.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/DataDeleteRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */