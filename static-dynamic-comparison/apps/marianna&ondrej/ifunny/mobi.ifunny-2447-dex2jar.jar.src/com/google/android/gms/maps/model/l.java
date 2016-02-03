package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class l {
    static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramLatLngBounds.a());
        c.a(paramParcel, 2, paramLatLngBounds.a, paramInt, false);
        c.a(paramParcel, 3, paramLatLngBounds.b, paramInt, false);
        c.a(paramParcel, i);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */