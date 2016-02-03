package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class lr
        implements SafeParcelable {
    public static final qx CREATOR = new qx();
    public final int a;
    public final String b;
    private final int c;

    lr(int paramInt1, int paramInt2, String paramString) {
        this.c = paramInt1;
        this.a = paramInt2;
        this.b = paramString;
    }

    int a() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof lr)) {
        }
        do {
            return false;
            paramObject = (lr) paramObject;
        } while ((((lr) paramObject).a != this.a) || (!ad.a(((lr) paramObject).b, this.b)));
        return true;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.a), this.b});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        qx.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */