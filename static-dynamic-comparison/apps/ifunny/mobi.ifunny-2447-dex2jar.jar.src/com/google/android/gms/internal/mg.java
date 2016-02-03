package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class mg
        implements SafeParcelable {
    public static final rc CREATOR = new rc();
    private final int a;
    private final int b;
    private final int c;
    private final mi d;

    mg(int paramInt1, int paramInt2, int paramInt3, mi parammi) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = parammi;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public mi d() {
        return this.d;
    }

    public int describeContents() {
        rc localrc = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof mg)) {
                return false;
            }
            paramObject = (mg) paramObject;
        }
        while ((this.b == ((mg) paramObject).b) && (this.c == ((mg) paramObject).c) && (this.d.equals(((mg) paramObject).d)));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    public String toString() {
        return ad.a(this).a("transitionTypes", Integer.valueOf(this.b)).a("loiteringTimeMillis", Integer.valueOf(this.c)).a("placeFilter", this.d).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        rc localrc = CREATOR;
        rc.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */