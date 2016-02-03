package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class v
        implements Parcelable.Creator<StreetViewPanoramaLink> {
    static void a(StreetViewPanoramaLink paramStreetViewPanoramaLink, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramStreetViewPanoramaLink.a());
        c.a(paramParcel, 2, paramStreetViewPanoramaLink.a, false);
        c.a(paramParcel, 3, paramStreetViewPanoramaLink.b);
        c.a(paramParcel, paramInt);
    }

    public StreetViewPanoramaLink a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        String str = null;
        float f = 0.0F;
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
                    str = a.o(paramParcel, k);
                    break;
                case 3:
                    f = a.l(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new StreetViewPanoramaLink(i, str, f);
    }

    public StreetViewPanoramaLink[] a(int paramInt) {
        return new StreetViewPanoramaLink[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */