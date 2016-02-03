package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class il
        implements SafeParcelable {
    public static final Parcelable.Creator<il> CREATOR = new oq();
    private final int a;
    private double b;
    private boolean c;
    private int d;
    private ApplicationMetadata e;
    private int f;

    public il() {
        this(3, NaN .0D, false, -1, null, -1);
    }

    il(int paramInt1, double paramDouble, boolean paramBoolean, int paramInt2, ApplicationMetadata paramApplicationMetadata, int paramInt3) {
        this.a = paramInt1;
        this.b = paramDouble;
        this.c = paramBoolean;
        this.d = paramInt2;
        this.e = paramApplicationMetadata;
        this.f = paramInt3;
    }

    public int a() {
        return this.a;
    }

    public double b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof il)) {
                return false;
            }
            paramObject = (il) paramObject;
        }
        while ((this.b == ((il) paramObject).b) && (this.c == ((il) paramObject).c) && (this.d == ((il) paramObject).d) && (op.a(this.e, ((il) paramObject).e)) && (this.f == ((il) paramObject).f));
        return false;
    }

    public ApplicationMetadata f() {
        return this.e;
    }

    public int hashCode() {
        return ad.a(new Object[]{Double.valueOf(this.b), Boolean.valueOf(this.c), Integer.valueOf(this.d), this.e, Integer.valueOf(this.f)});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        oq.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */