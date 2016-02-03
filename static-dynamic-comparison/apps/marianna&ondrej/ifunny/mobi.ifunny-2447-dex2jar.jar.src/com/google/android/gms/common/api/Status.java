package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status
        implements r, SafeParcelable {
    public static final u CREATOR = new u();
    public static final Status a = new Status(0);
    public static final Status b = new Status(14);
    public static final Status c = new Status(8);
    public static final Status d = new Status(15);
    public static final Status e = new Status(16);
    private final int f;
    private final int g;
    private final String h;
    private final PendingIntent i;

    public Status(int paramInt) {
        this(1, paramInt, null, null);
    }

    Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent) {
        this.f = paramInt1;
        this.g = paramInt2;
        this.h = paramString;
        this.i = paramPendingIntent;
    }

    public Status(int paramInt, String paramString, PendingIntent paramPendingIntent) {
        this(1, paramInt, paramString, paramPendingIntent);
    }

    private String g() {
        if (this.h != null) {
            return this.h;
        }
        return j.a(this.g);
    }

    public Status a() {
        return this;
    }

    PendingIntent b() {
        return this.i;
    }

    public String c() {
        return this.h;
    }

    int d() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.g <= 0;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof Status)) {
        }
        do {
            return false;
            paramObject = (Status) paramObject;
        }
        while ((this.f != ((Status) paramObject).f) || (this.g != ((Status) paramObject).g) || (!ad.a(this.h, ((Status) paramObject).h)) || (!ad.a(this.i, ((Status) paramObject).i)));
        return true;
    }

    public int f() {
        return this.g;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.g), this.h, this.i});
    }

    public String toString() {
        return ad.a(this).a("statusCode", g()).a("resolution", this.i).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        u.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */