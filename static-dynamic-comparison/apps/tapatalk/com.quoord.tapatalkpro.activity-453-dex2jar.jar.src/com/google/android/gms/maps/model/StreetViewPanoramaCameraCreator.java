package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class StreetViewPanoramaCameraCreator
        implements Parcelable.Creator<StreetViewPanoramaCamera> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramStreetViewPanoramaCamera.getVersionCode());
        b.a(paramParcel, 2, paramStreetViewPanoramaCamera.zoom);
        b.a(paramParcel, 3, paramStreetViewPanoramaCamera.tilt);
        b.a(paramParcel, 4, paramStreetViewPanoramaCamera.bearing);
        b.F(paramParcel, paramInt);
    }

    public StreetViewPanoramaCamera createFromParcel(Parcel paramParcel) {
        float f3 = 0.0F;
        int j = a.o(paramParcel);
        float f1 = 0.0F;
        int i = 0;
        float f2 = 0.0F;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    f1 = a.k(paramParcel, k);
                    break;
                case 3:
                    f2 = a.k(paramParcel, k);
                    break;
                case 4:
                    f3 = a.k(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new StreetViewPanoramaCamera(i, f1, f2, f3);
    }

    public StreetViewPanoramaCamera[] newArray(int paramInt) {
        return new StreetViewPanoramaCamera[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaCameraCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */