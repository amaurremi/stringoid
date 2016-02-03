package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.concurrent.TimeUnit;

public final class mm
        implements SafeParcelable {
    public static final rf CREATOR = new rf();
    static final long a = TimeUnit.HOURS.toMillis(1L);
    final int b;
    private final mi c;
    private final long d;
    private final int e;

    public mm(int paramInt1, mi parammi, long paramLong, int paramInt2) {
        this.b = paramInt1;
        this.c = parammi;
        this.d = paramLong;
        this.e = paramInt2;
    }

    public mi a() {
        return this.c;
    }

    public long b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public int describeContents() {
        rf localrf = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof mm)) {
                return false;
            }
            paramObject = (mm) paramObject;
        }
        while ((ad.a(this.c, ((mm) paramObject).c)) && (this.d == ((mm) paramObject).d) && (this.e == ((mm) paramObject).e));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.c, Long.valueOf(this.d), Integer.valueOf(this.e)});
    }

    public String toString() {
        return ad.a(this).a("filter", this.c).a("interval", Long.valueOf(this.d)).a("priority", Integer.valueOf(this.e)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        rf localrf = CREATOR;
        rf.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */