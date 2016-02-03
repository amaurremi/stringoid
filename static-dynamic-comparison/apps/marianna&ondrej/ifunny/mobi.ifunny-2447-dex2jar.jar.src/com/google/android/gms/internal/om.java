package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class om
        implements SafeParcelable {
    public static final Parcelable.Creator<om> CREATOR = new si();
    int[] a;
    private final int b;

    om() {
        this(1, null);
    }

    om(int paramInt, int[] paramArrayOfInt) {
        this.b = paramInt;
        this.a = paramArrayOfInt;
    }

    public int a() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        si.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/om.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */