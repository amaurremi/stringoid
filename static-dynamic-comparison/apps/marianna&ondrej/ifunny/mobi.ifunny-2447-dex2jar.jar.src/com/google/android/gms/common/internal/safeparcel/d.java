package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public final class d {
    public static <T extends SafeParcelable> byte[] a(T paramT) {
        Parcel localParcel = Parcel.obtain();
        paramT.writeToParcel(localParcel, 0);
        paramT = localParcel.marshall();
        localParcel.recycle();
        return paramT;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/safeparcel/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */