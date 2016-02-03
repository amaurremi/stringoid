package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class u
        implements Parcelable.Creator<StreetViewPanoramaCamera> {
    static void a(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramStreetViewPanoramaCamera.a());
        c.a(paramParcel, 2, paramStreetViewPanoramaCamera.a);
        c.a(paramParcel, 3, paramStreetViewPanoramaCamera.b);
        c.a(paramParcel, 4, paramStreetViewPanoramaCamera.c);
        c.a(paramParcel, paramInt);
    }

    public StreetViewPanoramaCamera a(Parcel paramParcel) {
        float f3 = 0.0F;
        int j = a.b(paramParcel);
        float f1 = 0.0F;
        int i = 0;
        float f2 = 0.0F;
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
                    break;
                case 4:
                    f3 = a.l(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new StreetViewPanoramaCamera(i, f1, f2, f3);
    }

    public StreetViewPanoramaCamera[] a(int paramInt) {
        return new StreetViewPanoramaCamera[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */