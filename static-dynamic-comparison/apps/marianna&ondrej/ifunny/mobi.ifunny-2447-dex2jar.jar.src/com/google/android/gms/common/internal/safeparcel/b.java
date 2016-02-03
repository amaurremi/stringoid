package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public class b
        extends RuntimeException {
    public b(String paramString, Parcel paramParcel) {
        super(paramString + " Parcel: pos=" + paramParcel.dataPosition() + " size=" + paramParcel.dataSize());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/safeparcel/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */