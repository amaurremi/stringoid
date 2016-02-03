package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

import java.util.Collections;
import java.util.List;

public class SessionReadRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<SessionReadRequest> CREATOR = new af();
    private final int a;
    private final String b;
    private final String c;
    private final long d;
    private final long e;
    private final List<DataType> f;
    private final List<DataSource> g;
    private boolean h;
    private final boolean i;
    private final List<String> j;

    SessionReadRequest(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, List<DataType> paramList, List<DataSource> paramList1, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList2) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramLong1;
        this.e = paramLong2;
        this.f = Collections.unmodifiableList(paramList);
        this.g = Collections.unmodifiableList(paramList1);
        this.h = paramBoolean1;
        this.i = paramBoolean2;
        this.j = paramList2;
    }

    private boolean a(SessionReadRequest paramSessionReadRequest) {
        return (ad.a(this.b, paramSessionReadRequest.b)) && (this.c.equals(paramSessionReadRequest.c)) && (this.d == paramSessionReadRequest.d) && (this.e == paramSessionReadRequest.e) && (ad.a(this.f, paramSessionReadRequest.f)) && (ad.a(this.g, paramSessionReadRequest.g)) && (this.h == paramSessionReadRequest.h) && (this.j.equals(paramSessionReadRequest.j)) && (this.i == paramSessionReadRequest.i);
    }

    public String a() {
        return this.b;
    }

    public String b() {
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
        return (this == paramObject) || (((paramObject instanceof SessionReadRequest)) && (a((SessionReadRequest) paramObject)));
    }

    public List<DataSource> f() {
        return this.g;
    }

    public boolean g() {
        return this.h;
    }

    public List<String> h() {
        return this.j;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.c, Long.valueOf(this.d), Long.valueOf(this.e)});
    }

    public boolean i() {
        return this.i;
    }

    int j() {
        return this.a;
    }

    public String toString() {
        return ad.a(this).a("sessionName", this.b).a("sessionId", this.c).a("startTimeMillis", Long.valueOf(this.d)).a("endTimeMillis", Long.valueOf(this.e)).a("dataTypes", this.f).a("dataSources", this.g).a("sessionsFromAllApps", Boolean.valueOf(this.h)).a("excludedPackages", this.j).a("useServer", Boolean.valueOf(this.i)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        af.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/SessionReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */