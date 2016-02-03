package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class LatLngBoundsCreator
        implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramLatLngBounds.getVersionCode());
        b.a(paramParcel, 2, paramLatLngBounds.southwest, paramInt, false);
        b.a(paramParcel, 3, paramLatLngBounds.northeast, paramInt, false);
        b.F(paramParcel, i);
    }

    public LatLngBounds createFromParcel(Parcel paramParcel) {
        LatLng localLatLng1 = null;
        int j = a.o(paramParcel);
        int i = 0;
        LatLng localLatLng2 = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                i = a.g(paramParcel, k);
                continue;
                localLatLng2 = (LatLng) a.a(paramParcel, k, LatLng.CREATOR);
                continue;
                localLatLng1 = (LatLng) a.a(paramParcel, k, LatLng.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new LatLngBounds(i, localLatLng2, localLatLng1);
    }

    public LatLngBounds[] newArray(int paramInt) {
        return new LatLngBounds[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/LatLngBoundsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */