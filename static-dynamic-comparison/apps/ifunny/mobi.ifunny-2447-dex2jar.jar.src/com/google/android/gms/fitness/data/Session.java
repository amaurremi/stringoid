package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Session
        implements SafeParcelable {
    public static final Parcelable.Creator<Session> CREATOR = new r();
    private final int a;
    private final long b;
    private final long c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;
    private final a h;

    Session(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt2, a parama) {
        this.a = paramInt1;
        this.b = paramLong1;
        this.c = paramLong2;
        this.d = paramString1;
        this.e = paramString2;
        this.f = paramString3;
        this.g = paramInt2;
        this.h = parama;
    }

    private boolean a(Session paramSession) {
        return (this.b == paramSession.b) && (this.c == paramSession.c) && (ad.a(this.d, paramSession.d)) && (ad.a(this.e, paramSession.e)) && (ad.a(this.f, paramSession.f)) && (ad.a(this.h, paramSession.h)) && (this.g == paramSession.g);
    }

    public long a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof Session)) && (a((Session) paramObject)));
    }

    public int f() {
        return this.g;
    }

    public a g() {
        return this.h;
    }

    int h() {
        return this.a;
    }

    public int hashCode() {
        return ad.a(new Object[]{Long.valueOf(this.b), Long.valueOf(this.c), this.d, this.e, Integer.valueOf(this.g), this.h, this.f});
    }

    public String toString() {
        return ad.a(this).a("startTime", Long.valueOf(this.b)).a("endTime", Long.valueOf(this.c)).a("name", this.d).a("identifier", this.e).a("description", this.f).a("activity", Integer.valueOf(this.g)).a("application", this.h).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        r.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */