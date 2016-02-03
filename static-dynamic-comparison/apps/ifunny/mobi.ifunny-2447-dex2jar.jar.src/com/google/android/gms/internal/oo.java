package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class oo
        implements SafeParcelable {
    public static final Parcelable.Creator<oo> CREATOR = new sj();
    String[] a;
    byte[][] b;
    private final int c;

    oo() {
        this(1, new String[0], new byte[0][]);
    }

    oo(int paramInt, String[] paramArrayOfString, byte[][] paramArrayOfByte) {
        this.c = paramInt;
        this.a = paramArrayOfString;
        this.b = paramArrayOfByte;
    }

    public int a() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        sj.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/oo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */