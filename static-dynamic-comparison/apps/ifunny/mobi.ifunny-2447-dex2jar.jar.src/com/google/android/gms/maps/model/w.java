package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class w
        implements Parcelable.Creator<StreetViewPanoramaLocation> {
    static void a(StreetViewPanoramaLocation paramStreetViewPanoramaLocation, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramStreetViewPanoramaLocation.a());
        c.a(paramParcel, 2, paramStreetViewPanoramaLocation.a, paramInt, false);
        c.a(paramParcel, 3, paramStreetViewPanoramaLocation.b, paramInt, false);
        c.a(paramParcel, 4, paramStreetViewPanoramaLocation.c, false);
        c.a(paramParcel, i);
    }

    public StreetViewPanoramaLocation a(Parcel paramParcel) {
        String str = null;
        int j = a.b(paramParcel);
        int i = 0;
        Object localObject2 = null;
        Object localObject1 = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            Object localObject3;
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    localObject3 = localObject2;
                    localObject2 = localObject1;
                    localObject1 = localObject3;
            }
            for (; ; ) {
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject3;
                break;
                i = a.g(paramParcel, k);
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
                continue;
                localObject3 = (StreetViewPanoramaLink[]) a.b(paramParcel, k, StreetViewPanoramaLink.CREATOR);
                localObject1 = localObject2;
                localObject2 = localObject3;
                continue;
                localObject3 = (LatLng) a.a(paramParcel, k, LatLng.CREATOR);
                localObject2 = localObject1;
                localObject1 = localObject3;
                continue;
                str = a.o(paramParcel, k);
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new StreetViewPanoramaLocation(i, (StreetViewPanoramaLink[]) localObject1, (LatLng) localObject2, str);
    }

    public StreetViewPanoramaLocation[] a(int paramInt) {
        return new StreetViewPanoramaLocation[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */