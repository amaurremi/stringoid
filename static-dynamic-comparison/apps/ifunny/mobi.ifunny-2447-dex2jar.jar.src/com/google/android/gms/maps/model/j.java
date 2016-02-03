package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.c;

public class j {
    static void a(GroundOverlayOptions paramGroundOverlayOptions, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramGroundOverlayOptions.b());
        c.a(paramParcel, 2, paramGroundOverlayOptions.a(), false);
        c.a(paramParcel, 3, paramGroundOverlayOptions.c(), paramInt, false);
        c.a(paramParcel, 4, paramGroundOverlayOptions.d());
        c.a(paramParcel, 5, paramGroundOverlayOptions.e());
        c.a(paramParcel, 6, paramGroundOverlayOptions.f(), paramInt, false);
        c.a(paramParcel, 7, paramGroundOverlayOptions.g());
        c.a(paramParcel, 8, paramGroundOverlayOptions.h());
        c.a(paramParcel, 9, paramGroundOverlayOptions.l());
        c.a(paramParcel, 10, paramGroundOverlayOptions.i());
        c.a(paramParcel, 11, paramGroundOverlayOptions.j());
        c.a(paramParcel, 12, paramGroundOverlayOptions.k());
        c.a(paramParcel, i);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */