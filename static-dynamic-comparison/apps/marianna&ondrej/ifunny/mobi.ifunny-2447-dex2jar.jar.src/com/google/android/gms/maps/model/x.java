package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class x
        implements Parcelable.Creator<StreetViewPanoramaOrientation> {
    static void a(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramStreetViewPanoramaOrientation.a());
        c.a(paramParcel, 2, paramStreetViewPanoramaOrientation.a);
        c.a(paramParcel, 3, paramStreetViewPanoramaOrientation.b);
        c.a(paramParcel, paramInt);
    }

    public StreetViewPanoramaOrientation a(Parcel paramParcel) {
        float f2 = 0.0F;
        int j = a.b(paramParcel);
        int i = 0;
        float f1 = 0.0F;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    f1 = a.l(paramParcel, k);
                    break;
                case 3:
                    f2 = a.l(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new StreetViewPanoramaOrientation(i, f1, f2);
    }

    public StreetViewPanoramaOrientation[] a(int paramInt) {
        return new StreetViewPanoramaOrientation[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */